package com.slideindex.app.ui.viewmodel

import com.slideindex.app.SlideIndexApp
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus

class ExtensionHubViewModel(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    app: SlideIndexApp,
) : SettingsViewModel(settingsRepository, userMessageBus, app)
