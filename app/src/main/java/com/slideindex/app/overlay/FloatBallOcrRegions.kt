package com.slideindex.app.overlay

import android.graphics.Rect
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/** Screen-region helpers for float-ball OCR fallback. */
object FloatBallOcrRegions {
    private const val POINT_PICK_HALF_DP = 80f
    private const val MIN_CROP_SIDE_PX = 24

    fun expandPoint(metrics: DisplayMetrics, x: Float, y: Float): Rect {
        val halfPx = (POINT_PICK_HALF_DP * metrics.density).roundToInt()
        val cx = x.roundToInt()
        val cy = y.roundToInt()
        return clampToScreen(
            Rect(cx - halfPx, cy - halfPx, cx + halfPx, cy + halfPx),
            metrics.widthPixels,
            metrics.heightPixels,
        )
    }

    fun clampToScreen(rect: Rect, screenWidth: Int, screenHeight: Int): Rect {
        val left = rect.left.coerceIn(0, screenWidth)
        val top = rect.top.coerceIn(0, screenHeight)
        val right = rect.right.coerceIn(0, screenWidth)
        val bottom = rect.bottom.coerceIn(0, screenHeight)
        val safe = Rect(left, top, right, bottom)
        if (safe.width() < MIN_CROP_SIDE_PX) {
            val pad = (MIN_CROP_SIDE_PX - safe.width()) / 2 + 1
            safe.left = (safe.left - pad).coerceAtLeast(0)
            safe.right = (safe.right + pad).coerceAtMost(screenWidth)
        }
        if (safe.height() < MIN_CROP_SIDE_PX) {
            val pad = (MIN_CROP_SIDE_PX - safe.height()) / 2 + 1
            safe.top = (safe.top - pad).coerceAtLeast(0)
            safe.bottom = (safe.bottom + pad).coerceAtMost(screenHeight)
        }
        return safe
    }
}
