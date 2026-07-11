package com.slideindex.app.settings

import kotlinx.serialization.Serializable

@Serializable
data class SettingsBackupDocument(
    val formatVersion: Int,
    val exportedAtEpochMs: Long,
    val appVersionName: String,
    val preferences: List<SettingsPreferenceEntry>,
)

@Serializable
data class SettingsPreferenceEntry(
    val key: String,
    val type: String,
    val value: String,
    val values: List<String> = emptyList(),
)
