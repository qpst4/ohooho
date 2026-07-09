package com.slideindex.app.settings

import com.slideindex.app.overlay.PanelSide

object FloatingPointerDesignIds {
    const val RING = "ring"
}

fun AppSettings.edgeTriggerWidthDp(side: PanelSide): Float = when (side) {
    PanelSide.LEFT -> leftEdgeTriggerWidthDp
    PanelSide.RIGHT -> rightEdgeTriggerWidthDp
}

fun AppSettings.triggerTopFraction(side: PanelSide): Float =
    primaryTriggerHandle(side).topFraction

fun AppSettings.triggerHeightFraction(side: PanelSide): Float =
    primaryTriggerHandle(side).heightFraction

fun AppSettings.triggerBottomFraction(side: PanelSide): Float =
    primaryTriggerHandle(side).bottomFraction

fun AppSettings.interceptWindowWidthDp(side: PanelSide): Float {
    if (!interceptSystemBackGesture) return edgeTriggerWidthDp(side)
    val triggerWidth = edgeTriggerWidthDp(side)
    val interceptWidth = if (limitMaxInterceptLength) 200f else 320f
    return maxOf(triggerWidth, interceptWidth)
}
