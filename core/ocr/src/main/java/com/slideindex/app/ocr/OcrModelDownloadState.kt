package com.slideindex.app.ocr

enum class OcrModelDownloadPhase {
    DOWNLOADING,
    VERIFYING,
    FINALIZING,
    READY,
    FAILED,
    CANCELLED,
}

data class OcrModelDownloadState(
    val modelId: String,
    val phase: OcrModelDownloadPhase,
    val bytesDownloaded: Long = 0L,
    val totalBytes: Long? = null,
    val currentFileIndex: Int = 0,
    val totalFiles: Int = 0,
    val errorMessage: String? = null,
) {
    val progress: Float?
        get() = when {
            phase == OcrModelDownloadPhase.READY -> 1f
            phase == OcrModelDownloadPhase.VERIFYING -> 0.92f
            phase == OcrModelDownloadPhase.FINALIZING -> 0.97f
            totalBytes != null && totalBytes > 0L ->
                (bytesDownloaded.toFloat() / totalBytes.toFloat()).coerceIn(0f, 0.9f)
            else -> null
        }
}
