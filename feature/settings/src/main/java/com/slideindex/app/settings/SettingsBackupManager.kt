package com.slideindex.app.settings

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsBackupManager @Inject constructor(
    private val editor: SettingsPreferencesEditor,
) {
    suspend fun exportSettings(
        appVersionName: String,
        sensitive: SensitiveBackupSections? = null,
    ): Result<String> = runCatching {
        val preferences = editor.readRawPreferences()
        SettingsBackupCodec.encode(preferences, appVersionName, sensitive)
    }

    suspend fun importSettings(
        rawJson: String,
        replaceExisting: Boolean = true,
    ): Result<SettingsBackupImportResult> = runCatching {
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
        SettingsBackupImportResult(
            preferencesImported = document.preferences.size,
            sensitive = SensitiveBackupSections(
                otpRecordsJson = document.otpRecordsJson,
                notificationHistoryJson = document.notificationHistoryJson,
            ),
        )
    }

    suspend fun previewImport(rawJson: String): Result<SettingsBackupPreview> = runCatching {
        val document = SettingsBackupCodec.decode(rawJson)
        SettingsBackupCodec.validate(document)
        val domains = document.preferences.map { mapPreferenceKeyToDomain(it.key) }.toSet()
        SettingsBackupPreview(
            formatVersion = document.formatVersion,
            exportedAtEpochMs = document.exportedAtEpochMs,
            appVersionName = document.appVersionName,
            totalPreferencesCount = document.preferences.size,
            domains = domains,
            hasOtpRecords = !document.otpRecordsJson.isNullOrBlank(),
            hasNotificationHistory = !document.notificationHistoryJson.isNullOrBlank(),
        )
    }
}
