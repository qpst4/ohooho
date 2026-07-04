package com.slideindex.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwipeRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.settings.AppSettings
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainScreen(
    settings: AppSettings,
    overlayGranted: Boolean,
    notificationGranted: Boolean,
    shizukuGranted: Boolean,
    accessibilityGranted: Boolean,
    onRequestOverlay: () -> Unit,
    onRequestNotification: () -> Unit,
    onRequestShizuku: () -> Unit,
    onRequestAccessibility: () -> Unit,
    onHapticEnabledChange: (Boolean) -> Unit,
    onHapticStrengthChange: (Int) -> Unit,
    onOpenLayoutSettings: () -> Unit,
    onOpenFreeWindowSettings: () -> Unit,
    onOpenHiddenAppsSettings: () -> Unit,
    onOpenExcludedAppsSettings: () -> Unit,
    onOpenTriggerCollection: () -> Unit,
    onOpenGestureAngle: () -> Unit,
    onOpenQuickLauncher: () -> Unit,
    onOpenShellCommands: () -> Unit,
    onThemeColorChange: (Int) -> Unit,
) {
    val permissionsReady = overlayGranted && notificationGranted
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val pendingPermissions = buildList {
        if (!overlayGranted) {
            add(
                PendingPermissionItem(
                    title = stringResource(R.string.permission_overlay_title),
                    description = stringResource(R.string.permission_overlay_desc),
                    grantLabel = stringResource(R.string.grant_permission),
                    onGrant = onRequestOverlay,
                ),
            )
        }
        if (!notificationGranted) {
            add(
                PendingPermissionItem(
                    title = stringResource(R.string.permission_notification_title),
                    description = stringResource(R.string.permission_notification_desc),
                    grantLabel = stringResource(R.string.grant_permission),
                    onGrant = onRequestNotification,
                ),
            )
        }
        if (!shizukuGranted) {
            add(
                PendingPermissionItem(
                    title = stringResource(R.string.permission_shizuku_title),
                    description = stringResource(R.string.permission_shizuku_desc),
                    grantLabel = stringResource(R.string.permission_shizuku_grant),
                    onGrant = onRequestShizuku,
                ),
            )
        }
        if (!accessibilityGranted) {
            add(
                PendingPermissionItem(
                    title = stringResource(R.string.permission_accessibility_title),
                    description = stringResource(R.string.permission_accessibility_desc),
                    grantLabel = stringResource(R.string.permission_accessibility_grant),
                    onGrant = onRequestAccessibility,
                ),
            )
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeFlexibleTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineSmallEmphasized,
                    )
                },
                subtitle = {
                    Text(stringResource(R.string.main_settings_subtitle))
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            PendingPermissionsCard(items = pendingPermissions)

            if (permissionsReady) {
                Text(
                    text = stringResource(R.string.ready_hint),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 4.dp),
                )
            }

            SettingsSectionTitle(stringResource(R.string.settings_section_gestures))
            SettingsCard {
                SettingNavigationRow(
                    icon = { Icon(Icons.Default.SwipeRight, contentDescription = null) },
                    title = stringResource(R.string.trigger_collection_title),
                    subtitle = stringResource(R.string.trigger_collection_desc),
                    onClick = onOpenTriggerCollection,
                )
                GestureAngleEntryCard(
                    enabled = permissionsReady,
                    onClick = onOpenGestureAngle,
                )
            }

            SettingsSectionTitle(stringResource(R.string.settings_section_features))
            SettingsCard {
                LayoutSettingsEntryCard(
                    settings = settings,
                    enabled = permissionsReady,
                    onClick = onOpenLayoutSettings,
                )
                QuickLauncherEntryCard(
                    settings = settings,
                    enabled = permissionsReady,
                    onClick = onOpenQuickLauncher,
                )
                ShellCommandEntryCard(
                    commandCount = settings.shellCommands.size,
                    onClick = onOpenShellCommands,
                )
            }

            SettingsSectionTitle(stringResource(R.string.settings_section_apps))
            SettingsCard {
                HiddenAppsEntryCard(
                    hiddenCount = settings.hiddenAppPackages.size,
                    onClick = onOpenHiddenAppsSettings,
                )
                ExcludedAppsEntryCard(
                    excludedCount = settings.excludedTriggerAppPackages.size,
                    onClick = onOpenExcludedAppsSettings,
                )
                FreeWindowEntryCard(onClick = onOpenFreeWindowSettings)
            }

            SettingsSectionTitle(stringResource(R.string.settings_section_feedback_appearance))
            SettingsCard {
                SettingSwitchRow(
                    title = stringResource(R.string.haptic_enabled),
                    checked = settings.hapticEnabled,
                    enabled = true,
                    onCheckedChange = onHapticEnabledChange,
                )
                if (settings.hapticEnabled) {
                    SettingsSliderRow(
                        title = stringResource(R.string.haptic_strength),
                        value = settings.hapticStrengthLevel.toFloat(),
                        valueRange = 0f..2f,
                        steps = 1,
                        enabled = true,
                        label = hapticStrengthLabel(settings.hapticStrengthLevel),
                        onValueChange = { onHapticStrengthChange(it.roundToInt()) },
                    )
                }
                ThemeColorPicker(
                    selected = settings.themeColorArgb,
                    enabled = permissionsReady,
                    onColorSelected = onThemeColorChange,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun hapticStrengthLabel(level: Int): String {
    return when (level) {
        0 -> stringResource(R.string.haptic_strength_light)
        2 -> stringResource(R.string.haptic_strength_strong)
        else -> stringResource(R.string.haptic_strength_medium)
    }
}
