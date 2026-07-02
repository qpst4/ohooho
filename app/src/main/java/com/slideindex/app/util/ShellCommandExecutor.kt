package com.slideindex.app.util

import android.os.SystemClock
import com.slideindex.app.shell.ShellCommand

object ShellCommandExecutor {
    private const val ROOT_PROBE_CACHE_MS = 30_000L

    @Volatile
    private var cachedRootAvailable: Boolean? = null

    @Volatile
    private var rootProbeAtMs = 0L

    fun execute(command: ShellCommand): TaskManagerUtil.ShellCommandResult {
        val useRoot = resolveUseRoot()
        return TaskManagerUtil.runShellCommandLine(
            command = command.command,
            useRoot = useRoot,
        )
    }

    fun probeRootAvailable(): Boolean = TaskManagerUtil.probeRootAvailable()

    fun invalidateRootCache() {
        cachedRootAvailable = null
        rootProbeAtMs = 0L
    }

    private fun resolveUseRoot(): Boolean {
        val now = SystemClock.elapsedRealtime()
        cachedRootAvailable?.let { cached ->
            if (now - rootProbeAtMs < ROOT_PROBE_CACHE_MS) return cached
        }
        val available = probeRootAvailable()
        cachedRootAvailable = available
        rootProbeAtMs = now
        return available
    }
}
