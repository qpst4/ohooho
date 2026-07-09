package com.slideindex.app.ui.navigation

import androidx.navigation3.runtime.NavBackStack
import com.slideindex.app.overlay.PanelSide
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppNavBackStackIntegrationTest {

    private fun stack(initial: AppNavKey = AppNavKey.HomeMain): NavBackStack<AppNavKey> =
        @Suppress("UNCHECKED_CAST")
        (NavBackStack(initial) as NavBackStack<AppNavKey>)

    @Test
    fun navigate_pushesKeys() {
        val backStack = stack()
        backStack.navigate(AppNavKey.NotificationHub)
        backStack.navigate(AppNavKey.OtpHub)

        assertEquals(AppNavKey.OtpHub, backStack.last())
        assertEquals(3, backStack.size)
    }

    @Test
    fun navigateBackTo_popsUntilTarget() {
        val backStack = stack()
        backStack.navigate(AppNavKey.NotificationHub)
        backStack.navigate(AppNavKey.OtpHub)

        backStack.navigateBackTo(AppNavKey.HomeMain)

        assertEquals(AppNavKey.HomeMain, backStack.last())
        assertEquals(1, backStack.size)
    }

    @Test
    fun replaceRoot_clearsHistory() {
        val backStack = stack()
        backStack.navigate(AppNavKey.ExtensionHub)

        backStack.replaceRoot(AppNavKey.ShakeGestures)

        assertEquals(AppNavKey.ShakeGestures, backStack.last())
        assertEquals(1, backStack.size)
    }

    @Test
    fun isNotificationBranch_coversOtpAndHistoryRoutes() {
        assertTrue(AppNavKey.NotificationHub.isNotificationBranch())
        assertTrue(AppNavKey.OtpRecords(OtpRecordsReturn.Hub).isNotificationBranch())
        assertFalse(AppNavKey.HomeMain.isNotificationBranch())
    }

    @Test
    fun panelSide_roundTripThroughNavSide() {
        assertEquals(PanelSide.RIGHT, "RIGHT".toPanelSide())
        assertEquals("LEFT", PanelSide.LEFT.toNavSide())
    }
}
