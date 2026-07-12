package com.slideindex.app.overlay

import android.content.Context
import com.slideindex.app.gesture.PointerGesturePoint
import com.slideindex.app.gesture.PointerGestureRecording
import com.slideindex.app.gesture.PointerGestureRecordingCodec
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

@Singleton
class FloatingPointerGestureRepository @Inject constructor(
    @ApplicationContext context: Context,
) {
    private val gestureFile = File(context.applicationContext.filesDir, GESTURES_FILE_NAME)
    private val mutex = Mutex()

    private val _recordModeEnabled = MutableStateFlow(false)
    val recordModeEnabled: StateFlow<Boolean> = _recordModeEnabled.asStateFlow()

    fun setRecordModeEnabled(enabled: Boolean) {
        _recordModeEnabled.value = enabled
    }

    private val _recordings = MutableStateFlow<List<PointerGestureRecording>>(emptyList())
    val recordings: StateFlow<List<PointerGestureRecording>> = _recordings.asStateFlow()

    init {
        _recordings.value = readFromDiskSync()
    }

    suspend fun saveGesture(name: String, points: List<PointerGesturePoint>) {
        if (points.size < 2) return
        upsert(
            PointerGestureRecording(
                name = name,
                points = points.take(MAX_POINTS),
            ),
        )
    }

    suspend fun upsert(recording: PointerGestureRecording) {
        mutex.withLock {
            val next = _recordings.value
                .filterNot { it.id == recording.id } + recording
            writeToDisk(next)
            _recordings.value = next.sortedByDescending { it.createdAtEpochMs }
        }
    }

    suspend fun delete(id: String) {
        mutex.withLock {
            val next = _recordings.value.filterNot { it.id == id }
            writeToDisk(next)
            _recordings.value = next
        }
    }

    private fun readFromDiskSync(): List<PointerGestureRecording> = runCatching {
        if (!gestureFile.exists()) return emptyList()
        PointerGestureRecordingCodec.decodeAll(setOf(gestureFile.readText()))
    }.getOrDefault(emptyList()).sortedByDescending { it.createdAtEpochMs }

    private suspend fun writeToDisk(recordings: List<PointerGestureRecording>) = withContext(Dispatchers.IO) {
        gestureFile.writeText(
            recordings.joinToString("\u001F") { PointerGestureRecordingCodec.encode(it) },
        )
    }

    companion object {
        private const val GESTURES_FILE_NAME = "floating_pointer_gestures.json"
        const val MAX_POINTS = 120
    }
}
