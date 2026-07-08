package com.slideindex.app.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.settings.AppSettings
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OtpAutoInputSettingsScreen(
    settings: AppSettings,
    accessibilityGranted: Boolean,
    onBack: (() -> Unit)?,
    onRequestAccessibility: () -> Unit,
    onAccessibilityAssistChange: (Boolean) -> Unit,
    onAutoInputChange: (Boolean) -> Unit,
    onAutoConfirmChange: (Boolean) -> Unit,
    onDelayChange: (Int) -> Unit,
    onIntervalChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    SettingsScreenScaffold(
        title = stringResource(R.string.otp_auto_input_title),
        subtitle = stringResource(R.string.otp_auto_input_desc),
        onBack = onBack,
        embedded = onBack == null,
        modifier = modifier,
    ) {
        if (onBack == null) {
            SettingsHintText(stringResource(R.string.otp_hub_extensions_hint))
        }
        val context = LocalContext.current
        val formatDelayLabel = remember(context) {
            { value: Float ->
                if (value.roundToInt() <= 0) {
                    context.getString(R.string.otp_auto_input_delay_zero)
                } else {
                    context.getString(R.string.otp_auto_input_delay_value, value.roundToInt())
                }
            }
        }
        val formatIntervalLabel = remember(context) {
            { value: Float ->
                context.getString(R.string.otp_auto_input_interval_value, value.roundToInt())
            }
        }

        SettingsCard {
            SettingSwitchRow(
                title = stringResource(R.string.otp_accessibility_status_title),
                subtitle = if (accessibilityGranted) {
                    stringResource(R.string.otp_accessibility_status_enabled)
                } else {
                    stringResource(R.string.otp_accessibility_status_disabled)
                },
                icon = { Icon(Icons.Default.TouchApp, contentDescription = null) },
                checked = accessibilityGranted,
                enabled = true,
                onCheckedChange = { if (!accessibilityGranted) onRequestAccessibility() },
            )
            SettingSwitchRow(
                title = stringResource(R.string.otp_accessibility_assist_title),
                subtitle = stringResource(R.string.otp_accessibility_assist_desc),
                checked = settings.otpAccessibilityAssistEnabled,
                enabled = accessibilityGranted,
                onCheckedChange = onAccessibilityAssistChange,
            )
            SettingSwitchRow(
                title = stringResource(R.string.otp_auto_input_enabled_title),
                subtitle = stringResource(R.string.otp_auto_input_enabled_desc),
                icon = { Icon(Icons.Default.Keyboard, contentDescription = null) },
                checked = settings.otpAutoInputEnabled,
                enabled = accessibilityGranted,
                onCheckedChange = { enabled ->
                    if (!accessibilityGranted) {
                        onRequestAccessibility()
                    } else {
                        onAutoInputChange(enabled)
                    }
                },
            )
            SettingSwitchRow(
                title = stringResource(R.string.otp_auto_confirm_title),
                subtitle = stringResource(R.string.otp_auto_confirm_desc),
                checked = settings.otpAutoConfirmEnabled,
                enabled = accessibilityGranted && settings.otpAutoInputEnabled,
                onCheckedChange = onAutoConfirmChange,
            )
        }

        SettingsSectionTitle(stringResource(R.string.otp_auto_input_timing_section))
        SettingsCard {
            SettingsSliderRow(
                title = stringResource(R.string.otp_auto_input_delay_title),
                value = settings.otpAutoInputDelayMs.toFloat(),
                valueRange = 0f..3000f,
                steps = 29,
                enabled = accessibilityGranted && settings.otpAutoInputEnabled,
                label = formatDelayLabel(settings.otpAutoInputDelayMs.toFloat()),
                formatLabel = formatDelayLabel,
                snapValue = { value -> (value / 100f).roundToInt() * 100f },
                onValueChange = { value ->
                    onDelayChange(((value / 100f).roundToInt() * 100).coerceIn(0, 3000))
                },
            )
            SettingsSliderRow(
                title = stringResource(R.string.otp_auto_input_interval_title),
                value = settings.otpAutoInputIntervalMs.toFloat(),
                valueRange = 0f..500f,
                steps = 24,
                enabled = accessibilityGranted && settings.otpAutoInputEnabled,
                label = formatIntervalLabel(settings.otpAutoInputIntervalMs.toFloat()),
                formatLabel = formatIntervalLabel,
                snapValue = { value -> (value / 20f).roundToInt() * 20f },
                onValueChange = { value ->
                    onIntervalChange(((value / 20f).roundToInt() * 20).coerceIn(0, 500))
                },
            )
        }
    }
}
