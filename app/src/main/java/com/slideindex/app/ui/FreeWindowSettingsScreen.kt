package com.slideindex.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CropFree
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumFlexibleTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.settings.AppLaunchPolicy
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FreeWindowMode
import com.slideindex.app.settings.effectiveLongPressDurationMs
import com.slideindex.app.settings.resolvedFreeWindowMode
import com.slideindex.app.settings.resolvedLaunchPolicy

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FreeWindowSettingsScreen(
    settings: AppSettings,
    onBack: () -> Unit,
    onEnabledChange: (Boolean) -> Unit,
    onLaunchPolicyChange: (Int) -> Unit,
    onLongPressDurationChange: (Int) -> Unit,
    onModeChange: (Int) -> Unit,
    onOpenPreview: () -> Unit,
) {
    var showModeDialog by remember { mutableStateOf(false) }
    var showPolicyDialog by remember { mutableStateOf(false) }
    val selectedMode = settings.resolvedFreeWindowMode()
    val selectedPolicy = settings.resolvedLaunchPolicy()
    val longPressDuration = settings.effectiveLongPressDurationMs()
    val showLongPressDuration = settings.freeWindowEnabled && selectedPolicy.usesLongPress()

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumFlexibleTopAppBar(
                title = { SettingsAppBarTitle(stringResource(R.string.free_window_settings_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
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
            SettingsSectionTitle(stringResource(R.string.settings_section_service))
            SettingsCard {
                SettingToggleRow(
                    icon = { Icon(Icons.Default.PowerSettingsNew, contentDescription = null) },
                    title = stringResource(R.string.free_window_enabled),
                    subtitle = stringResource(R.string.free_window_enabled_desc),
                    checked = settings.freeWindowEnabled,
                    onCheckedChange = onEnabledChange,
                )
            }
            SettingsHintText(stringResource(R.string.free_window_portrait_only_hint))

            SettingsSectionTitle(stringResource(R.string.settings_section_launch))
            SettingsCard {
                SettingNavigationRow(
                    icon = { Icon(Icons.Default.TouchApp, contentDescription = null) },
                    title = stringResource(R.string.launch_policy_title),
                    subtitle = stringResource(selectedPolicy.titleRes),
                    onClick = { showPolicyDialog = true },
                )
            }
            if (showLongPressDuration) {
                SettingsCard {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.long_press_launch_duration),
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = stringResource(R.string.long_press_launch_duration_desc),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            Text(
                                text = stringResource(
                                    R.string.long_press_launch_duration_value,
                                    longPressDuration,
                                ),
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                        Slider(
                            value = longPressDuration.toFloat(),
                            onValueChange = { value ->
                                val snapped = (value / 50f).toInt() * 50
                                onLongPressDurationChange(snapped.coerceIn(250, 900))
                            },
                            valueRange = 250f..900f,
                            steps = 12,
                        )
                    }
                }
            }

            SettingsSectionTitle(stringResource(R.string.settings_section_free_window))
            SettingsCard {
                SettingNavigationRow(
                    icon = { Icon(Icons.Default.Layers, contentDescription = null) },
                    title = stringResource(R.string.free_window_launch_mode),
                    subtitle = stringResource(selectedMode.titleRes),
                    enabled = settings.freeWindowEnabled,
                    onClick = { showModeDialog = true },
                )
                SettingNavigationRow(
                    icon = { Icon(Icons.Default.Tune, contentDescription = null) },
                    title = stringResource(R.string.free_window_adjust_layout),
                    subtitle = stringResource(R.string.free_window_adjust_layout_desc),
                    enabled = settings.freeWindowEnabled,
                    onClick = onOpenPreview,
                )
            }
            SettingsHintText(stringResource(R.string.free_window_mode_hint))
        }
    }

    AnimatedFullScreenOverlay(visible = showPolicyDialog) {
        SettingsRadioPickerScreen(
            title = stringResource(R.string.launch_policy_dialog_title),
            onBack = { showPolicyDialog = false },
        ) {
            AppLaunchPolicy.entries.forEach { policy ->
                SettingRadioRow(
                    title = stringResource(policy.titleRes),
                    subtitle = stringResource(policy.descRes),
                    selected = policy.id == selectedPolicy.id,
                    onClick = {
                        onLaunchPolicyChange(policy.id)
                        showPolicyDialog = false
                    },
                )
            }
        }
    }

    AnimatedFullScreenOverlay(visible = showModeDialog) {
        SettingsRadioPickerScreen(
            title = stringResource(R.string.free_window_mode_dialog_title),
            onBack = { showModeDialog = false },
        ) {
            FreeWindowMode.entries.forEach { mode ->
                SettingRadioRow(
                    title = stringResource(mode.titleRes),
                    subtitle = stringResource(mode.descRes),
                    selected = mode.id == selectedMode.id,
                    onClick = {
                        onModeChange(mode.id)
                        showModeDialog = false
                    },
                )
            }
        }
    }
}

@Composable
fun FreeWindowEntryCard(onClick: () -> Unit) {
    SettingNavigationRow(
        icon = { Icon(Icons.Default.CropFree, contentDescription = null) },
        title = stringResource(R.string.free_window_entry_title),
        subtitle = stringResource(R.string.free_window_entry_desc),
        onClick = onClick,
    )
}
