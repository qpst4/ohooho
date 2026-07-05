package com.slideindex.app.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private const val SCRIM_ENTER_MS = 260
private const val SCRIM_EXIT_MS = 200
private const val SHEET_ENTER_MS = 300
private const val SHEET_EXIT_MS = 220
private const val SCRIM_TARGET_ALPHA = 0.45f
private const val SHEET_ENTER_OFFSET_DP = 10f

@Composable
fun OverlayAnimatedDialogContent(
    onDismissComplete: () -> Unit,
    onBackPressed: (() -> Boolean)? = null,
    onWindowReady: (() -> Unit)? = null,
    registerBackHandler: ((() -> Unit) -> Unit)? = null,
    content: @Composable (requestDismiss: () -> Unit) -> Unit,
) {
    var revealed by remember { mutableStateOf(false) }
    var dismissing by remember { mutableStateOf(false) }
    val scrimAlpha = remember { Animatable(0f) }
    val sheetAlpha = remember { Animatable(0f) }
    val sheetOffsetPx = remember { Animatable(0f) }
    val density = LocalDensity.current
    val sheetEnterOffsetPx = with(density) { SHEET_ENTER_OFFSET_DP.dp.toPx() }

    val requestDismiss = remember {
        { dismissing = true }
    }
    val handleBack = remember(onBackPressed) {
        {
            if (onBackPressed?.invoke() == true) {
                Unit
            } else {
                dismissing = true
            }
        }
    }

    SideEffect {
        registerBackHandler?.invoke(handleBack)
    }

    val view = LocalView.current
    LaunchedEffect(view) {
        awaitFrame()
        onWindowReady?.invoke()
        scrimAlpha.snapTo(SCRIM_TARGET_ALPHA)
        revealed = true
    }

    LaunchedEffect(revealed) {
        if (!revealed) return@LaunchedEffect
        sheetOffsetPx.snapTo(sheetEnterOffsetPx)
        launch {
            sheetAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(SHEET_ENTER_MS, easing = LinearOutSlowInEasing),
            )
        }
        sheetOffsetPx.animateTo(
            targetValue = 0f,
            animationSpec = tween(SHEET_ENTER_MS, easing = LinearOutSlowInEasing),
        )
    }

    LaunchedEffect(dismissing) {
        if (!dismissing) return@LaunchedEffect
        coroutineScope {
            launch {
                sheetAlpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(SHEET_EXIT_MS, easing = FastOutLinearInEasing),
                )
            }
            launch {
                sheetOffsetPx.animateTo(
                    targetValue = sheetEnterOffsetPx / 2f,
                    animationSpec = tween(SHEET_EXIT_MS, easing = FastOutLinearInEasing),
                )
            }
            launch {
                scrimAlpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(SCRIM_EXIT_MS, easing = FastOutLinearInEasing),
                )
            }
        }
        onDismissComplete()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (scrimAlpha.value > 0f || revealed) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = scrimAlpha.value))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        enabled = revealed && !dismissing,
                        onClick = requestDismiss,
                    ),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = sheetAlpha.value
                    translationY = sheetOffsetPx.value
                },
            contentAlignment = Alignment.Center,
        ) {
            if (revealed || dismissing) {
                content(handleBack)
            }
        }
    }
}
