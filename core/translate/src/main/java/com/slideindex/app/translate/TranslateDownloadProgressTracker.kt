package com.slideindex.app.translate

import android.app.DownloadManager
import android.content.Context
import android.database.Cursor
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

data class TranslateDownloadProgress(
    val bytesDownloaded: Long,
    val totalBytes: Long?,
)

@Singleton
class TranslateDownloadProgressTracker @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    fun queryProgress(mlKitLanguage: String): TranslateDownloadProgress? {
        val manager = context.getSystemService(DownloadManager::class.java) ?: return null
        val query = DownloadManager.Query().setFilterByStatus(
            DownloadManager.STATUS_PENDING or
                DownloadManager.STATUS_RUNNING or
                DownloadManager.STATUS_PAUSED,
        )
        val cursor = manager.query(query) ?: return null
        cursor.use {
            while (it.moveToNext()) {
                val progress = readProgress(it, mlKitLanguage) ?: continue
                return progress
            }
        }
        return null
    }

    private fun readProgress(cursor: Cursor, mlKitLanguage: String): TranslateDownloadProgress? {
        val uri = cursor.getString(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_URI)).orEmpty()
        val title = cursor.getString(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TITLE)).orEmpty()
        if (!matchesLanguage(uri, title, mlKitLanguage)) return null

        val downloaded = cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
        val total = cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
            .takeIf { value -> value > 0L }
        return TranslateDownloadProgress(
            bytesDownloaded = downloaded.coerceAtLeast(0L),
            totalBytes = total,
        )
    }

    private fun matchesLanguage(uri: String, title: String, mlKitLanguage: String): Boolean {
        val needle = mlKitLanguage.lowercase()
        val haystacks = listOf(uri.lowercase(), title.lowercase())
        return haystacks.any { haystack ->
            haystack.contains("/$needle") ||
                haystack.contains("_$needle.") ||
                haystack.contains("${needle}_") ||
                haystack == "$needle.zip"
        }
    }
}
