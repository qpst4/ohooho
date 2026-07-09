package com.slideindex.app.ui.viewmodel

import android.content.Context
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ExtensionHubViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    @ApplicationContext context: Context,
) : SettingsViewModel(settingsRepository, userMessageBus, context)
