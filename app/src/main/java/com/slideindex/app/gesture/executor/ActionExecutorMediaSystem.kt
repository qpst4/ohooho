package com.slideindex.app.gesture.executor

import android.content.Context
import com.slideindex.app.util.BrightnessControlHelper
import com.slideindex.app.util.ContinuousAdjustController
import com.slideindex.app.util.OverlayBrightnessControl
import com.slideindex.app.util.VolumeControlHelper

internal class ActionExecutorMediaSystem(
    private val context: Context,
    overlayBrightness: OverlayBrightnessControl?,
) {
    private val continuousAdjust = ContinuousAdjustController(context, overlayBrightness)

    fun beginContinuousAdjust(mode: ContinuousAdjustController.Mode, rawY: Float): Boolean =
        continuousAdjust.begin(mode, rawY)

    fun updateContinuousAdjust(mode: ContinuousAdjustController.Mode, rawY: Float) {
        continuousAdjust.update(mode, rawY)
    }

    fun endContinuousAdjust() {
        continuousAdjust.end()
    }

    fun applyAdjustOnce(
        mode: ContinuousAdjustController.Mode,
        anchorRawY: Float,
        targetRawY: Float,
    ): Float? = continuousAdjust.applyOnce(mode, anchorRawY, targetRawY)

    fun readCurrentAdjustFraction(mode: ContinuousAdjustController.Mode): Float =
        continuousAdjust.readCurrentFraction(mode)

    fun clearBrightnessPreview() {
        continuousAdjust.clearBrightnessPreview()
    }

    fun adjustMode(): ContinuousAdjustController.Mode? = continuousAdjust.currentMode()

    fun adjustFraction(): Float = continuousAdjust.currentFraction()

    fun readRingerMode(): Int = VolumeControlHelper.readRingerMode(context)

    fun cycleRingerMode(): Int? = VolumeControlHelper.cycleRingerMode(context)

    fun readInterruptionFilter(): Int = VolumeControlHelper.readInterruptionFilter(context)

    fun toggleDnd(): Int? = VolumeControlHelper.toggleDnd(context)

    fun readAutoBrightnessEnabled(): Boolean = BrightnessControlHelper.readAutoBrightnessEnabled(context)

    fun toggleAutoBrightness(): Boolean? = BrightnessControlHelper.toggleAutoBrightness(context)

    fun readDarkModeEnabled(): Boolean = BrightnessControlHelper.readDarkModeEnabled(context)

    fun toggleDarkMode(): Boolean? = BrightnessControlHelper.toggleDarkMode(context)

    fun readVolumeFraction(stream: VolumeControlHelper.Stream): Float =
        VolumeControlHelper.readFraction(context, stream)

    fun setVolumeFraction(stream: VolumeControlHelper.Stream, fraction: Float) {
        VolumeControlHelper.setFraction(context, stream, fraction)
    }

    fun setBrightnessFraction(fraction: Float, previewOnly: Boolean = false) {
        continuousAdjust.setFraction(
            ContinuousAdjustController.Mode.BRIGHTNESS,
            fraction,
            previewOnly = previewOnly,
        )
    }
}
