package com.slideindex.app.overlay

import android.content.Intent
import android.graphics.RectF

enum class TaskSwitcherMenuItemType {
    SHORTCUT,
    FREE_WINDOW,
    APP_INFO,
    FORCE_STOP,
}

data class TaskSwitcherMenuItem(
    val label: String,
    val type: TaskSwitcherMenuItemType,
    val shortcutId: String? = null,
    val shortcutIntent: Intent? = null,
    val useShellLaunch: Boolean = false,
)

data class TaskSwitcherContextMenuLayout(
    val rowIndex: Int,
    val packageName: String,
    val menuRect: RectF,
    val items: List<TaskSwitcherMenuItem>,
    val itemRects: List<RectF>,
)

internal object TaskSwitcherContextMenuLayoutFactory {
    fun build(
        side: PanelSide,
        panelRect: RectF,
        rowRect: RectF,
        rowIndex: Int,
        packageName: String,
        items: List<TaskSwitcherMenuItem>,
        viewWidth: Int,
        viewHeight: Int,
        density: Float,
    ): TaskSwitcherContextMenuLayout {
        val itemHeight = 44f * density
        val padV = 6f * density
        val menuWidth = 220f * density
        val menuHeight = items.size * itemHeight + padV * 2f
        val gap = 8f * density
        var menuLeft = when (side) {
            PanelSide.LEFT -> panelRect.right + gap
            PanelSide.RIGHT -> panelRect.left - gap - menuWidth
        }
        if (menuLeft < 12f * density) {
            menuLeft = panelRect.left + gap
        }
        if (menuLeft + menuWidth > viewWidth - 12f * density) {
            menuLeft = (viewWidth - menuWidth - 12f * density).coerceAtLeast(12f * density)
        }
        var menuTop = rowRect.centerY() - menuHeight / 2f
        menuTop = menuTop.coerceIn(16f * density, (viewHeight - menuHeight - 16f * density).coerceAtLeast(16f * density))
        val menuRect = RectF(menuLeft, menuTop, menuLeft + menuWidth, menuTop + menuHeight)
        val itemRects = items.mapIndexed { index, _ ->
            val top = menuRect.top + padV + index * itemHeight
            RectF(menuRect.left, top, menuRect.right, top + itemHeight)
        }
        return TaskSwitcherContextMenuLayout(rowIndex, packageName, menuRect, items, itemRects)
    }
}
