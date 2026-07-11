package com.slideindex.app.overlay

import android.graphics.RectF
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class QuickLauncherScrollHandlerTest {

    @Test
    fun computePageCommitDelta_advancesWhenSwipedPastThreshold() {
        val delta = QuickLauncherScrollHandler.computePageCommitDelta(
            offset = -50f,
            panelWidth = 200f,
            pageIndex = 0,
            pageCount = 3,
        )

        assertEquals(1, delta)
    }

    @Test
    fun computePageCommitDelta_retreatsWhenSwipedBackPastThreshold() {
        val delta = QuickLauncherScrollHandler.computePageCommitDelta(
            offset = 50f,
            panelWidth = 200f,
            pageIndex = 2,
            pageCount = 3,
        )

        assertEquals(-1, delta)
    }

    @Test
    fun computePageCommitDelta_staysWhenBelowThreshold() {
        val delta = QuickLauncherScrollHandler.computePageCommitDelta(
            offset = -10f,
            panelWidth = 200f,
            pageIndex = 0,
            pageCount = 3,
        )

        assertEquals(0, delta)
    }

    @Test
    fun computePageCommitDelta_doesNotAdvancePastLastPage() {
        val delta = QuickLauncherScrollHandler.computePageCommitDelta(
            offset = -50f,
            panelWidth = 200f,
            pageIndex = 2,
            pageCount = 3,
        )

        assertEquals(0, delta)
    }

    @Test
    fun computeEdgePageZone_leftPanel_outerEdgeIsPreviousPage() {
        val panel = RectF(0f, 0f, 100f, 100f)

        assertEquals(
            -1,
            QuickLauncherScrollHandler.computeEdgePageZone(
                touchX = 5f,
                panelRect = panel,
                side = PanelSide.LEFT,
                edgePx = 14f,
            ),
        )
    }

    @Test
    fun computeEdgePageZone_leftPanel_innerEdgeIsNextPage() {
        val panel = RectF(0f, 0f, 100f, 100f)

        assertEquals(
            1,
            QuickLauncherScrollHandler.computeEdgePageZone(
                touchX = 95f,
                panelRect = panel,
                side = PanelSide.LEFT,
                edgePx = 14f,
            ),
        )
    }

    @Test
    fun computeEdgePageZone_rightPanel_invertsEdges() {
        val panel = RectF(0f, 0f, 100f, 100f)

        assertEquals(
            -1,
            QuickLauncherScrollHandler.computeEdgePageZone(
                touchX = 5f,
                panelRect = panel,
                side = PanelSide.RIGHT,
                edgePx = 14f,
            ),
        )
        assertEquals(
            1,
            QuickLauncherScrollHandler.computeEdgePageZone(
                touchX = 95f,
                panelRect = panel,
                side = PanelSide.RIGHT,
                edgePx = 14f,
            ),
        )
    }

    @Test
    fun isWithinTapSlop_allowsSmallMovement() {
        assertTrue(QuickLauncherManagementTouchHandler.isWithinTapSlop(3f, 4f, 24f))
    }

    @Test
    fun isWithinTapSlop_rejectsLargeMovement() {
        assertFalse(QuickLauncherManagementTouchHandler.isWithinTapSlop(30f, 0f, 24f))
    }
}
