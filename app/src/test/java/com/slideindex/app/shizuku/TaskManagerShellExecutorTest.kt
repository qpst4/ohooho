package com.slideindex.app.shizuku

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TaskManagerShellExecutorTest {

    @Test
    fun shellQuote_wrapsAndEscapesSingleQuotes() {
        assertEquals("'echo hello'", TaskManagerShellExecutor.shellQuote("echo hello"))
        assertEquals("'it'\\''s fine'", TaskManagerShellExecutor.shellQuote("it's fine"))
    }

    @Test
    fun parseNumericUid_readsPlainInteger() {
        assertEquals(0, TaskManagerShellExecutor.parseNumericUid("0"))
        assertEquals(2000, TaskManagerShellExecutor.parseNumericUid(" 2000 \n"))
    }

    @Test
    fun parseNumericUid_readsUidFromIdOutput() {
        assertEquals(2000, TaskManagerShellExecutor.parseNumericUid("uid=2000(shell) gid=2000(shell)"))
    }

    @Test
    fun parseNumericUid_returnsNullForNonNumeric() {
        assertNull(TaskManagerShellExecutor.parseNumericUid("not-a-uid"))
    }

    @Test
    fun formatShellOutput_includesExitCodeAndSeparator() {
        assertEquals(
            "0\n---\nok",
            TaskManagerShellExecutor.formatShellOutput(0, "ok"),
        )
    }
}
