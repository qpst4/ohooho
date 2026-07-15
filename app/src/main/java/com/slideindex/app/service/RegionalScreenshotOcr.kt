package com.slideindex.app.service

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import android.graphics.Rect
import android.hardware.HardwareBuffer
import android.os.Build
import android.util.Log
import android.view.Display
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions
import com.google.mlkit.vision.text.TextRecognition
import com.slideindex.app.overlay.FloatBallOcrRegions
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

/**
 * API 30+ regional screenshot via [AccessibilityService.takeScreenshot], then ML Kit OCR.
 */
object RegionalScreenshotOcr {
    private const val TAG = "RegionalScreenshotOcr"

    private val screenshotExecutor = Executors.newSingleThreadExecutor()
    private val textRecognizer by lazy {
        TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build())
    }

    suspend fun captureRectBitmap(
        service: AccessibilityService,
        screenRect: Rect,
    ): Bitmap? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) return null
        val fullBitmap = captureDisplayBitmap(service) ?: return null
        return try {
            cropBitmap(fullBitmap, screenRect)
        } finally {
            fullBitmap.recycle()
        }
    }

    suspend fun recognizeInRect(
        service: AccessibilityService,
        screenRect: Rect,
    ): String? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) return null
        val cropped = captureRectBitmap(service, screenRect) ?: return null
        return try {
            recognizeBitmap(cropped)?.trim()?.takeIf { it.isNotEmpty() }
        } finally {
            cropped.recycle()
        }
    }

    suspend fun recognizeBitmapPublic(bitmap: Bitmap): String? =
        recognizeBitmap(bitmap)?.trim()?.takeIf { it.isNotEmpty() }

    private fun cropBitmap(fullBitmap: Bitmap, screenRect: Rect): Bitmap? {
        val cropRect = FloatBallOcrRegions.clampToScreen(
            Rect(screenRect),
            fullBitmap.width,
            fullBitmap.height,
        )
        if (cropRect.width() <= 0 || cropRect.height() <= 0) return null
        return Bitmap.createBitmap(
            fullBitmap,
            cropRect.left,
            cropRect.top,
            cropRect.width(),
            cropRect.height(),
        )
    }

    private suspend fun captureDisplayBitmap(service: AccessibilityService): Bitmap? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) return null
        return suspendCancellableCoroutine { continuation ->
            service.takeScreenshot(
                Display.DEFAULT_DISPLAY,
                screenshotExecutor,
                object : AccessibilityService.TakeScreenshotCallback {
                    override fun onSuccess(result: AccessibilityService.ScreenshotResult) {
                        if (!continuation.isActive) {
                            closeHardwareBuffer(result.hardwareBuffer)
                            return
                        }
                        try {
                            val hardware = result.hardwareBuffer
                            val colorSpace = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                                result.colorSpace
                            } else {
                                null
                            }
                            val wrapped = Bitmap.wrapHardwareBuffer(hardware, colorSpace)
                            val software = wrapped?.copy(Bitmap.Config.ARGB_8888, false)
                            wrapped?.recycle()
                            continuation.resume(software)
                        } catch (error: Throwable) {
                            Log.w(TAG, "decode screenshot failed", error)
                            continuation.resume(null)
                        } finally {
                            closeHardwareBuffer(result.hardwareBuffer)
                        }
                    }

                    override fun onFailure(errorCode: Int) {
                        Log.w(TAG, "takeScreenshot failed: $errorCode")
                        if (continuation.isActive) continuation.resume(null)
                    }
                },
            )
        }
    }

    private suspend fun recognizeBitmap(bitmap: Bitmap): String? = suspendCancellableCoroutine { continuation ->
        val image = InputImage.fromBitmap(bitmap, 0)
        textRecognizer.process(image)
            .addOnSuccessListener { visionText ->
                if (continuation.isActive) {
                    continuation.resume(visionText.text)
                }
            }
            .addOnFailureListener { error ->
                Log.w(TAG, "mlkit ocr failed", error)
                if (continuation.isActive) continuation.resume(null)
            }
    }

    private fun closeHardwareBuffer(buffer: HardwareBuffer?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            runCatching { buffer?.close() }
        }
    }
}
