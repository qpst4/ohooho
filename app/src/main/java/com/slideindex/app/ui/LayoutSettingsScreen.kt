package com.slideindex.app.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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

    SettingsScreenScaffold(
        title = stringResource(R.string.layout_settings_title),
        subtitle = stringResource(R.string.layout_settings_entry_desc),
        onBack = onBack,
    ) {
        SettingsHintText(stringResource(R.string.live_preview_hint))

        SettingsSectionTitle(stringResource(R.string.settings_section_panel))
        SettingsCard {
            SettingsSliderRow(
                title = stringResource(R.string.index_height),
                value = settings.indexHeightFraction,
                valueRange = 0.25f..0.65f,
                enabled = serviceEnabled,
                label = "",
                formatLabel = { "${(it * 100).roundToInt()}%" },
                triggersLayoutPreview = true,
                onLayoutPreviewStart = onLayoutPreviewStart,
                onLayoutPreviewStop = onLayoutPreviewStop,
                onValueChange = onIndexHeightChange,
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            SettingsSliderRow(
                title = stringResource(R.string.apps_per_row),
                value = settings.appsPerRow.toFloat(),
                valueRange = 2f..5f,
                steps = 2,
                enabled = serviceEnabled,
                label = "${settings.appsPerRow} 列",
                onValueChange = { onAppsPerRowChange(it.roundToInt()) },
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            SettingsSliderRow(
                title = stringResource(R.string.panel_opacity),
                value = settings.panelOpacity,
                valueRange = 0.75f..1f,
                enabled = serviceEnabled,
                label = "",
                formatLabel = { "${(it * 100).roundToInt()}%" },
                onValueChange = onPanelOpacityChange,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
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
