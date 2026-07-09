package com.slideindex.app

import android.app.Application
import com.slideindex.app.di.ShizukuInitializer
import com.slideindex.app.data.AppRepository
import com.slideindex.app.notification.NotificationFilterPreferences
import com.slideindex.app.notification.NotificationFilterRepository
import com.slideindex.app.notification.NotificationHistoryRepository
import com.slideindex.app.otp.OtpOfficialRulesLoader
import com.slideindex.app.otp.OtpRecordsRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import com.slideindex.app.di.WidgetPanelPersistence
import com.slideindex.app.widget.WidgetPanelPage
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class SlideIndexApp : Application() {
    @Inject lateinit var appRepository: AppRepository
    @Inject lateinit var settingsRepository: SettingsRepository
    @Inject lateinit var notificationHistoryRepository: NotificationHistoryRepository
    @Inject lateinit var notificationFilterPreferences: NotificationFilterPreferences
    @Inject lateinit var notificationFilterRepository: NotificationFilterRepository
    @Inject lateinit var otpOfficialRulesLoader: OtpOfficialRulesLoader
    @Inject lateinit var otpRecordsRepository: OtpRecordsRepository
    @Inject lateinit var userMessageBus: UserMessageBus
    @Inject lateinit var applicationScope: CoroutineScope
    @Inject lateinit var shizukuInitializer: ShizukuInitializer

    @Inject lateinit var widgetPanelPersistence: WidgetPanelPersistence

    override fun onCreate() {
        super.onCreate()
        shizukuInitializer.start()
        applicationScope.launch {
            appRepository.loadApps()
        }
    }

    fun schedulePersistWidgetPanelPages(pages: List<WidgetPanelPage>) {
        widgetPanelPersistence.schedulePersist(pages)
    }

    suspend fun persistWidgetPanelPagesNow(pages: List<WidgetPanelPage>) {
        widgetPanelPersistence.persistNow(pages)
    }
}
