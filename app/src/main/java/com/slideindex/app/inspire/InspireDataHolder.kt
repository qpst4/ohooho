package com.slideindex.app.inspire

import android.graphics.Rect

/**
 * GestureEVO InspireDataHolder — passes pick results from overlay to content UI.
 */
object InspireDataHolder {
    private var screenshotBitmap: ManagedBitmap? = null
    var accessibilityContent: List<String>? = null
        private set
    var dragRect: Rect? = null
        private set
    var forceImageTextSelection: Boolean = false
        private set

    fun setAccessibilityContent(value: List<String>?) {
        accessibilityContent = value
    }

    fun setDragRect(rect: Rect?) {
        dragRect = rect
    }

    fun setForceImageTextSelection(value: Boolean) {
        forceImageTextSelection = value
    }

    fun replaceScreenshotBitmap(handle: ManagedBitmap?) {
        screenshotBitmap?.close()
        screenshotBitmap = null
        screenshotBitmap = handle?.acquire()
    }

    fun acquireScreenshotBitmap(): ManagedBitmap? = screenshotBitmap?.acquire()

    fun clearScreenshotBitmap() {
        screenshotBitmap?.close()
        screenshotBitmap = null
    }

    fun clear() {
        clearScreenshotBitmap()
        accessibilityContent = null
        forceImageTextSelection = false
        dragRect = null
    }
}
