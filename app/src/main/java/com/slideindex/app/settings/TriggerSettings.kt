package com.slideindex.app.settings

import com.slideindex.app.overlay.PanelSide

fun AppSettings.edgeTriggerWidthDp(side: PanelSide): Float = when (side) {
    PanelSide.LEFT -> leftEdgeTriggerWidthDp
    PanelSide.RIGHT -> rightEdgeTriggerWidthDp
}

fun AppSettings.triggerTopFraction(side: PanelSide): Float = when (side) {
    PanelSide.LEFT -> leftTriggerTopFraction
    PanelSide.RIGHT -> rightTriggerTopFraction
}

fun AppSettings.triggerHeightFraction(side: PanelSide): Float = when (side) {
    PanelSide.LEFT -> leftTriggerHeightFraction
    PanelSide.RIGHT -> rightTriggerHeightFraction
}

fun AppSettings.triggerBottomFraction(side: PanelSide): Float =
    triggerTopFraction(side) + triggerHeightFraction(side)

fun AppSettings.interceptWindowWidthDp(side: PanelSide): Float {
    if (!interceptSystemBackGesture) return edgeTriggerWidthDp(side)
    val triggerWidth = edgeTriggerWidthDp(side)
    val interceptWidth = if (limitMaxInterceptLength) 200f else 320f
    return maxOf(triggerWidth, interceptWidth)
}
