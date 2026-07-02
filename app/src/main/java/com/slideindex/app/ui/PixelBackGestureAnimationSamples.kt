package com.slideindex.app.ui

import android.graphics.Color as AndroidColor
import android.view.Gravity
import android.widget.FrameLayout
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.changedToUpIgnoreConsumed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.overlay.PixelBackGestureAnimationState
import com.slideindex.app.overlay.PixelBackGestureAnimationView
import kotlin.math.max

/**
 * Copyable integration samples for [PixelBackGestureAnimationView].
 *
 * These helpers are intentionally not wired into the app's current gesture flow.
 */
object PixelBackGestureAnimationSamples {
    fun attachViewToFrameLayout(
        root: FrameLayout,
        side: PanelSide,
        containerColor: Int = 0xE61E1B2E.toInt(),
        arrowColor: Int = AndroidColor.WHITE,
        onBackTriggered: () -> Unit,
    ): PixelBackGestureAnimationView {
        val view = PixelBackGestureAnimationView(root.context).apply {
            this.side = side
            setColors(containerColor = containerColor, arrowColor = arrowColor)
            this.onBackTriggered = onBackTriggered
        }
        root.addView(
            view,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT,
            ).apply {
                gravity = Gravity.FILL
            },
        )
        return view
    }
}

@Composable
fun PixelBackGestureAnimationPointerInputSample(
    side: PanelSide,
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xE61E1B2E),
    arrowColor: Color = Color.White,
    edgeTouchWidthDp: Float = 32f,
    onBackTriggered: () -> Unit,
    content: @Composable BoxScope.() -> Unit = {},
) {
    val density = LocalDensity.current
    val state = remember { PixelBackGestureAnimationState(density.density) }
    val edgeTouchWidthPx = with(density) { edgeTouchWidthDp.dp.toPx() }
    var tracking by remember { mutableStateOf(false) }
    var animating by remember { mutableStateOf(false) }
    var redrawTick by remember { mutableIntStateOf(0) }

    fun requestAnimation() {
        animating = true
        redrawTick++
    }

    LaunchedEffect(density.density) {
        state.updateMetrics(PixelBackGestureAnimationState.defaultMetrics(density.density))
    }

    LaunchedEffect(animating) {
        if (!animating) return@LaunchedEffect
        var lastFrameNanos = 0L
        while (animating) {
            withFrameNanos { now ->
                val dt = if (lastFrameNanos == 0L) {
                    1f / 60f
                } else {
                    ((now - lastFrameNanos) / 1_000_000_000f).coerceIn(0.001f, 0.032f)
                }
                lastFrameNanos = now
                animating = state.step(dt) || tracking
                redrawTick++
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(side, edgeTouchWidthPx) {
                awaitPointerEventScope {
                    while (true) {
                        val downEvent = awaitPointerEvent()
                        val down = downEvent.changes.firstOrNull { it.pressed } ?: continue
                        val viewWidth = size.width.toFloat()
                        val startsAtEdge = when (side) {
                            PanelSide.LEFT -> down.position.x <= edgeTouchWidthPx
                            PanelSide.RIGHT -> down.position.x >= viewWidth - edgeTouchWidthPx
                        }
                        if (!startsAtEdge) continue

                        tracking = true
                        state.start(centerY = down.position.y)
                        state.drag(
                            centerY = down.position.y,
                            inwardPx = inwardDistance(side, viewWidth, down.position.x),
                        )
                        down.consume()
                        requestAnimation()

                        var finished = false
                        while (!finished) {
                            val event = awaitPointerEvent()
                            val change = event.changes.firstOrNull { it.id == down.id }
                                ?: event.changes.firstOrNull()
                                ?: continue

                            if (change.changedToUpIgnoreConsumed()) {
                                tracking = false
                                if (state.isTriggerReady()) {
                                    onBackTriggered()
                                    state.release()
                                } else {
                                    state.cancel()
                                }
                                requestAnimation()
                                finished = true
                            } else if (change.pressed || change.positionChange() != Offset.Zero) {
                                state.drag(
                                    centerY = change.position.y,
                                    inwardPx = inwardDistance(side, viewWidth, change.position.x),
                                )
                                change.consume()
                                requestAnimation()
                            }
                        }
                    }
                }
            },
    ) {
        content()
        PixelBackGestureAnimationCanvas(
            state = state,
            side = side,
            containerColor = containerColor,
            arrowColor = arrowColor,
            redrawTick = redrawTick,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun PixelBackGestureAnimationCanvas(
    state: PixelBackGestureAnimationState,
    side: PanelSide,
    containerColor: Color,
    arrowColor: Color,
    redrawTick: Int,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier) {
        @Suppress("UNUSED_VARIABLE")
        val tick = redrawTick
        val snapshot = state.snapshot()
        if (!snapshot.isVisible) return@Canvas

        val metrics = state.metrics
        val halfHeight = metrics.heightPx / 2f
        val centerY = snapshot.centerY.coerceIn(halfHeight, size.height - halfHeight)
        val visibleWidth = snapshot.widthPx.coerceAtLeast(0f)
        val topLeft = when (side) {
            PanelSide.LEFT -> Offset(-halfHeight, centerY - halfHeight)
            PanelSide.RIGHT -> Offset(size.width - visibleWidth, centerY - halfHeight)
        }
        val rectWidth = visibleWidth + halfHeight
        drawRoundRect(
            color = containerColor.copy(alpha = containerColor.alpha * snapshot.alpha),
            topLeft = topLeft,
            size = Size(rectWidth, metrics.heightPx),
            cornerRadius = CornerRadius(halfHeight, halfHeight),
        )

        val sign = if (side == PanelSide.LEFT) 1f else -1f
        val arrowX = when (side) {
            PanelSide.LEFT -> snapshot.arrowCenterOffsetPx
            PanelSide.RIGHT -> size.width - snapshot.arrowCenterOffsetPx
        } + sign * snapshot.arrowReleaseOffsetPx
        drawComposeArrow(
            center = Offset(arrowX, centerY),
            size = metrics.heightPx * 0.34f,
            pointsLeft = side == PanelSide.LEFT,
            color = arrowColor.copy(alpha = arrowColor.alpha * snapshot.alpha),
        )
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawComposeArrow(
    center: Offset,
    size: Float,
    pointsLeft: Boolean,
    color: Color,
) {
    val direction = if (pointsLeft) -1f else 1f
    val half = size / 2f
    val tipX = center.x + direction * half
    val tailX = center.x - direction * half * 0.55f
    val path = Path().apply {
        moveTo(tailX, center.y - half)
        lineTo(tipX, center.y)
        lineTo(tailX, center.y + half)
    }
    drawPath(
        path = path,
        color = color,
        style = Stroke(
            width = max(size * 0.22f, 1.5f),
            cap = StrokeCap.Round,
            join = StrokeJoin.Round,
        ),
    )
}

private fun inwardDistance(side: PanelSide, viewWidth: Float, x: Float): Float {
    return when (side) {
        PanelSide.LEFT -> x
        PanelSide.RIGHT -> viewWidth - x
    }.coerceAtLeast(0f)
}
