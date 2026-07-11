package com.slideindex.app.otp

import com.slideindex.app.autofill.OtpAutoInputFallbackPolicy
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OtpAutoInputOrchestratorPolicyTest {
    @Test
    fun retryReasons_matchOrchestratorFallbackBranch() {
        listOf("no_active_window", "no_editable_node", "timeout", "none").forEach { reason ->
            assertTrue(OtpAutoInputFallbackPolicy.shouldRetryAccessibility(reason))
        }
        assertFalse(OtpAutoInputFallbackPolicy.shouldRetryAccessibility("action_set_text_failed"))
    }
}
