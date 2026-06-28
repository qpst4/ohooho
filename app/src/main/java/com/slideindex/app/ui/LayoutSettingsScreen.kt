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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.settings.AppSettings
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutSettingsScreen(
    settings: AppSettings,
    serviceEnabled: Boolean,
    onBack: () -> Unit,
    onIndexHeightChange: (Float) -> Unit,
    onAppsPerRowChange: (Int) -> Unit,
    onPanelOpacityChange: (Float) -> Unit,
    onLayoutPreviewStart: () -> Unit,
    onLayoutPreviewStop: () -> Unit,
) {
    DisposableEffect(Unit) {
        onDispose { onLayoutPreviewStop() }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.layout_settings_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
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
            SettingsHintText(stringResource(R.string.live_preview_hint))

            SettingsSectionTitle(stringResource(R.string.settings_section_panel))
            SettingsCard {
                SettingsSliderRow(
                    title = stringResource(R.string.index_height),
                    value = settings.indexHeightFraction,
                    valueRange = 0.25f..0.65f,
                    enabled = serviceEnabled,
                    label = "${(settings.indexHeightFraction * 100).roundToInt()}%",
                    triggersLayoutPreview = true,
                    onLayoutPreviewStart = onLayoutPreviewStart,
                    onLayoutPreviewStop = onLayoutPreviewStop,
                    onValueChange = onIndexHeightChange,
                )
                SettingsSliderRow(
                    title = stringResource(R.string.apps_per_row),
                    value = settings.appsPerRow.toFloat(),
                    valueRange = 2f..5f,
                    steps = 2,
                    enabled = serviceEnabled,
                    label = "${settings.appsPerRow} 列",
                    onValueChange = { onAppsPerRowChange(it.roundToInt()) },
                )
                SettingsSliderRow(
                    title = stringResource(R.string.panel_opacity),
                    value = settings.panelOpacity,
                    valueRange = 0.75f..1f,
                    enabled = serviceEnabled,
                    label = "${(settings.panelOpacity * 100).roundToInt()}%",
                    onValueChange = onPanelOpacityChange,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun LayoutSettingsEntryCard(
    settings: AppSettings,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val subtitle = if (enabled) {
        stringResource(
            R.string.layout_settings_entry_summary,
            settings.appsPerRow,
        )
    } else {
        stringResource(R.string.layout_settings_entry_desc)
    }
    SettingNavigationRow(
        icon = { Icon(Icons.Default.Tune, contentDescription = null) },
        title = stringResource(R.string.layout_settings_entry_title),
        subtitle = subtitle,
        enabled = enabled,
        onClick = onClick,
    )
}
