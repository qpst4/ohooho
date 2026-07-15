package com.slideindex.app.overlay

import android.graphics.Bitmap
import android.graphics.Rect

data class FloatBallPickResult(
    val text: String?,
    val screenshot: Bitmap?,
    val screenRect: Rect?,
)
