package com.slideindex.app.overlay

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TaskSwitcherLongPressHandlerTest {

    @Test
    fun closeLongPressDwellMs_usesContinuousThresholdWhenActive() {
        assertEquals(
            TaskSwitcherOverlayController.TASK_SWITCHER_CLOSE_CONTINUOUS_DWELL_MS,
            TaskSwitcherLongPressHandler.closeLongPressDwellMs(continuousPickActive = true),
        )
    }

    @Test
    fun closeLongPressDwellMs_usesStandardThresholdWhenInactive() {
        assertEquals(
            TaskSwitcherOverlayController.TASK_SWITCHER_CLOSE_DWELL_MS,
            TaskSwitcherLongPressHandler.closeLongPressDwellMs(continuousPickActive = false),
        )
    }

    @Test
    fun shouldSkipRowLongPressSync_whenContinuousPickInactive() {
        assertTrue(
            TaskSwitcherLongPressHandler.shouldSkipRowLongPressSync(
                continuousPickActive = false,
                contextMenuActive = false,
                rowLongPressTriggered = false,
            ),
        )
    }

    @Test
    fun shouldArmRowLongPress_whenRowChangesAndClosePressNotConflicting() {
        assertTrue(
            TaskSwitcherLongPressHandler.shouldArmRowLongPress(
                pickRow = 2,
                closePressIndex = 1,
                closeLongPressScheduled = false,
                closeLongPressTriggered = false,
                currentRowPressIndex = 0,
            ),
        )
    }

    @Test
    fun shouldArmRowLongPress_returnsFalseWhenClosePressConflicts() {
        assertFalse(
            TaskSwitcherLongPressHandler.shouldArmRowLongPress(
                pickRow = 2,
                closePressIndex = 2,
                closeLongPressScheduled = true,
                closeLongPressTriggered = false,
                currentRowPressIndex = 0,
            ),
        )
    }

    @Test
    fun shouldArmRowLongPress_returnsFalseForSameRow() {
        assertFalse(
            TaskSwitcherLongPressHandler.shouldArmRowLongPress(
                pickRow = 2,
                closePressIndex = -1,
                closeLongPressScheduled = false,
                closeLongPressTriggered = false,
                currentRowPressIndex = 2,
            ),
        )
    }
}
