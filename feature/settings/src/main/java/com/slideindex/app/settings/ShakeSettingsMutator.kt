package com.slideindex.app.settings

import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.shake.ShakeGestureCodec
import com.slideindex.app.shake.ShakeGestureType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShakeSettingsMutator @Inject constructor(
    private val editor: SettingsPreferencesEditor,
) {
    suspend fun setShakeGesturesEnabled(enabled: Boolean) = editor.edit { it[SettingsPreferenceKeys.SHAKE_GESTURES_ENABLED] = enabled }

    suspend fun setShakeGestureAction(type: ShakeGestureType, action: GestureAction) = editor.edit { prefs ->
        val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
        val updated = current.basicActions.toMutableMap().apply { put(type, action) }
        prefs[SettingsPreferenceKeys.SHAKE_GESTURE_ACTIONS] = ShakeGestureCodec.encodeAllActions(updated)
    }

    suspend fun setLockScreenShakeAction(type: ShakeGestureType, action: GestureAction) = editor.edit { prefs ->
        val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
        val updated = current.lockScreenActions.toMutableMap().apply { put(type, action) }
        prefs[SettingsPreferenceKeys.SHAKE_LOCK_SCREEN_ACTIONS] = ShakeGestureCodec.encodeAllActions(updated)
    }

    suspend fun setPerAppShakeAction(packageName: String, type: ShakeGestureType, action: GestureAction) =
        editor.edit { prefs ->
            val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
            val perApp = current.perAppActions.toMutableMap()
            val appActions = perApp[packageName].orEmpty().toMutableMap().apply { put(type, action) }
            perApp[packageName] = appActions
            prefs[SettingsPreferenceKeys.SHAKE_PER_APP_ACTIONS] = ShakeGestureCodec.encodePerAppActions(perApp)
        }

    suspend fun addPerAppShakeConfig(packageName: String) = editor.edit { prefs ->
        val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
        if (packageName in current.perAppActions) return@edit
        val perApp = current.perAppActions.toMutableMap()
        perApp[packageName] = emptyMap()
        prefs[SettingsPreferenceKeys.SHAKE_PER_APP_ACTIONS] = ShakeGestureCodec.encodePerAppActions(perApp)
    }

    suspend fun removePerAppShakeConfig(packageName: String) = editor.edit { prefs ->
        val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
        val perApp = current.perAppActions.toMutableMap()
        perApp.remove(packageName)
        prefs[SettingsPreferenceKeys.SHAKE_PER_APP_ACTIONS] = ShakeGestureCodec.encodePerAppActions(perApp)
    }

    suspend fun setShakeDirectionSensitivity(type: ShakeGestureType, value: Float) = editor.edit { prefs ->
        val current = SettingsSnapshotReader.readShakeGestureSettings(prefs)
        val updated = current.perDirectionSensitivity.toMutableMap().apply {
            put(type, value.coerceIn(1f, 10f))
        }
        prefs[SettingsPreferenceKeys.SHAKE_PER_DIRECTION_SENSITIVITY] = ShakeGestureCodec.encodePerDirectionSensitivity(updated)
    }

    suspend fun setLockScreenShakeEnabled(enabled: Boolean) = editor.edit { it[SettingsPreferenceKeys.LOCK_SCREEN_SHAKE_ENABLED] = enabled }

    suspend fun setIndependentAppShakeEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.INDEPENDENT_APP_SHAKE_ENABLED] = enabled }

    suspend fun setShakeGlobalSensitivity(value: Float) = editor.edit {
        it[SettingsPreferenceKeys.SHAKE_GLOBAL_SENSITIVITY] = value.coerceIn(1f, 10f)
    }

    suspend fun setShakeIndependentSensitivityEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.SHAKE_INDEPENDENT_SENSITIVITY_ENABLED] = enabled }

    suspend fun setShakeVibrationFeedbackEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.SHAKE_VIBRATION_FEEDBACK_ENABLED] = enabled }

    suspend fun setShakeAnimationFeedbackEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.SHAKE_ANIMATION_FEEDBACK_ENABLED] = enabled }

    suspend fun setShakeAnimationColor(argb: Int) = editor.edit { it[SettingsPreferenceKeys.SHAKE_ANIMATION_COLOR] = argb }

    suspend fun setShakeDisableInLandscape(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.SHAKE_DISABLE_IN_LANDSCAPE] = enabled }

    suspend fun addShakeBlacklistedApp(packageName: String) = editor.edit {
        val current = it[SettingsPreferenceKeys.SHAKE_BLACKLIST_PACKAGES]?.toMutableSet() ?: mutableSetOf()
        current.add(packageName)
        it[SettingsPreferenceKeys.SHAKE_BLACKLIST_PACKAGES] = current
    }

    suspend fun removeShakeBlacklistedApp(packageName: String) = editor.edit {
        val current = it[SettingsPreferenceKeys.SHAKE_BLACKLIST_PACKAGES]?.toMutableSet() ?: return@edit
        current.remove(packageName)
        it[SettingsPreferenceKeys.SHAKE_BLACKLIST_PACKAGES] = current
    }
}
