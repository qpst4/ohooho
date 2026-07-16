package com.slideindex.app.translate

sealed class TranslateResult {
    data class Success(
        val translatedText: String,
        val detectedSourceLanguage: String? = null,
    ) : TranslateResult()

    data class Failure(val message: String) : TranslateResult()
}

enum class TranslateDownloadPhase {
    DOWNLOADING,
    READY,
    FAILED,
    CANCELLED,
}

data class TranslateDownloadState(
    val languageCode: String,
    val phase: TranslateDownloadPhase,
    val bytesDownloaded: Long = 0L,
    val totalBytes: Long? = null,
    val errorMessage: String? = null,
) {
    val progress: Float?
        get() = when {
            phase == TranslateDownloadPhase.READY -> 1f
            totalBytes != null && totalBytes > 0L ->
                (bytesDownloaded.toFloat() / totalBytes.toFloat()).coerceIn(0f, 0.99f)
            else -> null
        }
}
