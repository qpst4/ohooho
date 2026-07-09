package com.slideindex.app.settings

import com.slideindex.app.widget.WidgetPanelPage
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Singleton
class WidgetPanelPersistence @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val applicationScope: CoroutineScope,
) {
    fun schedulePersist(pages: List<WidgetPanelPage>) {
        applicationScope.launch {
            settingsRepository.setWidgetPanelPages(pages)
        }
    }

    suspend fun persistNow(pages: List<WidgetPanelPage>) {
        settingsRepository.setWidgetPanelPages(pages)
    }
}
