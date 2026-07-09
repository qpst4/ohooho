package com.slideindex.app.di

import android.content.Context
import com.slideindex.app.data.AppRepository
import com.slideindex.app.notification.NotificationFilterPreferences
import com.slideindex.app.notification.NotificationFilterRepository
import com.slideindex.app.notification.NotificationHistoryRepository
import com.slideindex.app.otp.OtpOfficialRulesLoader
import com.slideindex.app.otp.OtpRecordsRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import com.slideindex.app.util.TaskManagerUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import rikka.shizuku.Shizuku
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    @Singleton
    fun provideUserMessageBus(): UserMessageBus = UserMessageBus()

    @Provides
    @Singleton
    fun provideAppRepository(
        @ApplicationContext context: Context,
    ): AppRepository = AppRepository(context)

    @Provides
    @Singleton
    fun provideSettingsRepository(
        @ApplicationContext context: Context,
    ): SettingsRepository = SettingsRepository(context)

    @Provides
    @Singleton
    fun provideNotificationFilterPreferences(
        @ApplicationContext context: Context,
    ): NotificationFilterPreferences = NotificationFilterPreferences(context)

    @Provides
    @Singleton
    fun provideNotificationHistoryRepository(
        @ApplicationContext context: Context,
        notificationFilterPreferences: NotificationFilterPreferences,
    ): NotificationHistoryRepository = NotificationHistoryRepository(context, notificationFilterPreferences)

    @Provides
    @Singleton
    fun provideNotificationFilterRepository(
        @ApplicationContext context: Context,
    ): NotificationFilterRepository = NotificationFilterRepository(context)

    @Provides
    @Singleton
    fun provideOtpOfficialRulesLoader(
        @ApplicationContext context: Context,
    ): OtpOfficialRulesLoader = OtpOfficialRulesLoader(context)

    @Provides
    @Singleton
    fun provideOtpRecordsRepository(
        @ApplicationContext context: Context,
    ): OtpRecordsRepository = OtpRecordsRepository(context)

    @Provides
    @Singleton
    fun provideShizukuInitializer(
        @ApplicationContext context: Context,
    ): ShizukuInitializer = ShizukuInitializer(context)
}

@Singleton
class ShizukuInitializer(
    @ApplicationContext private val context: Context,
) {
    private val binderListener = Shizuku.OnBinderReceivedListener {
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }

    fun start() {
        TaskManagerUtil.initialize(context)
        Shizuku.addBinderReceivedListenerSticky(binderListener)
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }
}
