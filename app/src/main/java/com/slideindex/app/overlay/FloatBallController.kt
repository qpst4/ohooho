package com.slideindex.app.overlay

import android.content.Context
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.util.PermissionHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/** Syncs FV-style float ball visibility with accessibility service lifecycle and settings. */
class FloatBallController(
    private val context: Context,
    private val scope: CoroutineScope,
    private val settingsRepository: SettingsRepository,
) {
    fun apply(settings: AppSettings) {
        if (!PermissionHelper.isAccessibilityServiceEnabled(context)) {
            FloatBallOverlay.dismiss()
            return
        }
        if (settings.floatBallEnabled) {
            FloatBallOverlay.showOrUpdate(
                context = context,
                settings = settings,
                onPositionPersisted = { xFraction, yFraction ->
                    scope.launch {
                        settingsRepository.setFloatBallPosition(xFraction, yFraction)
                    }
                },
                onActiveSidePersisted = { side ->
                    scope.launch {
                        settingsRepository.setFloatBallActiveSide(side)
                    }
                },
            )
        } else {
            FloatBallOverlay.dismiss()
        }
    }

    fun onConfigurationChanged() {
        if (FloatBallOverlay.isShowing) {
            FloatBallOverlay.relayout()
        }
    }

    fun stop() {
        FloatBallOverlay.dismiss()
    }
}
