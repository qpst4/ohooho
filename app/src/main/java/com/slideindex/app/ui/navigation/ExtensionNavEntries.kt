package com.slideindex.app.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import com.slideindex.app.ui.ExtensionHubScreen
import com.slideindex.app.ui.FloatingPointerJoystickSettingsScreen
import com.slideindex.app.ui.FloatingPointerPointerSettingsScreen
import com.slideindex.app.ui.FloatingPointerRadialMenuSettingsScreen
import com.slideindex.app.ui.FloatingPointerSettingsScreen
import com.slideindex.app.ui.QuickLauncherEditorScreen
import com.slideindex.app.ui.ShellCommandPanelScreen
import com.slideindex.app.ui.WidgetPanelSettingsScreen
import com.slideindex.app.ui.viewmodel.ExtensionHubViewModel

fun EntryProviderScope<AppNavKey>.extensionNavEntries(ctx: MainNavContext) {
    entry<AppNavKey.ExtensionHub> {
        val permissions = ctx.collectPermissions()
        val viewModel: ExtensionHubViewModel = hiltViewModel()
        val settings by viewModel.settings.collectAsStateWithLifecycle()
        ExtensionHubScreen(
            settings = settings,
            gestureActive = ctx.gestureActive(settings, permissions),
            bottomContentPadding = ctx.rootBottomContentPadding,
            onOpenLayoutSettings = { ctx.navigate(AppNavKey.HomeLayout) },
            onOpenQuickLauncher = { ctx.navigate(AppNavKey.QuickLauncher) },
            onOpenShellCommands = { ctx.navigate(AppNavKey.ShellCommands) },
            onOpenWidgetPanel = { ctx.navigate(AppNavKey.WidgetPanel) },
            onOpenFloatingPointer = { ctx.navigate(AppNavKey.FloatingPointer) },
        )
    }

    entry<AppNavKey.QuickLauncher> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        QuickLauncherEditorScreen(
            settings = settings,
            onBack = { ctx.replaceRoot(AppNavKey.HomeMain) },
            onSaveItems = { items ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setQuickLauncherItems(items)
                }
            },
            onColumnsChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setQuickLauncherColumnsPerPage(value)
                }
            },
            onRowsChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setQuickLauncherRowsPerPage(value)
                }
            },
        )
    }

    entry<AppNavKey.ShellCommands> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        ShellCommandPanelScreen(
            settings = settings,
            shizukuGranted = permissions.shizukuGranted,
            onBack = { ctx.replaceRoot(AppNavKey.HomeMain) },
            onSaveCommands = { items ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setShellCommands(items)
                }
            },
            onRequestShizuku = { ctx.requestShizuku() },
        )
    }

    entry<AppNavKey.WidgetPanel> {
        val settings = ctx.collectAppSettings()
        WidgetPanelSettingsScreen(
            settings = settings,
            onBack = { ctx.replaceRoot(AppNavKey.HomeMain) },
            onSavePages = { pages ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setWidgetPanelPages(pages)
                }
            },
            onBlurEnabledChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setWidgetPanelBlurEnabled(enabled)
                }
            },
            onWidthFractionChange = { fraction ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setWidgetPanelWidthFraction(fraction)
                }
            },
        )
    }

    entry<AppNavKey.FloatingPointer> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        val areaPreviewEnabled = ctx.collectAreaPreviewEnabled()
        FloatingPointerSettingsScreen(
            settings = settings,
            areaPreviewEnabled = areaPreviewEnabled,
            previewAccessibilityGranted = permissions.accessibilityGranted,
            onAreaPreviewEnabledChange = { ctx.setFloatingPointerAreaPreviewEnabled(it) },
            onBack = { ctx.replaceRoot(AppNavKey.HomeMain) },
            onOpenPointerSettings = { ctx.navigate(AppNavKey.FloatingPointerPointer) },
            onOpenJoystickSettings = { ctx.navigate(AppNavKey.FloatingPointerJoystick) },
            onOpenRadialMenuSettings = { ctx.navigate(AppNavKey.FloatingPointerRadialMenu) },
            onJoystickAreaZoomChange = { zoom ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickAreaZoomFraction(zoom)
                }
            },
            onJoystickAreaWidthChange = { width ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickAreaWidthPx(width)
                }
            },
            onJoystickAreaHeightChange = { height ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickAreaHeightPx(height)
                }
            },
            onMatchJoystickToScreenAspectChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerMatchJoystickToScreenAspect(enabled)
                }
            },
        )
    }

    entry<AppNavKey.FloatingPointerPointer> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        FloatingPointerPointerSettingsScreen(
            settings = settings,
            onBack = { ctx.navigateBackTo(AppNavKey.FloatingPointer) },
            onPointerDiameterChange = { size ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerPointerDiameterPx(size)
                }
            },
            onRingThicknessChange = { thickness ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRingThicknessPx(thickness)
                }
            },
            onDotDiameterChange = { diameter ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerDotDiameterPx(diameter)
                }
            },
            onRingColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRingColor(color)
                }
            },
            onFillColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerFillColor(color)
                }
            },
            onDotColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerDotColor(color)
                }
            },
            onClickVisualFeedbackChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerClickVisualFeedbackEnabled(enabled)
                }
            },
            onClickHapticChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerClickHapticEnabled(enabled)
                }
            },
            onRippleColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRippleColor(color)
                }
            },
            onRippleSizeChange = { size ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRippleSizeDp(size)
                }
            },
            onRippleDurationChange = { duration ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRippleDurationMs(duration)
                }
            },
            onTrailTypeChange = { type ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerTrailType(type)
                }
            },
            onTrailDurationChange = { duration ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerTrailDurationMs(duration)
                }
            },
            onTrailColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerTrailColor(color)
                }
            },
            onHideWhenReleasedChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerHideWhenJoystickReleased(enabled)
                }
            },
            onPointerDesignChange = { design ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerDesignId(design.id)
                }
            },
            onResetVisualDefaults = {
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.resetFloatingPointerVisualDefaults()
                }
            },
        )
    }

    entry<AppNavKey.FloatingPointerJoystick> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        FloatingPointerJoystickSettingsScreen(
            settings = settings,
            onBack = { ctx.navigateBackTo(AppNavKey.FloatingPointer) },
            onJoystickDiameterChange = { size ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickDiameterPx(size)
                }
            },
            onInnerColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickInnerColor(color)
                }
            },
            onOuterColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickOuterColor(color)
                }
            },
            onGradientRadiusChange = { fraction ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerJoystickGradientRadiusFraction(fraction)
                }
            },
            onHideOnOutsideClickChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerHideOnOutsideClick(enabled)
                }
            },
            onHideOnQuickSwipeChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerHideOnQuickSwipe(enabled)
                }
            },
            onHideWhenIdleChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerHideWhenIdle(enabled)
                }
            },
            onIdleDelayChange = { delayMs ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerIdleHideDelayMs(delayMs)
                }
            },
            onResetVisualDefaults = {
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.resetFloatingPointerJoystickVisualDefaults()
                }
            },
            onResetBehaviorDefaults = {
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.resetFloatingPointerJoystickBehaviorDefaults()
                }
            },
        )
    }

    entry<AppNavKey.FloatingPointerRadialMenu> {
        val settings = ctx.collectAppSettings()
        val permissions = ctx.collectPermissions()
        FloatingPointerRadialMenuSettingsScreen(
            settings = settings,
            onBack = { ctx.navigateBackTo(AppNavKey.FloatingPointer) },
            onEnabledChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialMenuEnabled(enabled)
                }
            },
            onAlwaysVisibleChange = { enabled ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialAlwaysVisible(enabled)
                }
            },
            onLongPressMsChange = { ms ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialLongPressMs(ms)
                }
            },
            onSlotActionChange = { index, action ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialSlotAction(index, action)
                }
            },
            onOuterDiameterChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialOuterDiameterPx(value)
                }
            },
            onInnerDiameterChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialInnerDiameterPx(value)
                }
            },
            onOuterColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialOuterColor(color)
                }
            },
            onInnerColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialInnerColor(color)
                }
            },
            onDividerThicknessChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialDividerThicknessPx(value)
                }
            },
            onDividerColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialDividerColor(color)
                }
            },
            onIconSizeFractionChange = { value ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialIconSizeFraction(value)
                }
            },
            onIconColorChange = { color ->
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.setFloatingPointerRadialIconColor(color)
                }
            },
            onResetDesignDefaults = {
                ctx.launchSettingsChange {
                    ctx.deps.settingsRepository.resetFloatingPointerRadialDesignDefaults()
                }
            },
        )
    }
}
