package com.slideindex.app.service

import android.accessibilityservice.AccessibilityService
import android.graphics.Rect
import android.os.Build
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import com.slideindex.app.overlay.FloatBallOcrRegions

/**
 * Accessibility text collection for float-ball point/rect pick.
 *
 * Point pick uses smallest visible text-bearing bounds at the coordinate (FV-style),
 * not QC [defpackage.vo] deepest-first-return, so large transparent overlays like
 * Douyin's full-screen "pause video" button do not mask comment TextViews beneath.
 */
object AccessibilityTextExtractor {

    private const val FV_SKIP_WINDOW_MARKER = "*FV_SKIP_WINDOW*"
    private const val SKIP_MARKER_SCAN_DEPTH = 4

    private fun isSkipMarkerText(value: CharSequence?): Boolean =
        value?.toString() == FV_SKIP_WINDOW_MARKER

    private fun shouldSkipAccessibilityNode(node: AccessibilityNodeInfo): Boolean {
        if (isSkipMarkerText(node.contentDescription)) return true
        if (isSkipMarkerText(node.text)) return true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R &&
            isSkipMarkerText(node.stateDescription)
        ) {
            return true
        }
        return false
    }

    private fun shouldSkipWindowRoot(root: AccessibilityNodeInfo, service: AccessibilityService): Boolean {
        if (root.packageName?.toString() == service.packageName) return true
        return containsSkipMarker(root, SKIP_MARKER_SCAN_DEPTH)
    }

    private fun containsSkipMarker(node: AccessibilityNodeInfo, depthRemaining: Int): Boolean {
        if (shouldSkipAccessibilityNode(node)) return true
        if (depthRemaining <= 0) return false
        for (i in 0 until node.childCount) {
            val child = node.getChild(i) ?: continue
            try {
                if (containsSkipMarker(child, depthRemaining - 1)) return true
            } finally {
                releaseNode(child)
            }
        }
        return false
    }

    fun collectTextAt(service: AccessibilityService, rawX: Float, rawY: Float): String? {
        val px = rawX.toInt()
        val py = rawY.toInt()
        var best: TextCandidate? = null
        val windowBounds = Rect()
        for (window in service.windows) {
            window.getBoundsInScreen(windowBounds)
            if (!windowBounds.contains(px, py)) continue
            val root = window.root ?: continue
            if (shouldSkipWindowRoot(root, service)) {
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
        if (active != null && !shouldSkipWindowRoot(active, service)) {
            try {
                best = pickBetterCandidate(best, findTextCandidateAtNode(active, px, py))
            } finally {
                releaseNode(active)
            }
        }
        val pointText = best?.text
        if (!pointText.isNullOrBlank()) return pointText

        val metrics = service.resources.displayMetrics
        val nearbyRect = FloatBallOcrRegions.expandPoint(metrics, rawX, rawY)
        val nearby = collectTextInRect(service, nearbyRect).trim()
        return nearby.ifBlank { null }
    }

    fun findControlBoundsAt(service: AccessibilityService, rawX: Float, rawY: Float): Rect? {
        val px = rawX.toInt()
        val py = rawY.toInt()
        var best: BoundsCandidate? = null
        val windowBounds = Rect()
        val nodeBounds = Rect()
        for (window in service.windows) {
            window.getBoundsInScreen(windowBounds)
            if (!windowBounds.contains(px, py)) continue
            val root = window.root ?: continue
            if (shouldSkipWindowRoot(root, service)) {
                releaseNode(root)
                continue
            }
            try {
                best = pickBetterBoundsCandidate(
                    best,
                    findControlBoundsInNode(root, px, py, nodeBounds),
                )
            } finally {
                releaseNode(root)
            }
        }
        val active = service.rootInActiveWindow
        if (active != null && !shouldSkipWindowRoot(active, service)) {
            try {
                best = pickBetterBoundsCandidate(
                    best,
                    findControlBoundsInNode(active, px, py, nodeBounds),
                )
            } finally {
                releaseNode(active)
            }
        }
        return best?.rect
    }

    private data class BoundsCandidate(
        val rect: Rect,
        val score: Int,
    )

    private fun pickBetterBoundsCandidate(
        current: BoundsCandidate?,
        next: BoundsCandidate?,
    ): BoundsCandidate? {
        if (next == null) return current
        if (current == null) return next
        return if (next.score < current.score) next else current
    }

    private fun controlTargetScore(node: AccessibilityNodeInfo): Int {
        if (!node.text.isNullOrBlank()) return 0
        if (!node.contentDescription.isNullOrBlank()) return 1
        val className = node.className?.toString().orEmpty()
        if (className.contains("TextView", ignoreCase = true)) return 2
        if (node.isClickable || node.isFocusable || node.isLongClickable) return 3
        return 4
    }

    private fun findControlBoundsInNode(
        node: AccessibilityNodeInfo,
        px: Int,
        py: Int,
        bounds: Rect,
    ): BoundsCandidate? {
        var best: BoundsCandidate? = null
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(node)
        while (stack.isNotEmpty()) {
            val current = stack.removeFirst()
            val owned = current !== node
            try {
                if (shouldSkipAccessibilityNode(current)) continue
                if (current.isVisibleToUser) {
                    current.getBoundsInScreen(bounds)
                    if (bounds.contains(px, py) && isMeaningfulPickTarget(current)) {
                        val area = bounds.width().coerceAtLeast(1) * bounds.height().coerceAtLeast(1)
                        val score = controlTargetScore(current) * 1_000_000 + area
                        best = pickBetterBoundsCandidate(best, BoundsCandidate(Rect(bounds), score))
                    }
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

    private fun isMeaningfulPickTarget(node: AccessibilityNodeInfo): Boolean {
        if (!node.text.isNullOrBlank()) return true
        if (!node.contentDescription.isNullOrBlank()) return true
        if (node.isClickable || node.isFocusable || node.isLongClickable) return true
        return false
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
            if (shouldSkipWindowRoot(root, service)) {
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
        if (active != null && !shouldSkipWindowRoot(active, service)) {
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
                if (shouldSkipAccessibilityNode(current)) continue
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
                if (shouldSkipAccessibilityNode(node)) continue
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
        if (shouldSkipAccessibilityNode(node)) return null
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val stateDescription = node.stateDescription?.toString()?.trim().orEmpty()
            if (stateDescription.isNotEmpty()) {
                return TextCandidate(
                    text = stateDescription,
                    area = bounds.width().coerceAtLeast(1) * bounds.height().coerceAtLeast(1),
                    isPrimaryText = false,
                )
            }
        }
        return null
    }

    private fun nodeText(node: AccessibilityNodeInfo): String? {
        if (shouldSkipAccessibilityNode(node)) return null
        val text = node.text?.toString()?.trim().orEmpty()
        if (text.isNotEmpty()) return text
        val description = node.contentDescription?.toString()?.trim().orEmpty()
        if (description.isNotEmpty()) return description
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val stateDescription = node.stateDescription?.toString()?.trim().orEmpty()
            if (stateDescription.isNotEmpty()) return stateDescription
        }
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
