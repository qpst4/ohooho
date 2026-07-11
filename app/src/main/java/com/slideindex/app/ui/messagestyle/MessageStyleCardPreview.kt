@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui.messagestyle

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.message.MessageSettings
import com.slideindex.app.message.MessageStyle
import com.slideindex.app.message.MessageThemeCatalog
import com.slideindex.app.message.MessageThemeSpec
import com.slideindex.app.message.messageThemeBackground
import com.slideindex.app.ui.SettingsCard
import com.slideindex.app.ui.SettingsSectionTitle
import com.slideindex.app.ui.SettingsSliderRow

@Composable
internal fun CardStyleSettingsSection(
    settings: MessageSettings,
    enabled: Boolean,
    onThemeIdChange: (String) -> Unit,
    onOpacityChange: (Float) -> Unit,
    onMaxLinesChange: (Int) -> Unit,
    onAutoDismissSecondsChange: (Int) -> Unit,
) {
    SettingsSectionTitle(stringResource(R.string.message_style_section_card_theme))
    MessageThemeGrid(
        themes = MessageThemeCatalog.themesFor(MessageStyle.DarkCard),
        selectedThemeId = settings.themeId,
        enabled = enabled,
        onThemeSelected = onThemeIdChange,
    )
    PrimaryDisplaySettings(
        settings = settings,
        enabled = enabled,
        maxLines = settings.cardMaxLines,
        opacity = settings.cardOpacity,
        opacityTitleRes = R.string.message_reminder_card_opacity,
        onOpacityChange = onOpacityChange,
        onMaxLinesChange = onMaxLinesChange,
        onAutoDismissSecondsChange = onAutoDismissSecondsChange,
    )
}

@Composable
internal fun PrimaryDisplaySettings(
    settings: MessageSettings,
    enabled: Boolean,
    maxLines: Int,
    opacity: Float,
    opacityTitleRes: Int,
    onOpacityChange: (Float) -> Unit,
    onMaxLinesChange: (Int) -> Unit,
    onAutoDismissSecondsChange: (Int) -> Unit,
    onSideMaxCountChange: ((Int) -> Unit)? = null,
    sideMaxCount: Int = 3,
    onSideMaxWidthDpChange: ((Float) -> Unit)? = null,
    sideMaxWidthDp: Float = 200f,
) {
    SettingsSectionTitle(stringResource(R.string.message_style_section_display))
    SettingsCard {
        SettingsSliderRow(
            title = stringResource(opacityTitleRes),
            value = opacity,
            valueRange = 0.2f..1f,
            steps = 7,
            enabled = enabled,
            label = "${(opacity * 100).toInt()}%",
            formatLabel = { "${(it * 100).toInt()}%" },
            onValueChange = onOpacityChange,
        )
        SettingsSliderRow(
            title = stringResource(R.string.message_style_max_lines),
            value = maxLines.toFloat(),
            valueRange = 1f..3f,
            steps = 1,
            enabled = enabled,
            label = maxLines.toString(),
            formatLabel = { it.toInt().toString() },
            onValueChange = { onMaxLinesChange(it.toInt()) },
        )
        if (onSideMaxCountChange != null) {
            SettingsSliderRow(
                title = stringResource(R.string.message_style_side_count),
                value = sideMaxCount.toFloat(),
                valueRange = 1f..5f,
                steps = 3,
                enabled = enabled,
                label = sideMaxCount.toString(),
                formatLabel = { it.toInt().toString() },
                onValueChange = { onSideMaxCountChange(it.toInt()) },
            )
            if (onSideMaxWidthDpChange != null) {
                SettingsSliderRow(
                    title = stringResource(R.string.message_style_side_width),
                    value = sideMaxWidthDp,
                    valueRange = 120f..320f,
                    steps = 9,
                    enabled = enabled,
                    label = "${sideMaxWidthDp.toInt()} dp",
                    formatLabel = { "${it.toInt()} dp" },
                    onValueChange = onSideMaxWidthDpChange,
                )
            }
        }
        val autoDismissOffLabel = stringResource(R.string.message_reminder_auto_dismiss_off)
        SettingsSliderRow(
            title = stringResource(R.string.message_reminder_auto_dismiss),
            value = settings.autoDismissSeconds.toFloat(),
            valueRange = 0f..30f,
            steps = 29,
            enabled = enabled,
            label = if (settings.autoDismissSeconds <= 0) {
                autoDismissOffLabel
            } else {
                stringResource(R.string.message_reminder_auto_dismiss_seconds, settings.autoDismissSeconds)
            },
            formatLabel = { value ->
                val seconds = value.toInt()
                if (seconds <= 0) autoDismissOffLabel else "$seconds s"
            },
            onValueChange = { onAutoDismissSecondsChange(it.toInt()) },
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun MessageThemeGrid(
    themes: List<MessageThemeSpec>,
    selectedThemeId: String,
    enabled: Boolean,
    onThemeSelected: (String) -> Unit,
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        val normalizedSelectedId = MessageThemeCatalog.normalizeThemeId(selectedThemeId)
        themes.forEach { theme ->
            val selected = theme.id == normalizedSelectedId
            val borderColor = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)
            }
            Column(
                modifier = Modifier
                    .size(width = 108.dp, height = 88.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
                    .clickable(enabled = enabled) { onThemeSelected(theme.id) }
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .then(
                            if (theme.cornerRadiusDp > 0f) {
                                Modifier.clip(RoundedCornerShape(theme.cornerRadiusDp.dp))
                            } else {
                                Modifier
                            },
                        )
                        .messageThemeBackground(theme),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    Text(
                        text = "Aa",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color(theme.titleColorArgb),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
                Text(
                    text = stringResource(theme.labelRes),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                )
            }
        }
    }
}
