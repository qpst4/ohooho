package com.slideindex.app.ui.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Looper
import com.slideindex.app.data.AppLaunchPort
import com.slideindex.app.data.AppRepository
import com.slideindex.app.notification.NotificationFilterPreferences
import com.slideindex.app.notification.NotificationFilterRepository
import com.slideindex.app.notification.NotificationHistoryItem
import com.slideindex.app.notification.NotificationHistoryLaunchPort
import com.slideindex.app.notification.NotificationHistoryRepository
import com.slideindex.app.notification.NotificationListenerPort
import com.slideindex.app.notification.NotificationShadeActions
import com.slideindex.app.otp.OtpOfficialRulesLoader
import com.slideindex.app.otp.OtpRecordsRepository
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.clearTestSettings
import com.slideindex.app.settings.testSettingsRepository
import com.slideindex.app.ui.feedback.UserMessage
import com.slideindex.app.ui.feedback.UserMessageBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class HomeViewModelTest : ViewModelCoroutineTest() {
    private lateinit var context: Context
    private lateinit var repository: com.slideindex.app.settings.SettingsRepository

    @Before
    fun setUp() = runBlocking {
        context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        repository = testSettingsRepository(context)
    }

    @Test
    fun settings_initialValue_matchesDefaults() {
        val viewModel = HomeViewModel(
            repository,
            UserMessageBus(),
            context,
            object : HomeScreenEffects {
                override fun refreshServiceState() = Unit
                override fun requestNotificationPermission() = Unit
                override fun requestShizuku() = Unit
                override fun openAccessibilitySettings() = Unit
                override fun previewHaptic(enabled: Boolean, strengthLevel: Int?) = Unit
            },
        )

        assertFalse(viewModel.settings.value.serviceEnabled)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class KeepAliveSettingsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun settings_initialValue_matchesDefaults() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = KeepAliveSettingsViewModel(
            settingsRepository = repository,
            userMessageBus = UserMessageBus(),
            context,
            object : KeepAliveScreenEffects {
                override fun applyHideFromRecents(enabled: Boolean) = Unit
                override fun onAccessibilityKeepAliveEnabled() = Unit
            },
        )

        assertFalse(viewModel.settings.value.hideFromRecents)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ExtensionHubViewModelTest {
    @Test
    fun settings_initialValue_matchesDefaults() {
        val context = RuntimeEnvironment.getApplication()
        val viewModel = ExtensionHubViewModel(
            settingsRepository = testSettingsRepository(context),
            userMessageBus = UserMessageBus(),
            context,
        )

        assertFalse(viewModel.settings.value.serviceEnabled)
        assertEquals(AppSettings().quickLauncherColumnsPerPage, viewModel.settings.value.quickLauncherColumnsPerPage)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ExtensionSettingsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun settings_initialValue_matchesDefaults() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = ExtensionSettingsViewModel(repository, UserMessageBus(), context)

        assertEquals(AppSettings().quickLauncherColumnsPerPage, viewModel.settings.value.quickLauncherColumnsPerPage)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class HomeDetailSettingsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun settings_initialValue_matchesDefaults() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = HomeDetailSettingsViewModel(repository, UserMessageBus(), context)

        assertEquals(AppSettings().panelOpacity, viewModel.settings.value.panelOpacity)
    }

    @Test
    fun setPanelOpacity_persistsToSettingsFlow() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = HomeDetailSettingsViewModel(repository, UserMessageBus(), context)
        primeSettingsFlow(repository)

        viewModel.setPanelOpacity(0.72f)

        assertEquals(
            0.72f,
            awaitSettings(repository) { kotlin.math.abs(it.panelOpacity - 0.72f) < 0.001f }.panelOpacity,
            0.001f,
        )
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class MessageSettingsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun settings_initialValue_matchesDefaults() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = MessageSettingsViewModel(repository, UserMessageBus(), context)

        assertFalse(viewModel.settings.value.messageReminderSettings.enabled)
    }

    @Test
    fun setMessageReminderEnabled_persistsToSettingsFlow() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = MessageSettingsViewModel(repository, UserMessageBus(), context)
        primeSettingsFlow(repository)

        viewModel.setMessageReminderEnabled(true)

        assertTrue(awaitSettings(repository) { it.messageReminderSettings.enabled }.messageReminderSettings.enabled)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class OtpSettingsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun refreshOfficialRules_reloadsBundledRules() {
        val context = RuntimeEnvironment.getApplication()
        val loader = OtpOfficialRulesLoader(context)
        val viewModel = OtpSettingsViewModel(
            settingsRepository = testSettingsRepository(context),
            userMessageBus = UserMessageBus(),
            context,
            otpOfficialRulesLoader = loader,
            otpRecordsRepository = OtpRecordsRepository(context),
        )

        viewModel.refreshOfficialRules()

        assertTrue(viewModel.officialRules.value.isNotEmpty())
    }

    @Test
    fun settings_initialValue_matchesDefaults() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        val repository = testSettingsRepository(context)
        val viewModel = OtpSettingsViewModel(
            settingsRepository = repository,
            userMessageBus = UserMessageBus(),
            context,
            otpOfficialRulesLoader = OtpOfficialRulesLoader(context),
            otpRecordsRepository = OtpRecordsRepository(context),
        )

        assertFalse(viewModel.settings.value.otpAutoInputEnabled)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class OtpRecordsViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun records_initialValue_isEmpty() = runViewModelTest {
        val context = RuntimeEnvironment.getApplication()
        val viewModel = OtpRecordsViewModel(
            settingsRepository = testSettingsRepository(context),
            userMessageBus = UserMessageBus(),
            context,
            otpRecordsRepository = OtpRecordsRepository(context),
            appRepository = AppRepository(
                context = context,
                appLaunchPort = NoOpAppLaunchPort,
            ),
        )

        assertTrue(viewModel.records.value.isEmpty())
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class NotificationHubViewModelTest {
    @Test
    fun visibleHistoryCount_startsAtZero() {
        val context = RuntimeEnvironment.getApplication()
        val viewModel = NotificationHubViewModel(
            settingsRepository = testSettingsRepository(context),
            userMessageBus = UserMessageBus(),
            context,
            notificationHistoryRepository = notificationHistoryRepository(context),
            notificationFilterRepository = notificationFilterRepository(context),
        )

        assertEquals(0, viewModel.visibleHistoryCount.value)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class NotificationHistoryViewModelTest : ViewModelCoroutineTest() {
    @Test
    fun hideNotification_whenListenerDisabled_emitsError() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val bus = UserMessageBus()
        val viewModel = notificationHistoryViewModel(context, bus)
        val item = NotificationHistoryItem(
            id = "item-1",
            packageName = "com.test",
            title = "Title",
            text = "Body",
            postedAtMs = 1L,
            intentUri = null,
            notificationKey = null,
        )

        val message = async(Dispatchers.Unconfined) { bus.messages.first() }
        viewModel.hideNotification(item, listenerEnabled = false)
        assertTrue(message.await() is UserMessage.Error)
    }

    @Test
    fun restoreAllSnoozed_whenListenerDisabled_returnsNegativeOne() {
        val context = RuntimeEnvironment.getApplication()
        val viewModel = notificationHistoryViewModel(context, UserMessageBus())

        val result = viewModel.restoreAllSnoozed(listenerEnabled = false)

        assertEquals(-1, result)
    }

    @Test
    fun refreshActive_incrementsGeneration() {
        val context = RuntimeEnvironment.getApplication()
        val viewModel = notificationHistoryViewModel(context, UserMessageBus())
        val before = viewModel.refreshGeneration.value

        viewModel.refreshActive()

        assertEquals(before + 1, viewModel.refreshGeneration.value)
    }
}

private fun notificationHistoryViewModel(context: Context, bus: UserMessageBus): NotificationHistoryViewModel =
    NotificationHistoryViewModel(
        settingsRepository = testSettingsRepository(context),
        userMessageBus = bus,
        context = context,
        notificationHistoryRepository = notificationHistoryRepository(context),
        notificationFilterRepository = notificationFilterRepository(context),
        notificationFilterPreferences = NotificationFilterPreferences(context),
        appRepository = AppRepository(context, NoOpAppLaunchPort),
    )

private fun notificationHistoryRepository(context: Context): NotificationHistoryRepository =
    NotificationHistoryRepository(
        context = context,
        filterPreferences = NotificationFilterPreferences(context),
        listenerPort = NoOpNotificationListenerPort,
        shadeActions = NoOpNotificationShadeActions,
        launchPort = NoOpNotificationHistoryLaunchPort,
    )

private fun notificationFilterRepository(context: Context): NotificationFilterRepository =
    NotificationFilterRepository(
        context = context,
        listenerPort = NoOpNotificationListenerPort,
        shadeActions = NoOpNotificationShadeActions,
    )

private object NoOpAppLaunchPort : AppLaunchPort {
    override fun launch(intent: Intent, settings: AppSettings, fullscreen: Boolean) = Unit
}

private object NoOpNotificationListenerPort : NotificationListenerPort {
    override fun listenerOrNull() = null
}

private object NoOpNotificationShadeActions : NotificationShadeActions {
    override fun hideFromShade(
        listener: android.service.notification.NotificationListenerService,
        sbn: android.service.notification.StatusBarNotification,
    ) = false

    override fun hideFromShadeOnMain(
        listener: android.service.notification.NotificationListenerService,
        sbn: android.service.notification.StatusBarNotification,
    ) = Unit

    override fun hideFromShade(
        listener: android.service.notification.NotificationListenerService,
        key: String,
        sbn: android.service.notification.StatusBarNotification?,
    ) = false

    override fun snoozeMatchingActive(
        context: Context,
        listener: android.service.notification.NotificationListenerService,
        shouldHide: (android.service.notification.StatusBarNotification) -> Boolean,
    ) = Unit

    override fun executeRules(
        context: Context,
        listener: android.service.notification.NotificationListenerService,
        sbn: android.service.notification.StatusBarNotification,
        rules: List<com.slideindex.app.notification.NotificationFilterRule>,
    ) = Unit

    override fun hideNotificationByKey(key: String) = false

    override fun restoreAllSnoozed(selfPackage: String) = emptyList<String>()

    override fun unsnoozeNotification(key: String) = false
}

private object NoOpNotificationHistoryLaunchPort : NotificationHistoryLaunchPort {
    override fun startPendingIntentTrampoline(pendingIntentBase64: String, fallbackIntent: Intent?) = false

    override fun launchReplayIntent(intent: Intent, packageName: String, extrasBase64: String?) = false
}
