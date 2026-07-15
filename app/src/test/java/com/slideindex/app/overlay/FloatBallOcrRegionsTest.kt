package com.slideindex.app.overlay

import android.graphics.Rect
import android.util.DisplayMetrics
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class FloatBallOcrRegionsTest {
    @Test
    fun expandPoint_createsRegionAroundAnchor() {
        val metrics = DisplayMetrics().apply {
            density = 2f
            widthPixels = 1080
            heightPixels = 2400
        }
        val rect = FloatBallOcrRegions.expandPoint(metrics, 400f, 800f)
        assertTrue(rect.contains(400, 800))
        assertTrue(rect.width() >= 160)
        assertTrue(rect.height() >= 160)
    }

    @Test
    fun clampToScreen_keepsRectInsideDisplay() {
        val rect = FloatBallOcrRegions.clampToScreen(Rect(-10, -10, 20, 20), 1080, 2400)
        assertEquals(0, rect.left)
        assertEquals(0, rect.top)
        assertTrue(rect.right <= 1080)
        assertTrue(rect.bottom <= 2400)
    }
}
