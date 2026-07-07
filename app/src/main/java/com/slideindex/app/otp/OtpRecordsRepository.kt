package com.slideindex.app.otp

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.File

class OtpRecordsRepository(context: Context) {
    private val appContext = context.applicationContext
    private val recordsFile = File(appContext.filesDir, RECORDS_FILE_NAME)
    private val mutex = Mutex()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val _records = MutableStateFlow<List<OtpRecord>>(emptyList())
    val records: StateFlow<List<OtpRecord>> = _records.asStateFlow()

    init {
        scope.launch {
            mutex.withLock {
                val loaded = readFromDisk()
                val trimmed = loaded.take(MAX_RECORDS)
                if (trimmed.size != loaded.size) {
                    writeToDisk(trimmed)
                }
                _records.value = trimmed
            }
        }
    }

    fun record(
        code: String,
        packageName: String,
        title: String,
        text: String,
        timestampMs: Long = System.currentTimeMillis(),
        ruleName: String? = null,
        isTest: Boolean = false,
    ) {
        scope.launch {
            mutex.withLock {
                val current = readFromDisk()
                val isDuplicate = current.any { existing ->
                    existing.code == code &&
                        existing.packageName == packageName &&
                        (timestampMs - existing.timestampMs) in 0..DEDUPE_WINDOW_MS
                }
                if (isDuplicate) return@withLock

                val entry = OtpRecord(
                    code = code,
                    packageName = packageName,
                    title = title,
                    text = text,
                    timestampMs = timestampMs,
                    ruleName = ruleName,
                    isTest = isTest,
                )
                val next = listOf(entry) + current
                val trimmed = next.take(MAX_RECORDS)
                writeToDisk(trimmed)
                _records.value = trimmed
            }
        }
    }

    fun delete(id: String) {
        scope.launch {
            mutex.withLock {
                val next = readFromDisk().filterNot { it.id == id }
                writeToDisk(next)
                _records.value = next
            }
        }
    }

    fun clearAll() {
        scope.launch {
            mutex.withLock {
                writeToDisk(emptyList())
                _records.value = emptyList()
            }
        }
    }

    private suspend fun readFromDisk(): List<OtpRecord> = withContext(Dispatchers.IO) {
        if (!recordsFile.exists()) return@withContext emptyList()
        runCatching {
            OtpRecordCodec.decode(recordsFile.readText())
        }.getOrDefault(emptyList())
    }

    private suspend fun writeToDisk(items: List<OtpRecord>) = withContext(Dispatchers.IO) {
        recordsFile.writeText(OtpRecordCodec.encode(items))
    }

    companion object {
        private const val RECORDS_FILE_NAME = "otp_records.json"
        const val MAX_RECORDS = 200
        private const val DEDUPE_WINDOW_MS = 60_000L
    }
}
