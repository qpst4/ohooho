package com.slideindex.app.inspire.ui

import android.graphics.Rect

interface InspireViewCallback {
    fun onDragMove(dragSelectRect: Rect) = Unit
    fun onDragUp(dragSelectRect: Rect)
    fun onDragCancel() = Unit
    fun onCopyText(dragSelectRect: Rect, isPress: Boolean) = Unit
    fun onSaveImage(dragSelectRect: Rect, isPress: Boolean) = Unit
    fun onSharImage(dragSelectRect: Rect, isPress: Boolean) = Unit
    fun onPinImage(dragSelectRect: Rect) = Unit
    fun onPinImageLongPress(dragSelectRect: Rect) = Unit
}
