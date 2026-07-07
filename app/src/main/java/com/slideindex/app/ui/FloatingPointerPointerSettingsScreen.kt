package com.slideindex.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.overlay.FloatingPointerRingPreview
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatingPointerTrailType
import com.slideindex.app.ui.animationstyle.AnimationStyleColorPickerDialog
import com.slideindex.app.ui.animationstyle.AnimationStyleColorRow
import kotlin.math.roundToInt

private enum class PointerColorTarget {
    Ring,
    Fill,
    Dot,
    Trail,
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingPointerPointerSettingsScreen(
    settings: AppSettings,
    onBack: () -> Unit,
    onPointerDiameterChange: (Float) -> Unit,
    onRingThicknessChange: (Float) -> Unit,
    onDotDiameterChange: (Float) -> Unit,
    onRingColorChange: (Int) -> Unit,
    onFillColorChange: (Int) -> Unit,
    onDotColorChange: (Int) -> Unit,
    onTrailTypeChange: (FloatingPointerTrailType) -> Unit,
    onTrailDurationChange: (Int) -> Unit,
    onTrailColorChange: (Int) -> Unit,
    onHideWhenReleasedChange: (Boolean) -> Unit,
    onResetVisualDefaults: () -> Unit,
) {
    var colorTarget by remember { mutableStateOf<PointerColorTarget?>(null) }
    var pickerInitialColor by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current.density

    @Composable
    fun pxDpLabel(px: Float): String = stringResource(
        R.string.floating_pointer_size_px_dp_value,
        px.roundToInt(),
        px / density,
    )

    if (colorTarget != null) {
        AnimationStyleColorPickerDialog(
            initialColor = pickerInitialColor,
            onDismissRequest = { colorTarget = null },
            onColorPicked = { color ->
                when (colorTarget) {
                    PointerColorTarget.Ring -> onRingColorChange(color)
                    PointerColorTarget.Fill -> onFillColorChange(color)
                    PointerColorTarget.Dot -> onDotColorChange(color)
                    PointerColorTarget.Trail -> onTrailColorChange(color)
                    null -> Unit
                }
                colorTarget = null
            },
        )
    }

    SettingsScreenScaffold(
        title = stringResource(R.string.floating_pointer_pointer_settings_title),
        onBack = onBack,
    ) {
        SettingsSectionTitle(stringResource(R.string.floating_pointer_preview_section))
        Surface(
            modifier = Modifier.padding(bottom = 4.dp),
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
        ) {
            FloatingPointerRingPreview(settings = settings)
        }

        SettingsSectionTitle(stringResource(R.string.floating_pointer_settings_section_pointer))
        SettingsCard {
            SettingsSliderRow(
                title = stringResource(R.string.floating_pointer_pointer_size),
                value = settings.floatingPointerPointerDiameterPx,
                valueRange = 48f..120f,
                steps = 17,
                enabled = true,
                label = stringResource(
                    R.string.floating_pointer_size_px_value,
                    settings.floatingPointerPointerDiameterPx.roundToInt(),
                ),
                onValueChange = onPointerDiameterChange,
            )
            SettingsSliderRow(
                title = stringResource(R.string.floating_pointer_ring_thickness),
                value = settings.floatingPointerRingThicknessPx,
                valueRange = 4f..24f,
                steps = 19,
                enabled = true,
                label = pxDpLabel(settings.floatingPointerRingThicknessPx),
                onValueChange = onRingThicknessChange,
            )
            SettingsSliderRow(
                title = stringResource(R.string.floating_pointer_dot_diameter),
                value = settings.floatingPointerDotDiameterPx,
                valueRange = 2f..24f,
                steps = 21,
                enabled = true,
                label = pxDpLabel(settings.floatingPointerDotDiameterPx),
                onValueChange = onDotDiameterChange,
            )
            AnimationStyleColorRow(
                title = stringResource(R.string.floating_pointer_ring_color),
                color = settings.floatingPointerRingColorArgb,
                enabled = true,
                onClick = {
                    pickerInitialColor = settings.floatingPointerRingColorArgb
                    colorTarget = PointerColorTarget.Ring
                },
            )
            AnimationStyleColorRow(
                title = stringResource(R.string.floating_pointer_fill_color),
                subtitle = stringResource(R.string.floating_pointer_fill_color_desc),
                color = settings.floatingPointerFillColorArgb,
                enabled = true,
                onClick = {
                    pickerInitialColor = settings.floatingPointerFillColorArgb
                    colorTarget = PointerColorTarget.Fill
                },
            )
            AnimationStyleColorRow(
                title = stringResource(R.string.floating_pointer_dot_color),
                color = settings.floatingPointerDotColorArgb,
                enabled = true,
                onClick = {
                    pickerInitialColor = settings.floatingPointerDotColorArgb
                    colorTarget = PointerColorTarget.Dot
                },
            )
        }

        SettingsSectionTitle(stringResource(R.string.floating_pointer_trail_section))
        SettingsCard {
            val trailType = FloatingPointerTrailType.fromId(settings.floatingPointerTrailTypeId)
            SettingRadioRow(
                title = stringResource(R.string.floating_pointer_trail_off),
                selected = trailType == FloatingPointerTrailType.OFF,
                onClick = { onTrailTypeChange(FloatingPointerTrailType.OFF) },
            )
            SettingRadioRow(
                title = stringResource(R.string.floating_pointer_trail_simple),
                selected = trailType == FloatingPointerTrailType.SIMPLE,
                onClick = { onTrailTypeChange(FloatingPointerTrailType.SIMPLE) },
            )
            SettingRadioRow(
                title = stringResource(R.string.floating_pointer_trail_high_detail),
                selected = trailType == FloatingPointerTrailType.HIGH_DETAIL,
                onClick = { onTrailTypeChange(FloatingPointerTrailType.HIGH_DETAIL) },
            )
            if (trailType != FloatingPointerTrailType.OFF) {
                SettingsSliderRow(
                    title = stringResource(R.string.floating_pointer_trail_duration),
                    value = settings.floatingPointerTrailDurationMs.toFloat(),
                    valueRange = 50f..500f,
                    steps = 8,
                    enabled = true,
                    label = stringResource(
                        R.string.floating_pointer_trail_duration_value,
                        settings.floatingPointerTrailDurationMs,
                    ),
                    onValueChange = { onTrailDurationChange(it.roundToInt()) },
                )
                AnimationStyleColorRow(
                    title = stringResource(R.string.floating_pointer_trail_color),
                    color = settings.floatingPointerTrailColorArgb,
                    enabled = true,
                    onClick = {
                        pickerInitialColor = settings.floatingPointerTrailColorArgb
                        colorTarget = PointerColorTarget.Trail
                    },
                )
            }
        }

        SettingsSectionTitle(stringResource(R.string.floating_pointer_settings_section_other))
        SettingsCard {
            SettingSwitchRow(
                title = stringResource(R.string.floating_pointer_hide_on_release),
                subtitle = stringResource(R.string.floating_pointer_hide_on_release_desc),
                checked = settings.floatingPointerHideWhenJoystickReleased,
                enabled = true,
                onCheckedChange = onHideWhenReleasedChange,
            )
        }

        SettingLinkRow(
            title = stringResource(R.string.floating_pointer_reset_visual),
            onClick = onResetVisualDefaults,
        )
    }
}
