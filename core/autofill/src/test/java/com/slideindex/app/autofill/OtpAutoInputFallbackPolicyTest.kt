package com.slideindex.app.autofill

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OtpAutoInputFallbackPolicyTest {
    @Test
    fun shouldRetryAccessibility_retriesOnTransientReasons() {
        listOf("no_active_window", "no_editable_node", "timeout", "none").forEach { reason ->
            assertTrue("expected retry for $reason", OtpAutoInputFallbackPolicy.shouldRetryAccessibility(reason))
        }
    }

    @Test
    fun shouldRetryAccessibility_doesNotRetryOnHardFailures() {
        listOf("action_set_text_failed", "group_set_text_failed", "set_text_exception").forEach { reason ->
            assertFalse("unexpected retry for $reason", OtpAutoInputFallbackPolicy.shouldRetryAccessibility(reason))
        }
    }

    @Test
    fun shouldFallbackToKeyboard_onlyForNoEditableNodeInAppWindow() {
        assertTrue(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard("no_editable_node", "com.example.bank"),
        )
        assertTrue(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard("no_editable_node", "<unknown>"),
        )
        assertTrue(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard("no_editable_node", ""),
        )
    }

    @Test
    fun shouldFallbackToKeyboard_skipsLauncherAndSystemUi() {
        assertFalse(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard(
                "no_editable_node",
                "com.android.launcher3",
            ),
        )
        assertFalse(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard(
                "no_editable_node",
                "com.android.systemui",
            ),
        )
        assertFalse(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard(
                "no_editable_node",
                "com.custom.launcher.app",
            ),
        )
    }

    @Test
    fun shouldFallbackToKeyboard_requiresNoEditableNodeReason() {
        assertFalse(
            OtpAutoInputFallbackPolicy.shouldFallbackToKeyboard("timeout", "com.example.bank"),
        )
    }
}
