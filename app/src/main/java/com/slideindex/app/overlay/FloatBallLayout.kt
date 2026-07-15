package com.slideindex.app.overlay

import android.graphics.Rect
import android.util.DisplayMetrics
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatBallPositionMode
import com.slideindex.app.settings.FloatBallSide
import kotlin.math.max
import kotlin.math.roundToInt

internal object FloatBallLayout {
    private const val EDGE_MARGIN_DP = 8f
    private const val LINE_VISUAL_WIDTH_DP = 4f
    private const val MIN_CAPTURE_WIDTH_DP = 24f
    private const val MIN_STRIP_HEIGHT_DP = 48f

    fun resolvedActiveSide(settings: AppSettings): FloatBallSide =
        when (settings.floatBallPositionMode) {
            FloatBallPositionMode.LEFT -> FloatBallSide.LEFT
            FloatBallPositionMode.RIGHT -> FloatBallSide.RIGHT
            FloatBallPositionMode.BOTH_EDGES -> settings.floatBallActiveSide
            FloatBallPositionMode.CUSTOM -> {
                if (settings.floatBallPositionXFraction < 0.5f) FloatBallSide.LEFT else FloatBallSide.RIGHT
            }
        }

    fun shouldShowLine(settings: AppSettings): Boolean =
        settings.floatBallPositionMode == FloatBallPositionMode.BOTH_EDGES

    fun dockCenterY(settings: AppSettings, screenHeight: Int): Float =
        settings.floatBallPositionYFraction.coerceIn(0.05f, 0.95f) * screenHeight

    fun ballSizePx(settings: AppSettings, density: Float): Int =
        (settings.floatBallSizeDp.coerceIn(36f, 72f) * density).roundToInt()

    fun marginPx(density: Float): Int = (EDGE_MARGIN_DP * density).roundToInt()

    fun stripWidthPx(settings: AppSettings, screenWidth: Int, density: Float): Int {
        val fractionWidth = (screenWidth * settings.floatBallLineWidthFraction.coerceIn(0.04f, 0.5f)).roundToInt()
        val minWidth = (MIN_CAPTURE_WIDTH_DP * density).roundToInt()
        return max(fractionWidth, minWidth)
    }

    fun lineVisualWidthPx(density: Float): Int =
        max((LINE_VISUAL_WIDTH_DP * density).roundToInt(), 1)

    fun stripHeightPx(settings: AppSettings, screenHeight: Int, density: Float, ballSizePx: Int): Int {
        val fractionHeight = (screenHeight * settings.floatBallLineHeightFraction.coerceIn(0.04f, 0.4f)).roundToInt()
        val minHeight = max((MIN_STRIP_HEIGHT_DP * density).roundToInt(), ballSizePx)
        return max(fractionHeight, minHeight)
    }

    fun ballTopLeft(settings: AppSettings, metrics: DisplayMetrics, activeSide: FloatBallSide): Pair<Int, Int> {
        val density = metrics.density
        val ballSizePx = ballSizePx(settings, density)
        val marginPx = marginPx(density)
        val centerY = dockCenterY(settings, metrics.heightPixels)
        val left = when (settings.floatBallPositionMode) {
            FloatBallPositionMode.CUSTOM -> {
                val centerX = settings.floatBallPositionXFraction.coerceIn(0.05f, 0.95f) * metrics.widthPixels
                (centerX - ballSizePx / 2f).roundToInt()
                    .coerceIn(marginPx, metrics.widthPixels - ballSizePx - marginPx)
            }
            else -> when (activeSide) {
                FloatBallSide.LEFT -> 0
                FloatBallSide.RIGHT -> metrics.widthPixels - ballSizePx
            }
        }
        val top = (centerY - ballSizePx / 2f).roundToInt()
            .coerceIn(marginPx, metrics.heightPixels - ballSizePx - marginPx)
        return left to top
    }

    fun edgeStripBounds(
        settings: AppSettings,
        metrics: DisplayMetrics,
        side: FloatBallSide,
    ): Rect {
        val density = metrics.density
        val ballSizePx = ballSizePx(settings, density)
        val width = stripWidthPx(settings, metrics.widthPixels, density)
        val height = stripHeightPx(settings, metrics.heightPixels, density, ballSizePx)
        val centerY = dockCenterY(settings, metrics.heightPixels).roundToInt()
        val top = (centerY - height / 2).coerceIn(0, metrics.heightPixels - height)
        val left = when (side) {
            FloatBallSide.LEFT -> 0
            FloatBallSide.RIGHT -> metrics.widthPixels - width
        }
        return Rect(left, top, left + width, top + height)
    }

    fun dockXFraction(settings: AppSettings, activeSide: FloatBallSide): Float =
        when (settings.floatBallPositionMode) {
            FloatBallPositionMode.CUSTOM -> settings.floatBallPositionXFraction
            FloatBallPositionMode.LEFT -> 0.08f
            FloatBallPositionMode.RIGHT -> 0.92f
            FloatBallPositionMode.BOTH_EDGES -> when (activeSide) {
                FloatBallSide.LEFT -> 0.08f
                FloatBallSide.RIGHT -> 0.92f
            }
        }
}
