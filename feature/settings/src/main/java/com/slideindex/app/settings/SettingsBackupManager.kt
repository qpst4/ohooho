package com.slideindex.app.settings

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsBackupManager @Inject constructor(
    private val editor: SettingsPreferencesEditor,
) {
    suspend fun exportSettings(appVersionName: String): Result<String> = runCatching {
        val preferences = editor.readRawPreferences()
        SettingsBackupCodec.encode(preferences, appVersionName)
    }

    suspend fun importSettings(rawJson: String, replaceExisting: Boolean = true): Result<Int> = runCatching {
        val document = SettingsBackupCodec.decode(rawJson)
        SettingsBackupCodec.validate(document)
        editor.edit { prefs ->
            if (replaceExisting) {
                prefs.asMap().keys
                    .filter { it.name != SettingsPreferenceKeys.ONBOARDING_COMPLETED.name }
                    .forEach { key -> prefs.remove(key) }
            }
            SettingsBackupCodec.apply(document, prefs)
        }.getOrThrow()
        document.preferences.size
    }
}
