package com.slideindex.app.overlay.layout

import android.graphics.RectF
import com.slideindex.app.overlay.PanelSide

/** Minimal host surface for anchored overlay panel geometry. */
interface OverlayPanelLayoutHost {
    fun side(): PanelSide
    fun activeTriggerZoneRect(): RectF
    fun viewWidth(): Int
    fun viewHeight(): Int
    fun dp(value: Float): Float
}
