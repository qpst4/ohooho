package com.slideindex.app.ui



import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.RadioButtonChecked

import androidx.compose.material3.AlertDialog

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi

import androidx.compose.material3.Icon

import androidx.compose.material3.RadioButton

import androidx.compose.material3.Text

import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue

import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding

import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp

import com.slideindex.app.R

import com.slideindex.app.overlay.FloatingPointerBounds

import com.slideindex.app.settings.AppSettings

import com.slideindex.app.settings.FloatBallPositionMode

import kotlin.math.roundToInt



@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

@Composable

fun FloatBallSettingsScreen(

    settings: AppSettings,

    accessibilityGranted: Boolean,

    onBack: () -> Unit,

    onEnabledChange: (Boolean) -> Unit,

    onSizeChange: (Float) -> Unit,

    onOpacityChange: (Float) -> Unit,

    onPositionModeChange: (FloatBallPositionMode) -> Unit,

    onPositionYChange: (Float) -> Unit,

    onPositionXChange: (Float) -> Unit,

    onLineHeightChange: (Float) -> Unit,

    onLineWidthChange: (Float) -> Unit,

    onLineOpacityChange: (Float) -> Unit,

    onPointerSpeedChange: (Float) -> Unit,

    onOcrFallbackChange: (Boolean) -> Unit,

) {

    var showPositionDialog by remember { mutableStateOf(false) }

    val controlsEnabled = settings.floatBallEnabled && accessibilityGranted



    SettingsScreenScaffold(

        title = stringResource(R.string.float_ball_settings_title),

        onBack = onBack,

    ) {

        SettingsHintText(stringResource(R.string.float_ball_settings_desc))



        SettingsSectionTitle(stringResource(R.string.settings_section_features))

        SettingsCard {

            SettingSwitchRow(

                title = stringResource(R.string.float_ball_enabled),

                subtitle = if (accessibilityGranted) {

                    stringResource(R.string.float_ball_enabled_desc)

                } else {

                    stringResource(R.string.float_ball_permission_required)

                },

                checked = settings.floatBallEnabled,

                enabled = accessibilityGranted,

                onCheckedChange = onEnabledChange,

            )

        }



        SettingsSectionTitle(stringResource(R.string.float_ball_section_appearance))

        SettingsCard {

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_size),

                value = settings.floatBallSizeDp,

                valueRange = 36f..72f,

                steps = 8,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.float_ball_size_value,

                    settings.floatBallSizeDp,

                ),

                onValueChange = onSizeChange,

            )

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_opacity),

                value = settings.floatBallOpacity,

                valueRange = 0.3f..1f,

                steps = 6,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.floating_pointer_percent_value,

                    (settings.floatBallOpacity * 100).roundToInt(),

                ),

                onValueChange = onOpacityChange,

            )

            SettingNavigationRow(
                icon = { label -> Icon(Icons.Default.Place, contentDescription = label) },
                title = stringResource(R.string.float_ball_position),
                subtitle = floatBallPositionModeLabel(settings.floatBallPositionMode),
                enabled = controlsEnabled,
                onClick = { showPositionDialog = true },
            )
            SettingsSliderRow(
                title = stringResource(R.string.float_ball_position_y),
                value = settings.floatBallPositionYFraction,
                valueRange = 0.05f..0.95f,
                steps = 17,
                enabled = controlsEnabled,
                label = stringResource(
                    R.string.floating_pointer_percent_value,
                    (settings.floatBallPositionYFraction * 100).roundToInt(),
                ),
                onValueChange = onPositionYChange,
            )
            if (settings.floatBallPositionMode == FloatBallPositionMode.CUSTOM) {
                SettingsSliderRow(
                    title = stringResource(R.string.float_ball_position_x),
                    value = settings.floatBallPositionXFraction,
                    valueRange = 0.05f..0.95f,
                    steps = 17,
                    enabled = controlsEnabled,
                    label = stringResource(
                        R.string.floating_pointer_percent_value,
                        (settings.floatBallPositionXFraction * 100).roundToInt(),
                    ),
                    onValueChange = onPositionXChange,
                )
            }
        }

        SettingsHintText(stringResource(R.string.float_ball_position_y_hint))

        SettingsSectionTitle(stringResource(R.string.float_ball_section_line))

        SettingsCard {

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_line_height),

                value = settings.floatBallLineHeightFraction,

                valueRange = 0.04f..0.4f,

                steps = 8,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.floating_pointer_percent_value,

                    (settings.floatBallLineHeightFraction * 100).roundToInt(),

                ),

                onValueChange = onLineHeightChange,

            )

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_line_width),

                value = settings.floatBallLineWidthFraction,

                valueRange = 0.04f..0.5f,

                steps = 9,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.floating_pointer_percent_value,

                    (settings.floatBallLineWidthFraction * 100).roundToInt(),

                ),

                onValueChange = onLineWidthChange,

            )

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_line_opacity),

                value = settings.floatBallLineOpacity,

                valueRange = 0.1f..1f,

                steps = 8,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.floating_pointer_percent_value,

                    (settings.floatBallLineOpacity * 100).roundToInt(),

                ),

                onValueChange = onLineOpacityChange,

            )

        }

        SettingsHintText(stringResource(R.string.float_ball_line_hint))



        SettingsSectionTitle(stringResource(R.string.float_ball_section_text_pick))

        SettingsCard {

            SettingsSliderRow(

                title = stringResource(R.string.float_ball_pointer_speed),

                value = settings.floatBallPointerSpeedFraction,

                valueRange = FloatingPointerBounds.SENSITIVITY_MIN..FloatingPointerBounds.SENSITIVITY_MAX,

                steps = 10,

                enabled = controlsEnabled,

                label = stringResource(

                    R.string.floating_pointer_percent_value,

                    (settings.floatBallPointerSpeedFraction * 100).roundToInt(),

                ),

                onValueChange = onPointerSpeedChange,

            )

            SettingSwitchRow(

                title = stringResource(R.string.float_ball_ocr_fallback),

                subtitle = stringResource(R.string.float_ball_ocr_fallback_desc),

                checked = settings.floatBallOcrFallbackEnabled,

                enabled = controlsEnabled,

                onCheckedChange = onOcrFallbackChange,

            )

        }



        SettingsHintText(stringResource(R.string.float_ball_pointer_speed_hint))

        SettingsHintText(stringResource(R.string.float_ball_usage_hint))

    }



    if (showPositionDialog) {

        FloatBallPositionModeDialog(

            selected = settings.floatBallPositionMode,

            onDismiss = { showPositionDialog = false },

            onSelect = {

                onPositionModeChange(it)

                showPositionDialog = false

            },

        )

    }

}



@Composable

private fun floatBallPositionModeLabel(mode: FloatBallPositionMode): String =

    when (mode) {

        FloatBallPositionMode.LEFT -> stringResource(R.string.float_ball_position_left)

        FloatBallPositionMode.RIGHT -> stringResource(R.string.float_ball_position_right)

        FloatBallPositionMode.BOTH_EDGES -> stringResource(R.string.float_ball_position_both_edges)

        FloatBallPositionMode.CUSTOM -> stringResource(R.string.float_ball_position_custom)

    }



@Composable

private fun FloatBallPositionModeDialog(

    selected: FloatBallPositionMode,

    onDismiss: () -> Unit,

    onSelect: (FloatBallPositionMode) -> Unit,

) {

    AlertDialog(

        onDismissRequest = onDismiss,

        title = { Text(stringResource(R.string.float_ball_position)) },

        text = {

            Column {

                FloatBallPositionMode.entries.forEach { mode ->

                    Row(

                        modifier = Modifier

                            .fillMaxWidth()

                            .clickable { onSelect(mode) }

                            .padding(vertical = 8.dp),

                        verticalAlignment = Alignment.CenterVertically,

                    ) {

                        RadioButton(

                            selected = mode == selected,

                            onClick = { onSelect(mode) },

                        )

                        Text(

                            text = floatBallPositionModeLabel(mode),

                            modifier = Modifier.padding(start = 8.dp),

                        )

                    }

                }

            }

        },

        confirmButton = {

            TextButton(onClick = onDismiss) {

                Text(stringResource(R.string.cancel))

            }

        },

    )

}



@Composable

fun FloatBallEntryCard(

    settings: AppSettings,

    enabled: Boolean,

    onClick: () -> Unit,

) {

    val subtitle = when {

        !enabled -> stringResource(R.string.float_ball_entry_desc)

        settings.floatBallEnabled -> stringResource(

            R.string.float_ball_entry_summary_enabled,

            settings.floatBallSizeDp,

            (settings.floatBallOpacity * 100).roundToInt(),

        )

        else -> stringResource(R.string.float_ball_entry_summary_disabled)

    }

    SettingNavigationRow(

        icon = { label -> Icon(Icons.Default.RadioButtonChecked, contentDescription = label) },

        title = stringResource(R.string.float_ball_settings_title),

        subtitle = subtitle,

        enabled = enabled,

        onClick = onClick,

    )

}


