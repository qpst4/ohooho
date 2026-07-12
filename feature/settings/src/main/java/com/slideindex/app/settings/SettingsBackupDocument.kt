package com.slideindex.app.settings

import kotlinx.serialization.Serializable

@Serializable
data class SettingsBackupDocument(
    val formatVersion: Int,
    val exportedAtEpochMs: Long,
    val appVersionName: String,
    val preferences: List<SettingsPreferenceEntry>,
    val otpRecordsJson: String? = null,
    val notificationHistoryJson: String? = null,
)

@Serializable
data class SensitiveBackupSections(
    val otpRecordsJson: String? = null,
    val notificationHistoryJson: String? = null,
) {
    val hasAny: Boolean get() = !otpRecordsJson.isNullOrBlank() || !notificationHistoryJson.isNullOrBlank()
}

data class SettingsBackupImportResult(
    val preferencesImported: Int,
    val sensitive: SensitiveBackupSections,
)

@Serializable
data class SettingsPreferenceEntry(
    val key: String,
    val type: String,
    val value: String,
    val values: List<String> = emptyList(),
)
