@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui.messagestyle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.message.MessageSettings
import com.slideindex.app.ui.SettingsCard
import com.slideindex.app.ui.SettingsSectionTitle
import com.slideindex.app.ui.SettingsSliderRow

@Composable
internal fun FloatIconSettingsSection(
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
        Image(
            painter = painterResource(R.drawable.ic_notification),
            contentDescription = stringResource(R.string.cd_notification_icon),
            modifier = Modifier
                .size((ballSize.coerceAtMost(52.dp) - 4.dp) * 0.66f)
                .clip(CircleShape),
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher),
            contentDescription = stringResource(R.string.cd_app_icon),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size((ballSize.coerceAtMost(52.dp) - 4.dp) * 0.34f)
                .clip(CircleShape),
        )
    }
}
