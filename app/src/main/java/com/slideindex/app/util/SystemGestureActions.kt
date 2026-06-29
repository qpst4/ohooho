package com.slideindex.app.util

import android.content.Context
import android.content.res.Resources
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.provider.Settings
import android.util.Log
import kotlin.math.roundToInt

/** Applies brightness to the overlay window (preview only when system write is unavailable). */
fun interface OverlayBrightnessControl {
    fun apply(fraction: Float?)
}

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

class ContinuousAdjustController(
    context: Context,
    private val overlayBrightness: OverlayBrightnessControl? = null,
) {
    enum class Mode { VOLUME, BRIGHTNESS }

    private val appContext = context.applicationContext
    private val audioManager = appContext.getSystemService(AudioManager::class.java)
    private var activeMode: Mode? = null
    private var anchorRawY = 0f
    private var baselineFraction = 0f
    private var lastBrightnessFraction = Float.NaN

    fun begin(mode: Mode, rawY: Float): Boolean {
        if (!hasPermission(mode)) return false
        activeMode = mode
        anchorRawY = rawY
        baselineFraction = readFraction(mode)
        return true
    }

    fun update(mode: Mode, rawY: Float) {
        if (activeMode != mode) return
        applyFraction(mode, fractionFor(rawY))
    }

    fun end() {
        if (activeMode == Mode.BRIGHTNESS && !lastBrightnessFraction.isNaN()) {
            val fraction = lastBrightnessFraction.coerceIn(0f, 1f)
            if (syncSystemBrightness(fraction)) {
                overlayBrightness?.apply(null)
            }
        }
        activeMode = null
        lastBrightnessFraction = Float.NaN
    }

    private fun fractionFor(rawY: Float): Float {
        val span = appContext.resources.displayMetrics.heightPixels.coerceAtLeast(1) * ADJUST_SPAN_SCREEN_FRACTION
        val delta = (anchorRawY - rawY) / span
        return (baselineFraction + delta).coerceIn(0f, 1f)
    }

    private fun hasPermission(mode: Mode): Boolean = when (mode) {
        Mode.VOLUME -> PermissionHelper.hasNotificationPolicyAccess(appContext)
        Mode.BRIGHTNESS -> true
    }

    private fun readFraction(mode: Mode): Float = when (mode) {
        Mode.VOLUME -> {
            val stream = AudioManager.STREAM_MUSIC
            val max = audioManager?.getStreamMaxVolume(stream) ?: 0
            if (max <= 0) 0f else (audioManager?.getStreamVolume(stream) ?: 0).toFloat() / max
        }
        Mode.BRIGHTNESS -> readSystemBrightnessFraction()
    }

    private fun readSystemBrightnessFraction(): Float {
        if (!lastBrightnessFraction.isNaN()) {
            return lastBrightnessFraction.coerceIn(0f, 1f)
        }
        val max = systemBrightnessMax()
        val min = systemBrightnessMin()
        val current = Settings.System.getInt(
            appContext.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            (DEFAULT_BRIGHTNESS_FRACTION * max).roundToInt(),
        )
        return ((current - min).toFloat() / (max - min).coerceAtLeast(1)).coerceIn(0f, 1f)
    }

    private fun applyFraction(mode: Mode, fraction: Float) {
        when (mode) {
            Mode.VOLUME -> applyVolume(fraction)
            Mode.BRIGHTNESS -> applyBrightness(fraction)
        }
    }

    private fun applyVolume(fraction: Float) {
        val manager = audioManager ?: return
        val stream = AudioManager.STREAM_MUSIC
        val max = manager.getStreamMaxVolume(stream)
        if (max <= 0) return
        val level = (fraction * max).roundToInt().coerceIn(0, max)
        if (level == manager.getStreamVolume(stream)) return
        manager.setStreamVolume(stream, level, 0)
    }

    private fun applyBrightness(fraction: Float) {
        val clamped = fraction.coerceIn(0f, 1f)
        if (lastBrightnessFraction == clamped) return
        lastBrightnessFraction = clamped
        // Preview via overlay only while dragging; system write on release avoids
        // fighting the async Settings pipeline (visible flicker when increasing).
        overlayBrightness?.apply(clamped.coerceAtLeast(MIN_WINDOW_BRIGHTNESS))
    }

    private fun syncSystemBrightness(fraction: Float): Boolean {
        val max = systemBrightnessMax()
        val min = systemBrightnessMin()
        val target = (min + fraction * (max - min)).roundToInt().coerceIn(min, max)
        var synced = false

        if (TaskManagerUtil.hasPermission()) {
            synced = TaskManagerUtil.runShellCommand(
                "settings", "put", "system", "screen_brightness_mode", "0",
            ) && TaskManagerUtil.runShellCommand(
                "settings", "put", "system", "screen_brightness", target.toString(),
            )
        }

        if (PermissionHelper.canWriteSettings(appContext)) {
            runCatching {
                val resolver = appContext.contentResolver
                Settings.System.putInt(
                    resolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL,
                )
                synced = Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, target) || synced
            }.onFailure { error ->
                Log.w(TAG, "system brightness write failed", error)
            }
        }

        if (synced) {
            Log.d(TAG, "system brightness set to $target (max=$max, fraction=$fraction)")
        }
        return synced
    }

    private fun systemBrightnessMax(): Int {
        val resId = Resources.getSystem().getIdentifier(
            "config_screenBrightnessSettingMaximum",
            "integer",
            "android",
        )
        if (resId != 0) {
            return Resources.getSystem().getInteger(resId).coerceAtLeast(255)
        }
        val current = Settings.System.getInt(
            appContext.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            128,
        )
        return if (current > 255) 4095 else 255
    }

    private fun systemBrightnessMin(): Int {
        val resId = Resources.getSystem().getIdentifier(
            "config_screenBrightnessSettingMinimum",
            "integer",
            "android",
        )
        if (resId != 0) {
            return Resources.getSystem().getInteger(resId).coerceAtLeast(1)
        }
        return 1
    }

    companion object {
        private const val TAG = "ContinuousAdjustController"
        private const val DEFAULT_BRIGHTNESS_FRACTION = 0.5f
        private const val MIN_WINDOW_BRIGHTNESS = 0.01f
        private const val ADJUST_SPAN_SCREEN_FRACTION = 0.5f
    }
}
