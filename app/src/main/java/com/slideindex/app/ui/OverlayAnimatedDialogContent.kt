package com.slideindex.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

private const val OVERLAY_ENTER_MS = 240
private const val OVERLAY_EXIT_MS = 200

@Composable
fun OverlayAnimatedDialogContent(
    onDismissComplete: () -> Unit,
    onBackPressed: (() -> Boolean)? = null,
    registerBackHandler: ((() -> Unit) -> Unit)? = null,
    content: @Composable (requestDismiss: () -> Unit) -> Unit,
) {
    var visible by remember { mutableStateOf(false) }
    val requestDismiss = remember {
        { visible = false }
    }
    val handleBack = remember(onBackPressed) {
        {
            if (onBackPressed?.invoke() == true) {
                Unit
            } else {
                visible = false
            }
        }
    }

    SideEffect {
        registerBackHandler?.invoke(handleBack)
    }

    LaunchedEffect(Unit) {
        visible = true
    }

    LaunchedEffect(visible) {
        if (!visible) {
            delay(OVERLAY_EXIT_MS.toLong())
            onDismissComplete()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(OVERLAY_ENTER_MS)) +
                scaleIn(initialScale = 0.92f, animationSpec = tween(OVERLAY_ENTER_MS)),
            exit = fadeOut(tween(OVERLAY_EXIT_MS)) +
                scaleOut(targetScale = 0.92f, animationSpec = tween(OVERLAY_EXIT_MS)),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.45f))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = requestDismiss,
                    ),
                contentAlignment = Alignment.Center,
            ) {
                content(handleBack)
            }
        }
    }
}
