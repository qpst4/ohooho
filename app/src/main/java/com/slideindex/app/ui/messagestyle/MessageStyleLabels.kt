package com.slideindex.app.ui.messagestyle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.message.MessageSettings
import com.slideindex.app.message.MessageStyle
import com.slideindex.app.message.MessageThemeCatalog
import com.slideindex.app.ui.SettingNavigationRow

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
        icon = { label -> Icon(Icons.Default.CropSquare, contentDescription = label) },
        title = stringResource(R.string.message_style_title),
        subtitle = messageStyleSummary(settings),
        enabled = enabled,
        onClick = onClick,
    )
}
