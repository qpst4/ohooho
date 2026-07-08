@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.message.MessageSettings
import com.slideindex.app.message.MessageStyle
import com.slideindex.app.message.MessageThemeCatalog
import com.slideindex.app.message.MessageThemeSpec
import com.slideindex.app.message.messageThemeBackground

private val mainStyleOptions = listOf(
    MessageStyle.FloatIcon,
    MessageStyle.DarkCard,
    MessageStyle.SideBubble,
)

@Composable
fun MessageStyleSettingsScreen(
    settings: MessageSettings,
    initialStyle: MessageStyle? = null,
    bottomContentPadding: Dp = 0.dp,
    onBack: () -> Unit,
    onStyleIdChange: (String) -> Unit,
    onThemeIdChange: (String) -> Unit,
    onPrimaryStyleEnabledChange: (Boolean) -> Unit,
    onDanmakuEnabledChange: (Boolean) -> Unit,
    onDanmakuThemeIdChange: (String) -> Unit,
    onFloatIconOpacityChange: (Float) -> Unit,
    onCardOpacityChange: (Float) -> Unit,
    onSideBubbleOpacityChange: (Float) -> Unit,
    onDanmakuOpacityChange: (Float) -> Unit,
    onCardMaxLinesChange: (Int) -> Unit,
    onDanmakuMaxLinesChange: (Int) -> Unit,
    onSideMaxCountChange: (Int) -> Unit,
    onSideMaxWidthDpChange: (Float) -> Unit,
    onSideMaxLinesChange: (Int) -> Unit,
    onFloatIconSizeDpChange: (Float) -> Unit,
    onAutoDismissSecondsChange: (Int) -> Unit,
) {
    var selectedMainStyle by remember(settings.styleId, initialStyle) {
        mutableStateOf(initialStyle ?: settings.style)
    }
    LaunchedEffect(settings.styleId) {
        selectedMainStyle = settings.style
    }

    val controlsEnabled = settings.enabled

    SettingsScreenScaffold(
        title = stringResource(R.string.message_style_title),
        subtitle = stringResource(R.string.message_style_subtitle),
        onBack = onBack,
    ) {
        SettingsSectionTitle(stringResource(R.string.message_style_section_style_select))
        SettingsCard {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = stringResource(R.string.message_style_section_main_style),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    mainStyleOptions.forEach { style ->
                        MessageStyleChip(
                            label = messageStyleLabel(style),
                            selected = selectedMainStyle == style,
                            enabled = controlsEnabled,
                            onClick = { selectMainStyle(style, settings, onStyleIdChange, onThemeIdChange, onPrimaryStyleEnabledChange) {
                                selectedMainStyle = it
                            } },
                            modifier = Modifier.weight(1f),
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.message_style_section_danmaku_toggle),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                MessageStyleChip(
                    label = stringResource(R.string.message_style_danmaku),
                    selected = settings.danmakuEnabled,
                    enabled = controlsEnabled,
                    onClick = { if (controlsEnabled) onDanmakuEnabledChange(!settings.danmakuEnabled) },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

        when (selectedMainStyle) {
            MessageStyle.FloatIcon -> FloatIconSettingsSection(
                settings = settings,
                enabled = controlsEnabled,
                onOpacityChange = onFloatIconOpacityChange,
                onFloatIconSizeDpChange = onFloatIconSizeDpChange,
            )
            MessageStyle.DarkCard -> CardStyleSettingsSection(
                settings = settings,
                enabled = controlsEnabled,
                onThemeIdChange = onThemeIdChange,
                onOpacityChange = onCardOpacityChange,
                onMaxLinesChange = onCardMaxLinesChange,
                onAutoDismissSecondsChange = onAutoDismissSecondsChange,
            )
            MessageStyle.SideBubble -> SideStyleSettingsSection(
                settings = settings,
                enabled = controlsEnabled,
                onThemeIdChange = onThemeIdChange,
                onOpacityChange = onSideBubbleOpacityChange,
                onMaxLinesChange = onSideMaxLinesChange,
                onAutoDismissSecondsChange = onAutoDismissSecondsChange,
                onSideMaxCountChange = onSideMaxCountChange,
                onSideMaxWidthDpChange = onSideMaxWidthDpChange,
            )
            MessageStyle.Danmaku -> Unit
        }

        SettingsSectionTitle(stringResource(R.string.message_reminder_danmaku_theme))
        SettingsHintText(
            stringResource(
                R.string.message_style_danmaku_with_primary,
                messageStyleLabel(selectedMainStyle),
            ),
        )
        if (settings.danmakuEnabled) {
            MessageThemeGrid(
                themes = MessageThemeCatalog.themesFor(MessageStyle.Danmaku),
                selectedThemeId = settings.danmakuThemeId,
                enabled = controlsEnabled,
                onThemeSelected = onDanmakuThemeIdChange,
            )
            SettingsCard {
                SettingsSliderRow(
                    title = stringResource(R.string.message_reminder_danmaku_opacity),
                    value = settings.danmakuOpacity,
                    valueRange = 0.2f..1f,
                    steps = 7,
                    enabled = controlsEnabled,
                    label = "${(settings.danmakuOpacity * 100).toInt()}%",
                    formatLabel = { "${(it * 100).toInt()}%" },
                    onValueChange = onDanmakuOpacityChange,
                )
                SettingsSliderRow(
                    title = stringResource(R.string.message_style_max_lines),
                    value = settings.danmakuMaxLines.toFloat(),
                    valueRange = 1f..3f,
                    steps = 1,
                    enabled = controlsEnabled,
                    label = settings.danmakuMaxLines.toString(),
                    formatLabel = { it.toInt().toString() },
                    onValueChange = { onDanmakuMaxLinesChange(it.toInt()) },
                )
            }
        } else {
            SettingsHintText(stringResource(R.string.message_style_danmaku_disabled_hint))
        }

        Spacer(modifier = Modifier.height(8.dp + bottomContentPadding))
    }
}

private fun selectMainStyle(
    style: MessageStyle,
    settings: MessageSettings,
    onStyleIdChange: (String) -> Unit,
    onThemeIdChange: (String) -> Unit,
    onPrimaryStyleEnabledChange: (Boolean) -> Unit,
    onSelected: (MessageStyle) -> Unit,
) {
    onSelected(style)
    onStyleIdChange(style.id)
    if (style != MessageStyle.FloatIcon) {
        onPrimaryStyleEnabledChange(true)
    }
    if (style in setOf(MessageStyle.DarkCard, MessageStyle.SideBubble)) {
        val themes = MessageThemeCatalog.themesFor(style)
        if (settings.themeId !in themes.map { it.id }) {
            onThemeIdChange(MessageThemeCatalog.defaultThemeIdFor(style))
        }
    }
}

@Composable
private fun MessageStyleChip(
    label: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surfaceContainerHighest
    }
    val contentColor = if (selected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurface
    }
    Surface(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(999.dp),
        color = backgroundColor,
        contentColor = contentColor,
        modifier = modifier,
    ) {
        Text(
            text = label,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            style = MaterialTheme.typography.labelLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        )
    }
}

@Composable
private fun FloatIconSettingsSection(
    settings: MessageSettings,
    enabled: Boolean,
    onOpacityChange: (Float) -> Unit,
    onFloatIconSizeDpChange: (Float) -> Unit,
) {
    var previewPlaying by remember { mutableIntStateOf(0) }
    var previewVisible by remember { mutableStateOf(true) }
    LaunchedEffect(previewPlaying) {
        if (previewPlaying <= 0) return@LaunchedEffect
        previewVisible = false
        kotlinx.coroutines.delay(80)
        previewVisible = true
    }

    SettingsSectionTitle(stringResource(R.string.message_style_section_float_settings))
    SettingsCard {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.message_style_float_icon),
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                FloatIconPreviewBall(
                    sizeDp = settings.floatIconSizeDp,
                    opacity = settings.floatIconOpacity,
                    animateIn = previewVisible,
                )
                IconButton(
                    onClick = { if (enabled) previewPlaying++ },
                    enabled = enabled,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = stringResource(R.string.message_style_float_icon_preview),
                        tint = Color.White,
                        modifier = Modifier.size(20.dp),
                    )
                }
            }
        }
        SettingsSliderRow(
            title = stringResource(R.string.message_style_float_icon_size),
            value = settings.floatIconSizeDp,
            valueRange = 32f..64f,
            steps = 31,
            enabled = enabled,
            label = "${settings.floatIconSizeDp.toInt()} dp",
            formatLabel = { "${it.toInt()} dp" },
            onValueChange = onFloatIconSizeDpChange,
        )
        SettingsSliderRow(
            title = stringResource(R.string.message_style_float_icon_opacity),
            value = settings.floatIconOpacity,
            valueRange = 0f..1f,
            steps = 19,
            enabled = enabled,
            label = "${(settings.floatIconOpacity * 100).toInt()}%",
            formatLabel = { "${(it * 100).toInt()}%" },
            onValueChange = onOpacityChange,
        )
    }
}

@Composable
private fun FloatIconPreviewBall(
    sizeDp: Float,
    opacity: Float,
    animateIn: Boolean,
) {
    val presence by animateFloatAsState(
        targetValue = if (animateIn) 1f else 0.4f,
        animationSpec = tween(280, easing = FastOutSlowInEasing),
        label = "floatIconPreviewPresence",
    )
    val scale by animateFloatAsState(
        targetValue = if (animateIn) 1f else 0.65f,
        animationSpec = tween(280, easing = FastOutSlowInEasing),
        label = "floatIconPreviewScale",
    )
    val ballSize = sizeDp.coerceIn(32f, 64f).dp

    Box(
        modifier = Modifier
            .size(ballSize.coerceAtMost(52.dp))
            .alpha(presence * opacity.coerceIn(0f, 1f))
            .scale(scale)
            .shadow(4.dp, CircleShape)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.95f))
            .padding(2.dp),
        contentAlignment = Alignment.Center,
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.ic_notification),
            contentDescription = null,
            modifier = Modifier
                .size((ballSize.coerceAtMost(52.dp) - 4.dp) * 0.66f)
                .clip(CircleShape),
        )
        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.ic_launcher),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size((ballSize.coerceAtMost(52.dp) - 4.dp) * 0.34f)
                .clip(CircleShape),
        )
    }
}

@Composable
private fun CardStyleSettingsSection(
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
private fun SideStyleSettingsSection(
    settings: MessageSettings,
    enabled: Boolean,
    onThemeIdChange: (String) -> Unit,
    onOpacityChange: (Float) -> Unit,
    onMaxLinesChange: (Int) -> Unit,
    onAutoDismissSecondsChange: (Int) -> Unit,
    onSideMaxCountChange: (Int) -> Unit,
    onSideMaxWidthDpChange: (Float) -> Unit,
) {
    SettingsSectionTitle(stringResource(R.string.message_style_section_side_theme))
    MessageThemeGrid(
        themes = MessageThemeCatalog.themesFor(MessageStyle.SideBubble),
        selectedThemeId = settings.themeId,
        enabled = enabled,
        onThemeSelected = onThemeIdChange,
    )
    PrimaryDisplaySettings(
        settings = settings,
        enabled = enabled,
        maxLines = settings.sideMaxLines,
        opacity = settings.sideBubbleOpacity,
        opacityTitleRes = R.string.message_reminder_side_opacity,
        onOpacityChange = onOpacityChange,
        onMaxLinesChange = onMaxLinesChange,
        onAutoDismissSecondsChange = onAutoDismissSecondsChange,
        onSideMaxCountChange = onSideMaxCountChange,
        sideMaxCount = settings.sideMaxCount,
        onSideMaxWidthDpChange = onSideMaxWidthDpChange,
        sideMaxWidthDp = settings.sideMaxWidthDp,
    )
}

@Composable
private fun PrimaryDisplaySettings(
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
private fun MessageThemeGrid(
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

@Composable
fun messageStyleLabel(style: MessageStyle): String = when (style) {
    MessageStyle.FloatIcon -> stringResource(R.string.message_style_float_icon)
    MessageStyle.DarkCard -> stringResource(R.string.message_style_dark_card)
    MessageStyle.SideBubble -> stringResource(R.string.message_style_side_bubble)
    MessageStyle.Danmaku -> stringResource(R.string.message_style_danmaku)
}

@Composable
fun messageThemeLabel(themeId: String): String {
    val theme = MessageThemeCatalog.findTheme(themeId)
    return if (theme != null) {
        stringResource(theme.labelRes)
    } else {
        themeId
    }
}

@Composable
fun messageStyleSummary(settings: MessageSettings): String {
    val parts = mutableListOf<String>()
    if (settings.style == MessageStyle.FloatIcon) {
        parts += messageStyleLabel(MessageStyle.FloatIcon)
    } else if (settings.primaryStyleEnabled) {
        parts += messageStyleLabel(settings.style)
    }
    if (settings.danmakuEnabled) {
        parts += stringResource(R.string.message_style_danmaku)
    }
    return if (parts.isEmpty()) {
        stringResource(R.string.message_reminder_entry_disabled)
    } else {
        parts.joinToString(" + ")
    }
}

@Composable
fun MessageStyleEntryCard(
    settings: MessageSettings,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    SettingNavigationRow(
        icon = { Icon(Icons.Default.CropSquare, contentDescription = null) },
        title = stringResource(R.string.message_style_title),
        subtitle = messageStyleSummary(settings),
        enabled = enabled,
        onClick = onClick,
    )
}
