package com.slideindex.app.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.notification.NotificationFilterRepository
import com.slideindex.app.notification.NotificationHistoryClassification
import com.slideindex.app.notification.NotificationHistoryRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

@OptIn(FlowPreview::class)
class NotificationHubViewModel(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    app: SlideIndexApp,
    notificationHistoryRepository: NotificationHistoryRepository,
    notificationFilterRepository: NotificationFilterRepository,
) : SettingsViewModel(settingsRepository, userMessageBus, app) {
    val visibleHistoryCount: StateFlow<Int> = combine(
        notificationHistoryRepository.items,
        notificationFilterRepository.rules,
    ) { items, rules ->
        NotificationHistoryClassification.classify(items, rules).visibleItems.size
    }
        .debounce(300)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0,
        )
}
