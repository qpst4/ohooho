package com.slideindex.app.overlay

import android.graphics.RectF
import com.slideindex.app.util.RecentAppEntry

internal data class TaskSwitcherRowLayout(
    val entry: RecentAppEntry,
    val rowRect: RectF,
    val closeRect: RectF,
)

internal data class TaskSwitcherPanelLayout(
    val panelRect: RectF,
    val rows: List<TaskSwitcherRowLayout>,
    val closeAllRect: RectF,
)
