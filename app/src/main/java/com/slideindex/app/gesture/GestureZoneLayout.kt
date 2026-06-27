package com.slideindex.app.gesture

import android.graphics.RectF
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.edgeTriggerWidthDp
import com.slideindex.app.settings.interceptWindowWidthDp
import com.slideindex.app.settings.triggerHeightFraction
import com.slideindex.app.settings.triggerTopFraction
import com.slideindex.app.util.coerceSafe

class GestureZoneLayout(
    private val side: PanelSide,
    private var settings: AppSettings = AppSettings(),
    private var viewWidth: Int = 0,
    private var viewHeight: Int = 0,
    private var density: Float = 1f,
    private var sessionActive: Boolean = false,
    private var previewMode: Boolean = false,
) {
    fun update(
        settings: AppSettings,
        viewWidth: Int,
        viewHeight: Int,
        density: Float,
        sessionActive: Boolean,
        previewMode: Boolean,
    ) {
        this.settings = settings
        this.viewWidth = viewWidth
        this.viewHeight = viewHeight
        this.density = density
        this.sessionActive = sessionActive
        this.previewMode = previewMode
    }

    fun triggerZoneRect(): RectF {
        if (!sessionActive && !previewMode && viewWidth > 0 && viewHeight > 0) {
            return RectF(0f, 0f, viewWidth.toFloat(), viewHeight.toFloat())
        }
        val top = viewHeight * settings.triggerTopFraction(side)
        val zoneHeight = viewHeight * settings.triggerHeightFraction(side)
        val w = edgeWidthPx().toFloat()
        return when (side) {
            PanelSide.LEFT -> RectF(0f, top, w, top + zoneHeight)
            PanelSide.RIGHT -> RectF(viewWidth - w, top, viewWidth.toFloat(), top + zoneHeight)
        }
    }

    fun indexRailRect(): RectF {
        if (viewWidth <= 0 || viewHeight <= 0) return RectF()
        val w = railVisualWidth().coerceAtMost(edgeWidthPx().toFloat())
        val indexH = viewHeight * settings.indexHeightFraction
        val trigger = triggerZoneRect()
        var top = trigger.centerY() - indexH / 2f
        top = top.coerceSafe(dp(8f), viewHeight - indexH - dp(8f))
        return when (side) {
            PanelSide.LEFT -> RectF(0f, top, w, top + indexH)
            PanelSide.RIGHT -> RectF(viewWidth - w, top, viewWidth.toFloat(), top + indexH)
        }
    }

    fun edgeWidthPx(): Int {
        return (settings.edgeTriggerWidthDp(side) * density)
            .toInt()
            .coerceAtLeast(dp(16f).toInt())
    }

    fun interceptZoneRect(): RectF {
        if (!settings.interceptSystemBackGesture) return triggerZoneRect()
        val trigger = triggerZoneRect()
        val interceptWidth = settings.interceptWindowWidthDp(side) * density
        return when (side) {
            PanelSide.LEFT -> RectF(0f, trigger.top, interceptWidth, trigger.bottom)
            PanelSide.RIGHT -> RectF(viewWidth - interceptWidth, trigger.top, viewWidth.toFloat(), trigger.bottom)
        }
    }

    fun containsInterceptZone(localX: Float, localY: Float): Boolean =
        interceptZoneRect().contains(localX, localY)

    fun railVisualWidth(): Float = dp(22f)

    fun containsTrigger(localX: Float, localY: Float): Boolean =
        triggerZoneRect().contains(localX, localY)

    fun isInRailZone(localX: Float): Boolean {
        val rail = indexRailRect()
        return when (side) {
            PanelSide.LEFT -> localX <= rail.right + dp(10f)
            PanelSide.RIGHT -> localX >= rail.left - dp(10f)
        }
    }

    private fun dp(value: Float): Float = value * density
}
