package com.slideindex.app.ui.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.slideindex.app.notification.NotificationFilterRepository
import com.slideindex.app.notification.NotificationHistoryClassification
import com.slideindex.app.notification.NotificationHistoryRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

@OptIn(FlowPreview::class)
@HiltViewModel
class NotificationHubViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    @ApplicationContext context: Context,
    notificationHistoryRepository: NotificationHistoryRepository,
    notificationFilterRepository: NotificationFilterRepository,
) : SettingsViewModel(settingsRepository, userMessageBus, context) {
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
