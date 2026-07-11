package com.slideindex.app

import android.graphics.Bitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onRoot
import androidx.test.platform.app.InstrumentationRegistry
import java.io.File
import java.io.FileOutputStream
import org.junit.Assert.assertTrue

object ScreenshotGolden {
    fun assertMatchesGolden(
        composeRule: ComposeTestRule,
        goldenName: String,
        minMatchingRatio: Float = 0.98f,
    ) {
        composeRule.waitForIdle()
        val bitmap = composeRule.onRoot().captureToImage().asAndroidBitmap()
        assertTrue(bitmap.width > 0)
        assertTrue(bitmap.height > 0)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val goldenFile = File(context.filesDir, "goldens/$goldenName.png")
        goldenFile.parentFile?.mkdirs()

        if (!goldenFile.exists()) {
            saveBitmap(bitmap, goldenFile)
            return
        }

        val expected = android.graphics.BitmapFactory.decodeFile(goldenFile.absolutePath)
        assertTrue(expected != null)
        val ratio = compareBitmaps(expected!!, bitmap)
        assertTrue(
            "Screenshot mismatch for $goldenName (match=$ratio)",
            ratio >= minMatchingRatio,
        )
    }

    private fun compareBitmaps(expected: Bitmap, actual: Bitmap): Float {
        if (expected.width != actual.width || expected.height != actual.height) {
            return 0f
        }
        var matching = 0
        val total = expected.width * expected.height
        for (x in 0 until expected.width) {
            for (y in 0 until expected.height) {
                if (expected.getPixel(x, y) == actual.getPixel(x, y)) {
                    matching++
                }
            }
        }
        return matching.toFloat() / total.toFloat()
    }

    private fun saveBitmap(bitmap: Bitmap, file: File) {
        FileOutputStream(file).use { stream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        }
    }
}
