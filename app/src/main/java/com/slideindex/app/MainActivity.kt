@file:OptIn(ExperimentalMaterial3ExpressiveApi::class, kotlinx.coroutines.FlowPreview::class)

package com.slideindex.app

import android.Manifest
import android.app.ActivityManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.slideindex.app.gesture.TriggerHandle
import com.slideindex.app.gesture.TriggerHandleDesign
import com.slideindex.app.notification.NotificationHistoryClassification
import com.slideindex.app.overlay.FloatingPointerAreaPreviewOverlay
import com.slideindex.app.overlay.LayoutPreviewContent
import com.slideindex.app.overlay.WidgetPickerOverlayWindow
import com.slideindex.app.service.OverlayService
import com.slideindex.app.service.QuickLauncherAddTrampoline
import com.slideindex.app.service.ShellCommandEditorTrampoline
import com.slideindex.app.service.ShellCommandPanelTrampoline
import com.slideindex.app.service.ShellCommandResultTrampoline
import com.slideindex.app.service.WidgetBindTrampolineActivity
import com.slideindex.app.service.WidgetPickerTrampoline
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.ui.AppKeepAliveSettingsScreen
import com.slideindex.app.ui.ExcludedAppsScreen
import com.slideindex.app.ui.GestureAngleSettingsScreen
import com.slideindex.app.ui.FloatingPointerJoystickSettingsScreen
import com.slideindex.app.ui.FloatingPointerPointerSettingsScreen
import com.slideindex.app.ui.FloatingPointerRadialMenuSettingsScreen
import com.slideindex.app.ui.FloatingPointerSettingsScreen
import com.slideindex.app.ui.FreeWindowPreviewScreen
import com.slideindex.app.ui.FreeWindowSettingsScreen
import com.slideindex.app.ui.HiddenAppsScreen
import com.slideindex.app.ui.LayoutSettingsScreen
import com.slideindex.app.ui.FloatingBottomNavBar
import com.slideindex.app.ui.MainBottomNavDestination
import com.slideindex.app.ui.MainBottomNavHeight
import com.slideindex.app.ui.MainBottomNavOuterPadding
import com.slideindex.app.ui.MessageReminderAllowedAppsScreen
import com.slideindex.app.ui.MessageReminderDndAppsScreen
import com.slideindex.app.ui.MessageReminderSettingsScreen
import com.slideindex.app.ui.MessageStyleSettingsScreen
import com.slideindex.app.ui.NotificationHubScreen
import com.slideindex.app.ui.MainScreen
import com.slideindex.app.ui.isRootDestination
import com.slideindex.app.ui.toBottomNavDestination
import com.slideindex.app.ui.NotificationHistoryScreen
import com.slideindex.app.ui.OtpAutoInputSettingsScreen
import com.slideindex.app.ui.OtpHubScreen
import com.slideindex.app.ui.OtpRecordsScreen
import com.slideindex.app.ui.OtpRulesListScreen
import com.slideindex.app.ui.OtpSettingsScreen
import com.slideindex.app.ui.QuickLauncherEditorScreen
import com.slideindex.app.ui.SettingsDestination
import com.slideindex.app.ui.ShellCommandPanelScreen
import com.slideindex.app.ui.WidgetPanelSettingsScreen
import com.slideindex.app.ui.SideGestureSettingsScreen
import com.slideindex.app.ui.ExtensionHubScreen
import com.slideindex.app.ui.ShakeGestureBlacklistScreen
import com.slideindex.app.ui.ShakeGesturesScreen
import com.slideindex.app.ui.ShakeActionSetSettingsScreen
import com.slideindex.app.ui.ShakeIndependentAppSettingsScreen
import com.slideindex.app.ui.ShakeIndependentSensitivityScreen
import com.slideindex.app.shake.ShakeGestureType
import com.slideindex.app.shake.ShakeGestureSettings
import com.slideindex.app.ui.TriggerDesignSettingsScreen
import com.slideindex.app.ui.TriggerAppearanceSettingsScreen
import com.slideindex.app.ui.TriggerCollectionScreen
import com.slideindex.app.ui.animationstyle.AnimationStyleSelectScreen
import com.slideindex.app.ui.animationstyle.BubbleStyleSettingsScreen
import com.slideindex.app.ui.animationstyle.CapsuleStyleSettingsScreen
import com.slideindex.app.ui.animationstyle.WaveStyleSettingsScreen
import com.slideindex.app.settings.GestureHintStyle
import com.slideindex.app.settings.activeBubbleStyle
import com.slideindex.app.settings.activeCapsuleStyle
import com.slideindex.app.settings.activeWaveStyle
import com.slideindex.app.ui.theme.SlideIndexTheme
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.util.HapticHelper
import com.slideindex.app.util.KeepAliveHelper
import com.slideindex.app.util.MediaSessionHelper
import com.slideindex.app.util.PermissionHelper
import com.slideindex.app.util.SecureSettingsHelper
import com.slideindex.app.util.TaskManagerUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import rikka.shizuku.Shizuku

class MainActivity : ComponentActivity() {
    private var notificationGranted by mutableStateOf(true)
    private var usageAccessGranted by mutableStateOf(false)
    private var shizukuGranted by mutableStateOf(false)
    private var accessibilityGranted by mutableStateOf(false)
    private var batteryOptimizationExempt by mutableStateOf(false)
    private var writeSecureSettingsGranted by mutableStateOf(false)
    private var notificationListenerEnabled by mutableStateOf(false)

    private val shizukuPermissionListener = Shizuku.OnRequestPermissionResultListener { _, grantResult ->
        shizukuGranted = grantResult == PackageManager.PERMISSION_GRANTED
        if (shizukuGranted) {
            TaskManagerUtil.warmUp()
        }
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { granted ->
        notificationGranted = granted || PermissionHelper.hasNotificationPermission(this)
        refreshServiceState()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Shizuku.addRequestPermissionResultListener(shizukuPermissionListener)
        enableEdgeToEdge()
        refreshPermissionState()

        val app = application as SlideIndexApp
        setContent {
            val settings by app.settingsRepository.settings.collectAsStateWithLifecycle(
                initialValue = AppSettings(),
            )
            var savedBottomNavTab by rememberSaveable {
                mutableStateOf(MainBottomNavDestination.Home.name)
            }
            var destination by remember {
                mutableStateOf(
                    when (savedBottomNavTab) {
                        MainBottomNavDestination.Shake.name -> SettingsDestination.ShakeGestures
                        MainBottomNavDestination.Notification.name -> SettingsDestination.NotificationHub
                        MainBottomNavDestination.Extension.name -> SettingsDestination.ExtensionHub
                        else -> SettingsDestination.Main
                    },
                )
            }
            var otpRecordsBackDestination by remember { mutableStateOf(SettingsDestination.NotificationHub) }
            var sideGestureHandleId by remember { mutableStateOf(TriggerHandle.DEFAULT_ID) }
            var appearanceParentSide by remember { mutableStateOf(PanelSide.LEFT) }
            var designParentSide by remember { mutableStateOf(PanelSide.LEFT) }
            var floatingPointerAreaPreviewEnabled by rememberSaveable { mutableStateOf(false) }
            var shakePerAppConfigPackage by remember { mutableStateOf<String?>(null) }
            val rootBottomContentPadding = MainBottomNavHeight + MainBottomNavOuterPadding
            var visibleNotificationHistoryCount by remember { mutableStateOf(0) }
            LaunchedEffect(Unit) {
                combine(
                    app.notificationHistoryRepository.items,
                    app.notificationFilterRepository.rules,
                ) { items, rules -> items to rules }
                    .debounce(300)
                    .collectLatest { (items, rules) ->
                        visibleNotificationHistoryCount = withContext(Dispatchers.Default) {
                            NotificationHistoryClassification.classify(items, rules).visibleItems.size
                        }
                    }
            }
            LaunchedEffect(settings.hideFromRecents) {
                applyHideFromRecents(settings.hideFromRecents)
            }
            LaunchedEffect(destination, accessibilityGranted, floatingPointerAreaPreviewEnabled) {
                if (destination == SettingsDestination.FloatingPointer &&
                    accessibilityGranted &&
                    floatingPointerAreaPreviewEnabled
                ) {
                    FloatingPointerAreaPreviewOverlay.show(this@MainActivity)
                } else if (FloatingPointerAreaPreviewOverlay.isShowing) {
                    FloatingPointerAreaPreviewOverlay.hide()
                }
            }
            DisposableEffect(Unit) {
                onDispose { FloatingPointerAreaPreviewOverlay.hide() }
            }
            SlideIndexTheme(
                seedColor = androidx.compose.ui.graphics.Color(settings.themeColorArgb),
                dynamicColor = settings.dynamicColorEnabled,
            ) {
                val motionScheme = MaterialTheme.motionScheme
                Box(modifier = Modifier.fillMaxSize()) {
                AnimatedContent(
                    modifier = Modifier.fillMaxSize(),
                    targetState = destination,
                    transitionSpec = {
                        val spatialSpec = motionScheme.defaultSpatialSpec<IntOffset>()
                        val effectsSpec = motionScheme.defaultEffectsSpec<Float>()
                        val forward = targetState.ordinal >= initialState.ordinal
                        val enter = slideInHorizontally(spatialSpec) { width ->
                            if (forward) width / 4 else -width / 4
                        } + fadeIn(effectsSpec)
                        val exit = slideOutHorizontally(spatialSpec) { width ->
                            if (forward) -width / 4 else width / 4
                        } + fadeOut(effectsSpec)
                        enter.togetherWith(exit)
                    },
                    label = "settings_destination",
                ) { currentDestination ->
                    when (currentDestination) {
                    SettingsDestination.Main -> MainScreen(
                        settings = settings,
                        notificationGranted = notificationGranted,
                        shizukuGranted = shizukuGranted,
                        accessibilityGranted = accessibilityGranted,
                        batteryOptimizationExempt = batteryOptimizationExempt,
                        onRequestNotification = {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                            }
                        },
                        onRequestShizuku = {
                            TaskManagerUtil.requestPermission()
                        },
                        onRequestAccessibility = {
                            startActivity(PermissionHelper.accessibilitySettingsIntent())
                        },
                        onGestureEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setServiceEnabled(enabled)
                                refreshServiceState()
                            }
                        },
                        onOpenAppKeepAliveSettings = {
                            destination = SettingsDestination.AppKeepAlive
                        },
                        onHapticEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHapticEnabled(enabled)
                                if (enabled) {
                                    val latest = app.settingsRepository.settings.first()
                                    HapticHelper.preview(window.decorView, latest.copy(hapticEnabled = true))
                                }
                            }
                        },
                        onHapticStrengthChange = { level ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHapticStrengthLevel(level)
                                val latest = app.settingsRepository.settings.first()
                                HapticHelper.preview(
                                    window.decorView,
                                    latest.copy(hapticEnabled = true, hapticStrengthLevel = level),
                                )
                            }
                        },
                        onOpenFreeWindowSettings = {
                            destination = SettingsDestination.FreeWindow
                        },
                        onOpenExcludedAppsSettings = {
                            destination = SettingsDestination.ExcludedApps
                        },
                        onOpenTriggerCollection = {
                            destination = SettingsDestination.TriggerCollection
                        },
                        onOpenGestureAngle = {
                            destination = SettingsDestination.GestureAngle
                        },
                        onOpenAnimationStyleSelect = {
                            destination = SettingsDestination.AnimationStyleSelect
                        },
                        onGestureHintEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setGestureHintEnabled(enabled)
                            }
                        },
                        onHideTriggerInLandscapeChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHideTriggerInLandscape(enabled)
                            }
                        },
                        onHideTriggerOnLockScreenChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHideTriggerOnLockScreen(enabled)
                            }
                        },
                        onHideTriggerOnLauncherChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHideTriggerOnLauncher(enabled)
                            }
                        },
                        bottomContentPadding = if (destination.isRootDestination()) {
                            rootBottomContentPadding
                        } else {
                            0.dp
                        },
                        onDynamicColorChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setDynamicColorEnabled(enabled)
                            }
                        },
                        onThemeColorChange = { color ->
                            lifecycleScope.launch { app.settingsRepository.setThemeColor(color) }
                        },
                    )

                    SettingsDestination.NotificationHub -> NotificationHubScreen(
                        notificationListenerEnabled = notificationListenerEnabled,
                        messageReminderEnabled = settings.messageReminderSettings.enabled,
                        messageReminderSettings = settings.messageReminderSettings,
                        notificationHistoryCount = visibleNotificationHistoryCount,
                        onOpenNotificationHistory = {
                            destination = SettingsDestination.NotificationHistory
                        },
                        onOpenOtpHub = {
                            destination = SettingsDestination.OtpHub
                        },
                        onOpenMessageReminder = {
                            destination = SettingsDestination.MessageReminder
                        },
                        bottomContentPadding = rootBottomContentPadding,
                    )

                    SettingsDestination.MessageReminder -> MessageReminderSettingsScreen(
                        settings = settings.messageReminderSettings,
                        notificationListenerEnabled = notificationListenerEnabled,
                        bottomContentPadding = rootBottomContentPadding,
                        onBack = { destination = SettingsDestination.NotificationHub },
                        onEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageReminderEnabled(enabled)
                            }
                        },
                        onOpenStyleSettings = {
                            destination = SettingsDestination.MessageStyle
                        },
                        onHideInLandscapeChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageHideInLandscape(enabled)
                            }
                        },
                        onPortraitDanmakuChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessagePortraitDanmaku(enabled)
                            }
                        },
                        onLandscapeDanmakuChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageLandscapeDanmaku(enabled)
                            }
                        },
                        onGestureActionChange = { slot, action ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageGestureAction(slot, action)
                            }
                        },
                        onOpenAllowedApps = {
                            destination = SettingsDestination.MessageReminderAllowedApps
                        },
                        onOpenDndApps = {
                            destination = SettingsDestination.MessageReminderDndApps
                        },
                        onSuppressWhenSystemDndChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageSuppressWhenSystemDnd(enabled)
                            }
                        },
                        onOpenOverlayPermission = {
                            startActivity(PermissionHelper.overlaySettingsIntent(this@MainActivity))
                        },
                        onOpenNotificationListenerPermission = {
                            startActivity(MediaSessionHelper.notificationListenerSettingsIntent())
                        },
                    )

                    SettingsDestination.MessageReminderAllowedApps -> MessageReminderAllowedAppsScreen(
                        settings = settings.messageReminderSettings,
                        onBack = { destination = SettingsDestination.MessageReminder },
                        onAddPackage = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addMessageEnabledPackage(packageName)
                            }
                        },
                        onRemovePackage = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeMessageEnabledPackage(packageName)
                            }
                        },
                        onSaveFilterRule = { rule ->
                            lifecycleScope.launch {
                                app.settingsRepository.upsertMessageAppFilterRule(rule)
                            }
                        },
                    )

                    SettingsDestination.MessageReminderDndApps -> MessageReminderDndAppsScreen(
                        dndPackages = settings.messageReminderSettings.dndPackages,
                        onBack = { destination = SettingsDestination.MessageReminder },
                        onAddPackage = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addMessageDndPackage(packageName)
                            }
                        },
                        onRemovePackage = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeMessageDndPackage(packageName)
                            }
                        },
                    )

                    SettingsDestination.MessageStyle -> MessageStyleSettingsScreen(
                        settings = settings.messageReminderSettings,
                        bottomContentPadding = rootBottomContentPadding,
                        onBack = { destination = SettingsDestination.MessageReminder },
                        onStyleIdChange = { styleId ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageStyleId(styleId)
                            }
                        },
                        onThemeIdChange = { themeId ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageThemeId(themeId)
                            }
                        },
                        onPrimaryStyleEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessagePrimaryStyleEnabled(enabled)
                            }
                        },
                        onDanmakuEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageDanmakuEnabled(enabled)
                            }
                        },
                        onDanmakuThemeIdChange = { themeId ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageDanmakuThemeId(themeId)
                            }
                        },
                        onFloatIconOpacityChange = { opacity ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageFloatIconOpacity(opacity)
                            }
                        },
                        onCardOpacityChange = { opacity ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageCardOpacity(opacity)
                            }
                        },
                        onSideBubbleOpacityChange = { opacity ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageSideBubbleOpacity(opacity)
                            }
                        },
                        onDanmakuOpacityChange = { opacity ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageDanmakuOpacity(opacity)
                            }
                        },
                        onCardMaxLinesChange = { lines ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageCardMaxLines(lines)
                            }
                        },
                        onDanmakuMaxLinesChange = { lines ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageDanmakuMaxLines(lines)
                            }
                        },
                        onSideMaxCountChange = { count ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageSideMaxCount(count)
                            }
                        },
                        onSideMaxWidthDpChange = { width ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageSideMaxWidthDp(width)
                            }
                        },
                        onSideMaxLinesChange = { lines ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageSideMaxLines(lines)
                            }
                        },
                        onAutoDismissSecondsChange = { seconds ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageAutoDismissSeconds(seconds)
                            }
                        },
                        onFloatIconSizeDpChange = { sizeDp ->
                            lifecycleScope.launch {
                                app.settingsRepository.setMessageFloatIconSizeDp(sizeDp)
                            }
                        },
                    )

                    SettingsDestination.ShakeGestures -> ShakeGesturesScreen(
                        settings = settings.shakeGestureSettings,
                        bottomContentPadding = rootBottomContentPadding,
                        onEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeGesturesEnabled(enabled)
                            }
                        },
                        onBasicActionChange = { type, action ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeGestureAction(type, action)
                            }
                        },
                        onLockScreenShakeEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setLockScreenShakeEnabled(enabled)
                            }
                        },
                        onIndependentAppShakeEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setIndependentAppShakeEnabled(enabled)
                            }
                        },
                        onGlobalSensitivityChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeGlobalSensitivity(value)
                            }
                        },
                        onIndependentSensitivityEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeIndependentSensitivityEnabled(enabled)
                            }
                        },
                        onOpenIndependentSensitivity = {
                            destination = SettingsDestination.ShakeIndependentSensitivity
                        },
                        onAnimationFeedbackEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeAnimationFeedbackEnabled(enabled)
                            }
                        },
                        onVibrationFeedbackEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeVibrationFeedbackEnabled(enabled)
                            }
                        },
                        onAnimationColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeAnimationColor(color)
                            }
                        },
                        onDisableInLandscapeChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeDisableInLandscape(enabled)
                            }
                        },
                        onOpenLockScreenShakeSettings = {
                            destination = SettingsDestination.ShakeLockScreenSettings
                        },
                        onOpenIndependentAppShakeSettings = {
                            destination = SettingsDestination.ShakeIndependentAppSettings
                        },
                        onOpenAppBlacklist = {
                            destination = SettingsDestination.ShakeGestureBlacklist
                        },
                    )

                    SettingsDestination.ShakeGestureBlacklist -> ShakeGestureBlacklistScreen(
                        blacklistedPackages = settings.shakeGestureSettings.blacklistedPackages,
                        onBack = { destination = SettingsDestination.ShakeGestures },
                        onBlacklistApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addShakeBlacklistedApp(packageName)
                            }
                        },
                        onRemoveBlacklistedApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeShakeBlacklistedApp(packageName)
                            }
                        },
                    )

                    SettingsDestination.ShakeLockScreenSettings -> ShakeActionSetSettingsScreen(
                        title = stringResource(R.string.shake_gestures_lock_screen),
                        subtitle = stringResource(R.string.shake_gestures_lock_screen_settings_desc),
                        actions = settings.shakeGestureSettings.lockScreenActions,
                        onBack = { destination = SettingsDestination.ShakeGestures },
                        onActionChange = { type, action ->
                            lifecycleScope.launch {
                                app.settingsRepository.setLockScreenShakeAction(type, action)
                            }
                        },
                    )

                    SettingsDestination.ShakeIndependentSensitivity -> ShakeIndependentSensitivityScreen(
                        globalSensitivity = settings.shakeGestureSettings.globalSensitivity,
                        perDirectionSensitivity = settings.shakeGestureSettings.perDirectionSensitivity,
                        onBack = { destination = SettingsDestination.ShakeGestures },
                        onSensitivityChange = { type, value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShakeDirectionSensitivity(type, value)
                            }
                        },
                    )

                    SettingsDestination.ShakeIndependentAppSettings -> ShakeIndependentAppSettingsScreen(
                        perAppActions = settings.shakeGestureSettings.perAppActions,
                        onBack = { destination = SettingsDestination.ShakeGestures },
                        onOpenAppConfig = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addPerAppShakeConfig(packageName)
                            }
                            shakePerAppConfigPackage = packageName
                            destination = SettingsDestination.ShakePerAppActions
                        },
                        onRemoveAppConfig = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removePerAppShakeConfig(packageName)
                            }
                        },
                    )

                    SettingsDestination.ShakePerAppActions -> {
                        val packageName = shakePerAppConfigPackage
                        if (packageName == null) {
                            destination = SettingsDestination.ShakeIndependentAppSettings
                        } else {
                            val appLabel = remember(packageName) {
                                runCatching {
                                    packageManager.getApplicationLabel(
                                        packageManager.getApplicationInfo(packageName, 0),
                                    ).toString()
                                }.getOrDefault(packageName)
                            }
                            ShakeActionSetSettingsScreen(
                                title = stringResource(
                                    R.string.shake_gestures_per_app_actions_title,
                                    appLabel,
                                ),
                                subtitle = stringResource(R.string.shake_gestures_independent_app_desc),
                                actions = settings.shakeGestureSettings.perAppActions[packageName]
                                    ?: ShakeGestureSettings.defaultBasicActions(),
                                onBack = {
                                    shakePerAppConfigPackage = null
                                    destination = SettingsDestination.ShakeIndependentAppSettings
                                },
                                onActionChange = { type, action ->
                                    lifecycleScope.launch {
                                        app.settingsRepository.setPerAppShakeAction(packageName, type, action)
                                    }
                                },
                            )
                        }
                    }

                    SettingsDestination.ExtensionHub -> ExtensionHubScreen(
                        settings = settings,
                        gestureActive = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        bottomContentPadding = rootBottomContentPadding,
                        onOpenLayoutSettings = { destination = SettingsDestination.Layout },
                        onOpenQuickLauncher = { destination = SettingsDestination.QuickLauncher },
                        onOpenShellCommands = { destination = SettingsDestination.ShellCommands },
                        onOpenWidgetPanel = { destination = SettingsDestination.WidgetPanel },
                        onOpenFloatingPointer = { destination = SettingsDestination.FloatingPointer },
                    )

                    SettingsDestination.AppKeepAlive -> AppKeepAliveSettingsScreen(
                        hideFromRecents = settings.hideFromRecents,
                        batteryOptimizationExempt = batteryOptimizationExempt,
                        accessibilityKeepAliveEnabled = settings.accessibilityKeepAliveEnabled,
                        writeSecureSettingsGranted = writeSecureSettingsGranted,
                        shizukuGranted = shizukuGranted,
                        onBack = { destination = SettingsDestination.Main },
                        onRequestBatteryOptimization = {
                            if (!PermissionHelper.requestBatteryOptimizationAccess(this@MainActivity)) {
                                android.widget.Toast.makeText(
                                    this@MainActivity,
                                    getString(R.string.battery_optimization_request_failed),
                                    android.widget.Toast.LENGTH_SHORT,
                                ).show()
                            }
                        },
                        onRequestAutoStart = {
                            KeepAliveHelper.gotoSettings(this@MainActivity)
                        },
                        onHideFromRecentsChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setHideFromRecents(enabled)
                                applyHideFromRecents(enabled)
                            }
                        },
                        onAccessibilityKeepAliveChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setAccessibilityKeepAliveEnabled(enabled)
                                if (enabled) {
                                    SecureSettingsHelper.ensureAccessibilityEnabled(this@MainActivity)
                                    refreshPermissionState()
                                    refreshServiceState()
                                }
                            }
                        },
                        onRequestSecureSettingsGrant = {
                            val granted = SecureSettingsHelper.grantViaShizuku(this@MainActivity)
                            refreshPermissionState()
                            if (granted) {
                                android.widget.Toast.makeText(
                                    this@MainActivity,
                                    getString(R.string.secure_settings_grant_success),
                                    android.widget.Toast.LENGTH_SHORT,
                                ).show()
                            } else {
                                android.widget.Toast.makeText(
                                    this@MainActivity,
                                    getString(R.string.secure_settings_grant_failed),
                                    android.widget.Toast.LENGTH_SHORT,
                                ).show()
                            }
                            granted
                        },
                    )

                    SettingsDestination.Layout -> LayoutSettingsScreen(
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                            destination = SettingsDestination.Main
                        },
                        onIndexHeightChange = { value ->
                            lifecycleScope.launch { app.settingsRepository.setIndexHeightFraction(value) }
                        },
                        onAppsPerRowChange = { value ->
                            lifecycleScope.launch { app.settingsRepository.setAppsPerRow(value) }
                        },
                        onPanelOpacityChange = { value ->
                            lifecycleScope.launch { app.settingsRepository.setPanelOpacity(value) }
                        },
                        onOpenHiddenAppsSettings = {
                            destination = SettingsDestination.HiddenApps
                        },
                        onLayoutPreviewStart = {
                            sendOverlayPreviewIntent(
                                OverlayService.ACTION_PREVIEW_START,
                                LayoutPreviewContent.INDEX_ONLY,
                            )
                        },
                        onLayoutPreviewStop = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                        },
                    )

                    SettingsDestination.HiddenApps -> HiddenAppsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.Layout },
                        onHideApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addHiddenApp(packageName)
                            }
                        },
                        onUnhideApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeHiddenApp(packageName)
                            }
                        },
                    )

                    SettingsDestination.ExcludedApps -> ExcludedAppsScreen(
                        settings = settings,
                        usageAccessGranted = usageAccessGranted,
                        onBack = { destination = SettingsDestination.Main },
                        onRequestUsageAccess = {
                            startActivity(PermissionHelper.usageAccessSettingsIntent())
                        },
                        onExcludeApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.addExcludedTriggerApp(packageName)
                            }
                        },
                        onRemoveExcludedApp = { packageName ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeExcludedTriggerApp(packageName)
                            }
                        },
                    )

                    SettingsDestination.FreeWindow -> FreeWindowSettingsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.Main },
                        onEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFreeWindowEnabled(enabled)
                            }
                        },
                        onLaunchPolicyChange = { policyId ->
                            lifecycleScope.launch {
                                app.settingsRepository.setAppLaunchPolicyId(policyId)
                            }
                        },
                        onLongPressDurationChange = { durationMs ->
                            lifecycleScope.launch {
                                app.settingsRepository.setLongPressLaunchDurationMs(durationMs)
                            }
                        },
                        onModeChange = { modeId ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFreeWindowModeId(modeId)
                            }
                        },
                        onOpenPreview = { destination = SettingsDestination.FreeWindowPreview },
                    )

                    SettingsDestination.FreeWindowPreview -> FreeWindowPreviewScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.FreeWindow },
                        onSave = { width, height, left, top ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFreeWindowLayout(width, height, left, top)
                            }
                        },
                    )

                    SettingsDestination.TriggerCollection -> TriggerCollectionScreen(
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = { destination = SettingsDestination.Main },
                        onOpenLeftTrigger = { handleId ->
                            sideGestureHandleId = handleId
                            destination = SettingsDestination.SideGesturesLeft
                        },
                        onOpenRightTrigger = { handleId ->
                            sideGestureHandleId = handleId
                            destination = SettingsDestination.SideGesturesRight
                        },
                        onAddTriggerPair = {
                            lifecycleScope.launch {
                                app.settingsRepository.addTriggerHandlePair()
                            }
                        },
                        onRemoveTriggerHandle = { side, handleId ->
                            lifecycleScope.launch {
                                app.settingsRepository.removeTriggerHandle(side, handleId)
                            }
                        },
                    )

                    SettingsDestination.SideGesturesLeft -> SideGestureSettingsScreen(
                        side = PanelSide.LEFT,
                        handleId = sideGestureHandleId,
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                            destination = SettingsDestination.TriggerCollection
                        },
                        onOpenAppearanceSettings = {
                            appearanceParentSide = PanelSide.LEFT
                            destination = SettingsDestination.SideGesturesAppearance
                        },
                        onOpenDesignSettings = {
                            designParentSide = PanelSide.LEFT
                            destination = SettingsDestination.SideGesturesDesign
                        },
                        onSlotConfigChange = { handleId, trigger, action, mode ->
                            lifecycleScope.launch {
                                app.settingsRepository.setSlotConfig(
                                    PanelSide.LEFT,
                                    trigger,
                                    action,
                                    mode,
                                    handleId,
                                )
                            }
                        },
                        onDefaultTriggerModeChange = { mode ->
                            lifecycleScope.launch {
                                app.settingsRepository.setDefaultTriggerMode(PanelSide.LEFT, mode)
                            }
                        },
                    )

                    SettingsDestination.SideGesturesRight -> SideGestureSettingsScreen(
                        side = PanelSide.RIGHT,
                        handleId = sideGestureHandleId,
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                            destination = SettingsDestination.TriggerCollection
                        },
                        onOpenAppearanceSettings = {
                            appearanceParentSide = PanelSide.RIGHT
                            destination = SettingsDestination.SideGesturesAppearance
                        },
                        onOpenDesignSettings = {
                            designParentSide = PanelSide.RIGHT
                            destination = SettingsDestination.SideGesturesDesign
                        },
                        onSlotConfigChange = { handleId, trigger, action, mode ->
                            lifecycleScope.launch {
                                app.settingsRepository.setSlotConfig(
                                    PanelSide.RIGHT,
                                    trigger,
                                    action,
                                    mode,
                                    handleId,
                                )
                            }
                        },
                        onDefaultTriggerModeChange = { mode ->
                            lifecycleScope.launch {
                                app.settingsRepository.setDefaultTriggerMode(PanelSide.RIGHT, mode)
                            }
                        },
                    )

                    SettingsDestination.SideGesturesAppearance -> TriggerAppearanceSettingsScreen(
                        side = appearanceParentSide,
                        handleId = sideGestureHandleId,
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                            destination = when (appearanceParentSide) {
                                PanelSide.LEFT -> SettingsDestination.SideGesturesLeft
                                PanelSide.RIGHT -> SettingsDestination.SideGesturesRight
                            }
                        },
                        onShortSwipeDistanceChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShortSwipeDistanceDp(
                                    appearanceParentSide,
                                    sideGestureHandleId,
                                    value,
                                )
                            }
                        },
                        onLongSwipeDistanceChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setLongSwipeDistanceDp(
                                    appearanceParentSide,
                                    sideGestureHandleId,
                                    value,
                                )
                            }
                        },
                        onEdgeWidthChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setEdgeTriggerWidthDp(appearanceParentSide, value)
                            }
                        },
                        onTriggerVerticalRangeChange = { handleId, top, bottom ->
                            lifecycleScope.launch {
                                app.settingsRepository.setTriggerVerticalRange(
                                    appearanceParentSide,
                                    handleId,
                                    top,
                                    bottom,
                                )
                            }
                        },
                        onAlignHandlesChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setTriggerAlignOppositeSide(
                                    handleId = sideGestureHandleId,
                                    sourceSide = appearanceParentSide,
                                    enabled = enabled,
                                )
                            }
                        },
                        onInterceptBackChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setInterceptSystemBackGesture(enabled)
                            }
                        },
                        onLimitInterceptLengthChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setLimitMaxInterceptLength(enabled)
                            }
                        },
                        onLayoutPreviewStart = {
                            sendOverlayPreviewIntent(
                                OverlayService.ACTION_PREVIEW_START,
                                LayoutPreviewContent.TRIGGER_ONLY,
                            )
                        },
                        onLayoutPreviewStop = {
                            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
                        },
                    )

                    SettingsDestination.SideGesturesDesign -> TriggerDesignSettingsScreen(
                        side = designParentSide,
                        handleId = sideGestureHandleId,
                        settings = settings,
                        serviceEnabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            destination = when (designParentSide) {
                                PanelSide.LEFT -> SettingsDestination.SideGesturesLeft
                                PanelSide.RIGHT -> SettingsDestination.SideGesturesRight
                            }
                        },
                        onDesignChange = { design ->
                            lifecycleScope.launch {
                                app.settingsRepository.setTriggerHandleDesign(
                                    designParentSide,
                                    sideGestureHandleId,
                                    design,
                                )
                            }
                        },
                        onPresetApply = { preset ->
                            lifecycleScope.launch {
                                app.settingsRepository.applyTriggerDesignPreset(
                                    designParentSide,
                                    sideGestureHandleId,
                                    preset,
                                )
                            }
                        },
                        onResetDefaults = {
                            lifecycleScope.launch {
                                app.settingsRepository.setTriggerHandleDesign(
                                    designParentSide,
                                    sideGestureHandleId,
                                    TriggerHandleDesign(),
                                )
                            }
                        },
                    )

                    SettingsDestination.AnimationStyleSelect -> AnimationStyleSelectScreen(
                        settings = settings,
                        enabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = {
                            destination = SettingsDestination.Main
                        },
                        onStyleSelected = { style ->
                            lifecycleScope.launch {
                                app.settingsRepository.setGestureHintStyle(style)
                            }
                        },
                        onOpenStyleConfig = { style ->
                            destination = when (style) {
                                GestureHintStyle.WAVE -> SettingsDestination.WaveAnimationStyle
                                GestureHintStyle.CAPSULE -> SettingsDestination.CapsuleAnimationStyle
                                GestureHintStyle.BUBBLE -> SettingsDestination.BubbleAnimationStyle
                            }
                        },
                    )

                    SettingsDestination.WaveAnimationStyle -> WaveStyleSettingsScreen(
                        style = settings.activeWaveStyle(),
                        enabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = { destination = SettingsDestination.AnimationStyleSelect },
                        onStyleChange = { style ->
                            lifecycleScope.launch {
                                app.settingsRepository.updateWaveStyle(style)
                            }
                        },
                    )

                    SettingsDestination.CapsuleAnimationStyle -> CapsuleStyleSettingsScreen(
                        style = settings.activeCapsuleStyle(),
                        enabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = { destination = SettingsDestination.AnimationStyleSelect },
                        onStyleChange = { style ->
                            lifecycleScope.launch {
                                app.settingsRepository.updateCapsuleStyle(style)
                            }
                        },
                    )

                    SettingsDestination.BubbleAnimationStyle -> BubbleStyleSettingsScreen(
                        style = settings.activeBubbleStyle(),
                        enabled = settings.serviceEnabled && accessibilityGranted && notificationGranted,
                        onBack = { destination = SettingsDestination.AnimationStyleSelect },
                        onStyleChange = { style ->
                            lifecycleScope.launch {
                                app.settingsRepository.updateBubbleStyle(style)
                            }
                        },
                    )

                    SettingsDestination.GestureAngle -> GestureAngleSettingsScreen(
                        config = settings.gestureAngleConfig,
                        onBack = { destination = SettingsDestination.Main },
                        onSave = { config ->
                            lifecycleScope.launch {
                                app.settingsRepository.setGestureAngleConfig(config)
                            }
                        },
                    )

                    SettingsDestination.QuickLauncher -> QuickLauncherEditorScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.Main },
                        onSaveItems = { items ->
                            lifecycleScope.launch {
                                app.settingsRepository.setQuickLauncherItems(items)
                            }
                        },
                        onColumnsChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setQuickLauncherColumnsPerPage(value)
                            }
                        },
                        onRowsChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setQuickLauncherRowsPerPage(value)
                            }
                        },
                    )

                    SettingsDestination.ShellCommands -> ShellCommandPanelScreen(
                        settings = settings,
                        shizukuGranted = shizukuGranted,
                        onBack = { destination = SettingsDestination.Main },
                        onSaveCommands = { items ->
                            lifecycleScope.launch {
                                app.settingsRepository.setShellCommands(items)
                            }
                        },
                        onRequestShizuku = {
                            TaskManagerUtil.requestPermission()
                        },
                    )

                    SettingsDestination.WidgetPanel -> WidgetPanelSettingsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.Main },
                        onSavePages = { pages ->
                            lifecycleScope.launch {
                                app.settingsRepository.setWidgetPanelPages(pages)
                            }
                        },
                        onBlurEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setWidgetPanelBlurEnabled(enabled)
                            }
                        },
                        onWidthFractionChange = { fraction ->
                            lifecycleScope.launch {
                                app.settingsRepository.setWidgetPanelWidthFraction(fraction)
                            }
                        },
                    )

                    SettingsDestination.NotificationHistory -> NotificationHistoryScreen(
                        listenerEnabled = notificationListenerEnabled,
                        onBack = { destination = SettingsDestination.NotificationHub },
                        onRequestListenerAccess = {
                            startActivity(MediaSessionHelper.notificationListenerSettingsIntent())
                        },
                    )

                    SettingsDestination.OtpHub -> {
                        var officialRules by remember {
                            mutableStateOf(app.otpOfficialRulesLoader.getRules())
                        }
                        OtpHubScreen(
                            settings = settings,
                            officialRules = officialRules,
                            accessibilityGranted = accessibilityGranted,
                            onExit = { destination = SettingsDestination.NotificationHub },
                            onCopyToClipboardChange = { enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpCopyToClipboard(enabled)
                                }
                            },
                            onKeywordsRegexChange = { value ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpKeywordsRegex(value)
                                }
                            },
                            onRefreshOfficialRules = {
                                officialRules = app.otpOfficialRulesLoader.refresh()
                            },
                            onOfficialRuleEnabledChange = { ruleId, enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpOfficialRuleEnabled(ruleId, enabled)
                                }
                            },
                            onUserRulesChange = { rules ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpUserMatchRules(rules)
                                }
                            },
                            onAutoInputChange = { enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpAutoInputEnabled(enabled)
                                }
                            },
                            onAutoConfirmChange = { enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpAutoConfirmEnabled(enabled)
                                }
                            },
                            onAccessibilityAssistChange = { enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpAccessibilityAssistEnabled(enabled)
                                }
                            },
                            onDelayChange = { value ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpAutoInputDelayMs(value)
                                }
                            },
                            onIntervalChange = { value ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpAutoInputIntervalMs(value)
                                }
                            },
                            onRequestAccessibility = {
                                startActivity(PermissionHelper.accessibilitySettingsIntent())
                            },
                        )
                    }

                    SettingsDestination.OtpRecords -> OtpRecordsScreen(
                        onBack = { destination = otpRecordsBackDestination },
                        onOpenTestFlow = { destination = SettingsDestination.OtpHub },
                    )

                    SettingsDestination.OtpSettings -> {
                        val officialRules = remember { app.otpOfficialRulesLoader.getRules() }
                        OtpSettingsScreen(
                            settings = settings,
                            officialRules = officialRules,
                            onBack = { destination = SettingsDestination.NotificationHub },
                            onOpenAutoInput = { destination = SettingsDestination.OtpAutoInput },
                            onOpenMatchRules = { destination = SettingsDestination.OtpRulesList },
                            onOpenRecords = {
                                otpRecordsBackDestination = SettingsDestination.OtpSettings
                                destination = SettingsDestination.OtpRecords
                            },
                            onCopyToClipboardChange = { enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpCopyToClipboard(enabled)
                                }
                            },
                            onKeywordsRegexChange = { value ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpKeywordsRegex(value)
                                }
                            },
                        )
                    }

                    SettingsDestination.OtpRulesList -> {
                        var officialRules by remember {
                            mutableStateOf(app.otpOfficialRulesLoader.getRules())
                        }
                        OtpRulesListScreen(
                            officialRules = officialRules,
                            userRules = settings.otpUserMatchRules,
                            disabledOfficialRuleIds = settings.otpDisabledOfficialRuleIds,
                            onBack = { destination = SettingsDestination.OtpSettings },
                            onRefreshOfficialRules = {
                                officialRules = app.otpOfficialRulesLoader.refresh()
                            },
                            onOfficialRuleEnabledChange = { ruleId, enabled ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpOfficialRuleEnabled(ruleId, enabled)
                                }
                            },
                            onUserRulesChange = { rules ->
                                lifecycleScope.launch {
                                    app.settingsRepository.setOtpUserMatchRules(rules)
                                }
                            },
                        )
                    }

                    SettingsDestination.OtpAutoInput -> OtpAutoInputSettingsScreen(
                        settings = settings,
                        accessibilityGranted = accessibilityGranted,
                        onBack = { destination = SettingsDestination.OtpSettings },
                        onRequestAccessibility = {
                            startActivity(PermissionHelper.accessibilitySettingsIntent())
                        },
                        onAccessibilityAssistChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setOtpAccessibilityAssistEnabled(enabled)
                            }
                        },
                        onAutoInputChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setOtpAutoInputEnabled(enabled)
                            }
                        },
                        onAutoConfirmChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setOtpAutoConfirmEnabled(enabled)
                            }
                        },
                        onDelayChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setOtpAutoInputDelayMs(value)
                            }
                        },
                        onIntervalChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setOtpAutoInputIntervalMs(value)
                            }
                        },
                    )

                    SettingsDestination.FloatingPointer -> FloatingPointerSettingsScreen(
                        settings = settings,
                        areaPreviewEnabled = floatingPointerAreaPreviewEnabled,
                        previewAccessibilityGranted = accessibilityGranted,
                        onAreaPreviewEnabledChange = { floatingPointerAreaPreviewEnabled = it },
                        onBack = { destination = SettingsDestination.Main },
                        onOpenPointerSettings = {
                            destination = SettingsDestination.FloatingPointerPointer
                        },
                        onOpenJoystickSettings = {
                            destination = SettingsDestination.FloatingPointerJoystick
                        },
                        onOpenRadialMenuSettings = {
                            destination = SettingsDestination.FloatingPointerRadialMenu
                        },
                        onJoystickAreaZoomChange = { zoom ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickAreaZoomFraction(zoom)
                            }
                        },
                        onJoystickAreaWidthChange = { width ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickAreaWidthPx(width)
                            }
                        },
                        onJoystickAreaHeightChange = { height ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickAreaHeightPx(height)
                            }
                        },
                        onMatchJoystickToScreenAspectChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerMatchJoystickToScreenAspect(enabled)
                            }
                        },
                    )

                    SettingsDestination.FloatingPointerPointer -> FloatingPointerPointerSettingsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.FloatingPointer },
                        onPointerDiameterChange = { size ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerPointerDiameterPx(size)
                            }
                        },
                        onRingThicknessChange = { thickness ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRingThicknessPx(thickness)
                            }
                        },
                        onDotDiameterChange = { diameter ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerDotDiameterPx(diameter)
                            }
                        },
                        onRingColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRingColor(color)
                            }
                        },
                        onFillColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerFillColor(color)
                            }
                        },
                        onDotColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerDotColor(color)
                            }
                        },
                        onClickVisualFeedbackChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerClickVisualFeedbackEnabled(enabled)
                            }
                        },
                        onClickHapticChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerClickHapticEnabled(enabled)
                            }
                        },
                        onRippleColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRippleColor(color)
                            }
                        },
                        onRippleSizeChange = { size ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRippleSizeDp(size)
                            }
                        },
                        onRippleDurationChange = { duration ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRippleDurationMs(duration)
                            }
                        },
                        onTrailTypeChange = { type ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerTrailType(type)
                            }
                        },
                        onTrailDurationChange = { duration ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerTrailDurationMs(duration)
                            }
                        },
                        onTrailColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerTrailColor(color)
                            }
                        },
                        onHideWhenReleasedChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerHideWhenJoystickReleased(enabled)
                            }
                        },
                        onPointerDesignChange = { design ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerDesignId(design.id)
                            }
                        },
                        onResetVisualDefaults = {
                            lifecycleScope.launch {
                                app.settingsRepository.resetFloatingPointerVisualDefaults()
                            }
                        },
                    )

                    SettingsDestination.FloatingPointerJoystick -> FloatingPointerJoystickSettingsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.FloatingPointer },
                        onJoystickDiameterChange = { size ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickDiameterPx(size)
                            }
                        },
                        onInnerColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickInnerColor(color)
                            }
                        },
                        onOuterColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickOuterColor(color)
                            }
                        },
                        onGradientRadiusChange = { fraction ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerJoystickGradientRadiusFraction(fraction)
                            }
                        },
                        onHideOnOutsideClickChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerHideOnOutsideClick(enabled)
                            }
                        },
                        onHideOnQuickSwipeChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerHideOnQuickSwipe(enabled)
                            }
                        },
                        onHideWhenIdleChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerHideWhenIdle(enabled)
                            }
                        },
                        onIdleDelayChange = { delayMs ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerIdleHideDelayMs(delayMs)
                            }
                        },
                        onResetVisualDefaults = {
                            lifecycleScope.launch {
                                app.settingsRepository.resetFloatingPointerJoystickVisualDefaults()
                            }
                        },
                        onResetBehaviorDefaults = {
                            lifecycleScope.launch {
                                app.settingsRepository.resetFloatingPointerJoystickBehaviorDefaults()
                            }
                        },
                    )

                    SettingsDestination.FloatingPointerRadialMenu -> FloatingPointerRadialMenuSettingsScreen(
                        settings = settings,
                        onBack = { destination = SettingsDestination.FloatingPointer },
                        onEnabledChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialMenuEnabled(enabled)
                            }
                        },
                        onAlwaysVisibleChange = { enabled ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialAlwaysVisible(enabled)
                            }
                        },
                        onLongPressMsChange = { ms ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialLongPressMs(ms)
                            }
                        },
                        onSlotActionChange = { index, action ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialSlotAction(index, action)
                            }
                        },
                        onOuterDiameterChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialOuterDiameterPx(value)
                            }
                        },
                        onInnerDiameterChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialInnerDiameterPx(value)
                            }
                        },
                        onOuterColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialOuterColor(color)
                            }
                        },
                        onInnerColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialInnerColor(color)
                            }
                        },
                        onDividerThicknessChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialDividerThicknessPx(value)
                            }
                        },
                        onDividerColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialDividerColor(color)
                            }
                        },
                        onIconSizeFractionChange = { value ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialIconSizeFraction(value)
                            }
                        },
                        onIconColorChange = { color ->
                            lifecycleScope.launch {
                                app.settingsRepository.setFloatingPointerRadialIconColor(color)
                            }
                        },
                        onResetDesignDefaults = {
                            lifecycleScope.launch {
                                app.settingsRepository.resetFloatingPointerRadialDesignDefaults()
                            }
                        },
                    )
                    }
                }
                    if (destination.isRootDestination()) {
                        FloatingBottomNavBar(
                            selected = destination.toBottomNavDestination(),
                            onDestinationSelected = { tab ->
                                savedBottomNavTab = tab.name
                                destination = when (tab) {
                                    MainBottomNavDestination.Home -> SettingsDestination.Main
                                    MainBottomNavDestination.Shake -> SettingsDestination.ShakeGestures
                                    MainBottomNavDestination.Notification -> SettingsDestination.NotificationHub
                                    MainBottomNavDestination.Extension -> SettingsDestination.ExtensionHub
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .navigationBarsPadding()
                                .padding(horizontal = 24.dp)
                                .padding(bottom = MainBottomNavOuterPadding),
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshPermissionState()
        refreshServiceState()
        com.slideindex.app.widget.WidgetPopupHost.startListening(this)
        val app = application as SlideIndexApp
        lifecycleScope.launch {
            applyHideFromRecents(app.settingsRepository.settings.first().hideFromRecents)
        }
    }

    override fun onDestroy() {
        Shizuku.removeRequestPermissionResultListener(shizukuPermissionListener)
        super.onDestroy()
    }

    override fun onPause() {
        if (!WidgetBindTrampolineActivity.isActive() &&
            !WidgetPickerOverlayWindow.isShowing
        ) {
            com.slideindex.app.widget.WidgetPopupHost.stopListening(this)
        }
        if (!QuickLauncherAddTrampoline.isActive() &&
            !ShellCommandPanelTrampoline.isActive() &&
            !ShellCommandEditorTrampoline.isActive() &&
            !ShellCommandResultTrampoline.isActive()
        ) {
            sendOverlayPreviewIntent(OverlayService.ACTION_PREVIEW_STOP)
            FloatingPointerAreaPreviewOverlay.hide()
        }
        super.onPause()
    }

    private fun sendOverlayPreviewIntent(
        action: String,
        content: LayoutPreviewContent = LayoutPreviewContent.TRIGGER_ONLY,
    ) {
        if (!accessibilityGranted) return
        val intent = Intent(this, OverlayService::class.java)
            .setAction(action)
            .putExtra(OverlayService.EXTRA_PREVIEW_CONTENT, content.name)
        startService(intent)
    }

    private fun refreshPermissionState() {
        notificationGranted = PermissionHelper.hasNotificationPermission(this)
        usageAccessGranted = PermissionHelper.hasUsageAccess(this)
        shizukuGranted = TaskManagerUtil.hasPermission()
        accessibilityGranted = PermissionHelper.isAccessibilityServiceEnabled(this)
        batteryOptimizationExempt = PermissionHelper.isBatteryOptimizationExempt(this)
        writeSecureSettingsGranted = SecureSettingsHelper.hasWriteSecureSettings(this)
        notificationListenerEnabled = MediaSessionHelper.isNotificationListenerEnabled(this)
        if (shizukuGranted) {
            TaskManagerUtil.warmUp()
        }
    }

    private fun applyHideFromRecents(hide: Boolean) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return
        getSystemService(ActivityManager::class.java)
            ?.appTasks
            ?.firstOrNull()
            ?.setExcludeFromRecents(hide)
    }

    private fun refreshServiceState() {
        lifecycleScope.launch {
            val app = application as SlideIndexApp
            val settings = app.settingsRepository.settings.first()
            if (settings.accessibilityKeepAliveEnabled &&
                writeSecureSettingsGranted &&
                settings.serviceEnabled
            ) {
                SecureSettingsHelper.ensureAccessibilityEnabled(this@MainActivity)
                accessibilityGranted = PermissionHelper.isAccessibilityServiceEnabled(this@MainActivity)
            }
            val shouldRun = settings.serviceEnabled && accessibilityGranted && notificationGranted
            val serviceIntent = Intent(this@MainActivity, OverlayService::class.java)
            if (shouldRun) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(serviceIntent)
                } else {
                    startService(serviceIntent)
                }
            } else {
                stopService(serviceIntent)
            }
        }
    }
}
