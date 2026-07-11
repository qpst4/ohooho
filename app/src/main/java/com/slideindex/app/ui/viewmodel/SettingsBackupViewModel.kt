package com.slideindex.app.ui.viewmodel

import android.content.Context
import android.net.Uri
import com.slideindex.app.BuildConfig
import com.slideindex.app.R
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

@HiltViewModel
class SettingsBackupViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    @ApplicationContext context: Context,
) : SettingsViewModel(settingsRepository, userMessageBus, context) {
    fun exportSettings(onReady: (String) -> Unit) {
        viewModelScope.launch {
            settingsRepository.exportSettings(BuildConfig.VERSION_NAME)
                .onSuccess { json -> onReady(json) }
                .onFailure {
                    userMessageBus.showError(
                        appContext.getString(R.string.settings_backup_export_failed),
                    )
                }
        }
    }

    fun importSettings(uri: Uri) {
        viewModelScope.launch {
            runCatching {
                appContext.contentResolver.openInputStream(uri)?.use { input ->
                    input.bufferedReader().readText()
                } ?: error("Unable to read backup file")
            }.fold(
                onSuccess = { rawJson ->
                    settingsRepository.importSettings(rawJson)
                        .onSuccess { count ->
                            userMessageBus.showSuccess(
                                appContext.getString(R.string.settings_backup_import_success, count),
                            )
                        }
                        .onFailure {
                            userMessageBus.showError(
                                appContext.getString(R.string.settings_backup_import_failed),
                            )
                        }
                },
                onFailure = {
                    userMessageBus.showError(
                        appContext.getString(R.string.settings_backup_import_failed),
                    )
                },
            )
        }
    }
}
