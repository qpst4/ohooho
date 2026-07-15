package com.slideindex.app.ocr

import android.graphics.Bitmap
import com.googlecode.tesseract.android.TessBaseAPI
import java.io.File

internal object TesseractTextRecognizer {
    private val lock = Any()
    private var api: TessBaseAPI? = null
    private var loadedModelId: String? = null

    fun recognize(modelId: String, dataRoot: File, bitmap: Bitmap): String? {
        synchronized(lock) {
            if (!ensureInitialized(modelId, dataRoot)) return null
            val tess = api ?: return null
            tess.setImage(bitmap)
            val text = tess.getUTF8Text().orEmpty()
            tess.clear()
            return text
                .lineSequence()
                .map { line -> line.trim() }
                .filter { line -> line.isNotEmpty() }
                .joinToString("\n")
                .trim()
                .takeIf { it.isNotEmpty() }
        }
    }

    fun close(modelId: String?) {
        synchronized(lock) {
            if (modelId != null && loadedModelId != modelId) return
            api?.recycle()
            api = null
            loadedModelId = null
        }
    }

    private fun ensureInitialized(modelId: String, dataRoot: File): Boolean {
        if (loadedModelId == modelId && api != null) return true
        api?.recycle()
        api = null
        loadedModelId = null

        val tess = TessBaseAPI()
        val initialized = tess.init(dataRoot.absolutePath, languagesFor(modelId))
        if (!initialized) {
            tess.recycle()
            return false
        }
        api = tess
        loadedModelId = modelId
        return true
    }

    private fun languagesFor(modelId: String): String = when (modelId) {
        "tesseract-chi-sim-eng" -> "chi_sim+eng"
        else -> "eng"
    }
}
