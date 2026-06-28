package com.slideindex.app.util

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.provider.Settings
import android.util.Log
import kotlin.math.roundToInt

object FlashlightHelper {
    private var torchOn = false

    fun toggle(context: Context): Boolean {
        val cameraManager = context.getSystemService(CameraManager::class.java) ?: return false
        val cameraId = cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id)
                .get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        } ?: return false
        return runCatching {
            torchOn = !torchOn
            cameraManager.setTorchMode(cameraId, torchOn)
            true
        }.getOrElse { error ->
            Log.e(TAG, "toggle flashlight failed", error)
            torchOn = !torchOn
            false
        }
    }

    private const val TAG = "FlashlightHelper"
}

class ContinuousAdjustController(context: Context) {
    enum class Mode { VOLUME, BRIGHTNESS }

    private val appContext = context.applicationContext
    private val audioManager = appContext.getSystemService(AudioManager::class.java)
    private var activeMode: Mode? = null

    fun begin(mode: Mode, rawY: Float) {
        activeMode = mode
        apply(mode, rawY)
    }

    fun update(mode: Mode, rawY: Float) {
        if (activeMode != mode) return
        apply(mode, rawY)
    }

    fun end() {
        activeMode = null
    }

    private fun apply(mode: Mode, rawY: Float) {
        val screenHeight = appContext.resources.displayMetrics.heightPixels.coerceAtLeast(1)
        val fraction = 1f - (rawY / screenHeight.toFloat()).coerceIn(0f, 1f)
        when (mode) {
            Mode.VOLUME -> applyVolume(fraction)
            Mode.BRIGHTNESS -> applyBrightness(fraction)
        }
    }

    private fun applyVolume(fraction: Float) {
        val stream = AudioManager.STREAM_MUSIC
        val max = audioManager.getStreamMaxVolume(stream)
        val level = (fraction * max).roundToInt().coerceIn(0, max)
        audioManager.setStreamVolume(stream, level, 0)
    }

    private fun applyBrightness(fraction: Float) {
        val target = (fraction * 255f).roundToInt().coerceIn(1, 255)
        if (Settings.System.canWrite(appContext)) {
            Settings.System.putInt(
                appContext.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                target,
            )
        } else {
            Log.w(TAG, "WRITE_SETTINGS not granted, brightness gesture skipped")
        }
    }

    companion object {
        private const val TAG = "ContinuousAdjustController"
    }
}
