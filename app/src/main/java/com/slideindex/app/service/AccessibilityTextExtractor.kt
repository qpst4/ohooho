package com.slideindex.app.service

import android.accessibilityservice.AccessibilityService
import android.graphics.Rect
import android.os.Build
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo

/**
 * Quick Cursor [defpackage.vo] style accessibility text collection.
 *
 * Point pick mirrors QC copy: iterate windows by window bounds, then recurse children
 * before reading text on the current node (deepest-with-text, not smallest-area leaf).
 */
object AccessibilityTextExtractor {

    fun collectTextAt(service: AccessibilityService, rawX: Float, rawY: Float): String? {
        val px = rawX.toInt()
        val py = rawY.toInt()
        val windowBounds = Rect()
        for (window in service.windows) {
            window.getBoundsInScreen(windowBounds)
            if (!windowBounds.contains(px, py)) continue
            val root = window.root ?: continue
            try {
                val text = findTextAtNode(root, px, py)
                if (text != null) return text
            } finally {
                releaseNode(root)
            }
        }
        val active = service.rootInActiveWindow ?: return null
        return try {
            findTextAtNode(active, px, py)
        } finally {
            releaseNode(active)
        }
    }

    fun collectTextInRect(service: AccessibilityService, rect: Rect): String {
        if (rect.width() <= 0 || rect.height() <= 0) return ""
        val normalized = Rect(rect)
        val entries = ArrayList<TextEntry>()
        val seen = LinkedHashSet<String>()
        val windowBounds = Rect()
        for (window in service.windows) {
            when (window.type) {
                AccessibilityWindowInfo.TYPE_INPUT_METHOD -> continue
            }
            window.getBoundsInScreen(windowBounds)
            if (!Rect.intersects(windowBounds, normalized)) continue
            val root = window.root ?: continue
            if (root.packageName?.toString() == service.packageName) {
                releaseNode(root)
                continue
            }
            try {
                collectIntersectingTexts(root, normalized, entries)
            } finally {
                releaseNode(root)
            }
        }
        val active = service.rootInActiveWindow
        if (active != null && active.packageName?.toString() != service.packageName) {
            try {
                collectIntersectingTexts(active, normalized, entries)
            } finally {
                releaseNode(active)
            }
        }
        return joinSortedTexts(entries, seen)
    }

    /**
     * QC [vo.m]: bounds contains point → search children first → then node text / description.
     */
    internal fun findTextAtNode(node: AccessibilityNodeInfo, px: Int, py: Int): String? {
        val bounds = Rect()
        node.getBoundsInScreen(bounds)
        if (!bounds.contains(px, py)) return null

        val childCount = node.childCount
        if (childCount > 0) {
            for (i in 0 until childCount) {
                val child = node.getChild(i) ?: continue
                try {
                    val fromChild = findTextAtNode(child, px, py)
                    if (fromChild != null) return fromChild
                } finally {
                    releaseNode(child)
                }
            }
        }

        val text = node.text?.toString()
        if (!text.isNullOrEmpty()) return text
        val description = node.contentDescription?.toString()
        if (!description.isNullOrEmpty()) return description
        return null
    }

    internal fun joinSortedTexts(entries: List<TextEntry>, seen: LinkedHashSet<String> = LinkedHashSet()): String {
        return entries
            .sortedWith(compareBy<TextEntry> { it.top }.thenBy { it.left })
            .mapNotNull { entry ->
                val text = entry.text.trim()
                if (text.isEmpty() || !seen.add(text)) null else text
            }
            .joinToString("\n")
    }

    internal data class TextEntry(
        val text: String,
        val top: Int,
        val left: Int,
    )

    private fun collectIntersectingTexts(
        root: AccessibilityNodeInfo,
        rect: Rect,
        out: MutableList<TextEntry>,
    ) {
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(root)
        val bounds = Rect()
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            val owned = node !== root
            try {
                if (!node.isVisibleToUser) continue
                node.getBoundsInScreen(bounds)
                if (!Rect.intersects(bounds, rect)) continue
                nodeText(node)?.let { text ->
                    out.add(TextEntry(text = text, top = bounds.top, left = bounds.left))
                }
                for (i in 0 until node.childCount) {
                    node.getChild(i)?.let { stack.add(it) }
                }
            } finally {
                if (owned) releaseNode(node)
            }
        }
    }

    private fun nodeText(node: AccessibilityNodeInfo): String? {
        val text = node.text?.toString()?.trim().orEmpty()
        if (text.isNotEmpty()) return text
        val description = node.contentDescription?.toString()?.trim().orEmpty()
        if (description.isNotEmpty()) return description
        return null
    }

    private fun copyNode(source: AccessibilityNodeInfo): AccessibilityNodeInfo =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            AccessibilityNodeInfo(source)
        } else {
            @Suppress("DEPRECATION")
            AccessibilityNodeInfo.obtain(source)
        }

    private fun releaseNode(node: AccessibilityNodeInfo?) {
        if (node == null) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) return
        @Suppress("DEPRECATION")
        node.recycle()
    }
}
