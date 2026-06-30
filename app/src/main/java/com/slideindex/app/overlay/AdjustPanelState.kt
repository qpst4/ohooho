package com.slideindex.app.overlay

import com.slideindex.app.util.ContinuousAdjustController

data class AdjustPanelState(
    val mode: ContinuousAdjustController.Mode,
    var fraction: Float,
    var anchorRawY: Float,
    var dragging: Boolean = false,
    var volumeExpanded: Boolean = false,
    var ringFraction: Float = 0f,
    var notificationFraction: Float = 0f,
    var ringerMode: Int = android.media.AudioManager.RINGER_MODE_NORMAL,
    var dragTarget: VolumeDragTarget? = null,
) {
    fun isDraggingVolume(): Boolean = dragTarget != null
}
