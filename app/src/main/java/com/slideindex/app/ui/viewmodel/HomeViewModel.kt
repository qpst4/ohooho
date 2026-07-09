package com.slideindex.app.ui.viewmodel

import com.slideindex.app.SlideIndexApp
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus

interface HomeScreenEffects {
    fun refreshServiceState()
    fun requestNotificationPermission()
    fun requestShizuku()
    fun openAccessibilitySettings()
    fun previewHaptic(enabled: Boolean = true, strengthLevel: Int? = null)
}

class HomeViewModel(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    app: SlideIndexApp,
    private val effects: HomeScreenEffects,
) : SettingsViewModel(settingsRepository, userMessageBus, app) {
    fun setServiceEnabled(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setServiceEnabled(enabled).also { result ->
            if (result.isSuccess) {
                effects.refreshServiceState()
            }
        }
    }

    fun setHapticEnabled(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setHapticEnabled(enabled).also { result ->
            if (result.isSuccess && enabled) {
                effects.previewHaptic()
            }
        }
    }

    fun setHapticStrength(level: Int) = launchSettingsWrite {
        settingsRepository.setHapticStrengthLevel(level).also { result ->
            if (result.isSuccess) {
                effects.previewHaptic(strengthLevel = level)
            }
        }
    }

    fun setGestureHintEnabled(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setGestureHintEnabled(enabled)
    }

    fun setHideTriggerInLandscape(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setHideTriggerInLandscape(enabled)
    }

    fun setHideTriggerOnLockScreen(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setHideTriggerOnLockScreen(enabled)
    }

    fun setHideTriggerOnLauncher(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setHideTriggerOnLauncher(enabled)
    }

    fun setDynamicColorEnabled(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setDynamicColorEnabled(enabled)
    }

    fun setThemeColor(color: Int) = launchSettingsWrite {
        settingsRepository.setThemeColor(color)
    }

    fun requestNotificationPermission() = effects.requestNotificationPermission()

    fun requestShizuku() = effects.requestShizuku()

    fun openAccessibilitySettings() = effects.openAccessibilitySettings()
}
