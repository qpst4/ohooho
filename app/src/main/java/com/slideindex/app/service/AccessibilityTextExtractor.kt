package com.slideindex.app.service

import android.accessibilityservice.AccessibilityService
import android.graphics.Rect
import android.os.Build
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo

/**
 * Accessibility text collection for float-ball point/rect pick.
 *
 * Point pick uses smallest visible text-bearing bounds at the coordinate (FV-style),
 * not QC [defpackage.vo] deepest-first-return, so large transparent overlays like
 * Douyin's full-screen "pause video" button do not mask comment TextViews beneath.
 */
object AccessibilityTextExtractor {

    fun collectTextAt(service: AccessibilityService, rawX: Float, rawY: Float): String? {
        val px = rawX.toInt()
        val py = rawY.toInt()
        var best: TextCandidate? = null
        val windowBounds = Rect()
        for (window in service.windows) {
            window.getBoundsInScreen(windowBounds)
            if (!windowBounds.contains(px, py)) continue
            val root = window.root ?: continue
            if (root.packageName?.toString() == service.packageName) {
                releaseNode(root)
                continue
            }
            try {
                best = pickBetterCandidate(best, findTextCandidateAtNode(root, px, py))
            } finally {
                releaseNode(root)
            }
        }
        val active = service.rootInActiveWindow
        if (active != null && active.packageName?.toString() != service.packageName) {
            try {
                best = pickBetterCandidate(best, findTextCandidateAtNode(active, px, py))
            } finally {
                releaseNode(active)
            }
        }
        return best?.text
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

    internal data class TextCandidate(
        val text: String,
        val area: Int,
        val isPrimaryText: Boolean,
    )

    internal fun pickBetterCandidate(current: TextCandidate?, next: TextCandidate?): TextCandidate? {
        if (next == null) return current
        if (current == null) return next
        return TEXT_CANDIDATE_ORDER.compare(current, next).let { order ->
            if (order <= 0) current else next
        }
    }

    /**
     * Smallest visible text-bearing bounds at [px],[py]; scans the full subtree.
     */
    internal fun findTextAtNode(node: AccessibilityNodeInfo, px: Int, py: Int): String? =
        findTextCandidateAtNode(node, px, py)?.text

    internal fun findTextCandidateAtNode(
        node: AccessibilityNodeInfo,
        px: Int,
        py: Int,
    ): TextCandidate? {
        var best: TextCandidate? = null
        val bounds = Rect()
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(node)
        while (stack.isNotEmpty()) {
            val current = stack.removeFirst()
            val owned = current !== node
            try {
                current.getBoundsInScreen(bounds)
                if (current.isVisibleToUser && bounds.contains(px, py)) {
                    best = pickBetterCandidate(best, textCandidateAt(bounds, current))
                }
                for (i in 0 until current.childCount) {
                    current.getChild(i)?.let { stack.add(it) }
                }
            } finally {
                if (owned) releaseNode(current)
            }
        }
        return best
    }

    private val TEXT_CANDIDATE_ORDER = compareBy<TextCandidate> { it.area }
        .thenByDescending { it.isPrimaryText }
        .thenByDescending { it.text.length }

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

    private fun textCandidateAt(bounds: Rect, node: AccessibilityNodeInfo): TextCandidate? {
        val text = node.text?.toString()?.trim().orEmpty()
        if (text.isNotEmpty()) {
            return TextCandidate(
                text = text,
                area = bounds.width().coerceAtLeast(1) * bounds.height().coerceAtLeast(1),
                isPrimaryText = true,
            )
        }
        val description = node.contentDescription?.toString()?.trim().orEmpty()
        if (description.isNotEmpty()) {
            return TextCandidate(
                text = description,
                area = bounds.width().coerceAtLeast(1) * bounds.height().coerceAtLeast(1),
                isPrimaryText = false,
            )
        }
        return null
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
