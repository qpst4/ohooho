package com.slideindex.app.shizuku

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.os.IBinder
import android.os.Process
import android.os.SystemClock
import android.util.Log
import androidx.annotation.Keep
import com.slideindex.app.util.ShortcutDisplayRules
import com.slideindex.app.util.ShortcutShellParser

class TaskManagerUserService() : ITaskManagerService.Stub() {

    @Keep
    constructor(context: Context) : this()

    override fun destroy() {
        System.exit(0)
    }

    override fun removeTaskById(taskIdStr: String?): Boolean {
        val id = taskIdStr?.toIntOrNull()?.takeIf { it > 0 } ?: return false
        invalidateActivityDumps()
        if (removeTaskViaSystemApi(id)) {
            Log.i(TAG, "removeTaskById($id) via system API succeeded")
            return true
        }
        val commands = listOf(
            arrayOf("cmd", "activity", "task", "remove", id.toString()),
            arrayOf("cmd", "activity", "task", "remove-task", id.toString()),
            arrayOf("am", "task", "remove", id.toString()),
            arrayOf("am", "stack", "remove", id.toString()),
        )
        for (command in commands) {
            if (shellCommand(*command)) {
                Log.i(TAG, "removeTaskById($id) via ${command.joinToString(" ")} succeeded")
                return true
            }
        }
        Log.w(TAG, "removeTaskById($id) failed")
        return false
    }

    override fun getFrontTaskId(): String {
        return try {
            readFrontTask()?.taskId?.toString().orEmpty().also {
                Log.i(TAG, "getFrontTaskId -> $it")
            }
        } catch (error: Exception) {
            Log.e(TAG, "getFrontTaskId failed", error)
            ""
        }
    }

    override fun getFrontTaskPackage(): String {
        return try {
            val activitiesDump = shellOutput("dumpsys", "activity", "activities")
            val task = TaskShellParser.findFrontTask(activitiesDump)
            val packageName = task?.packageName?.takeIf { it.isNotBlank() }
                ?: task?.taskId?.let { taskId ->
                    val taskListDump = shellOutput("cmd", "activity", "task", "list")
                    TaskShellParser.findPackageForTaskId(taskId, activitiesDump, taskListDump)
                }.orEmpty()
            Log.i(TAG, "getFrontTaskPackage -> $packageName")
            packageName
        } catch (error: Exception) {
            Log.e(TAG, "getFrontTaskPackage failed", error)
            ""
        }
    }

    override fun getApiVersion(): Int = API_VERSION

    override fun getTaskIdsForPackage(packageName: String?): Array<String> {
        if (packageName.isNullOrBlank()) return emptyArray()
        val dumps = readActivityDumps()
        TaskShellParser.findTaskIdForIdentifier(
            packageName,
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        )?.let { exactId ->
            return arrayOf(exactId.toString())
        }
        val ids = TaskShellParser.findTaskIdsForPackage(
            packageName,
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        )
        return ids.map { it.toString() }.toTypedArray()
    }

    override fun getRecentTaskPackages(): Array<String> {
        val dumps = readActivityDumps()
        val packages = TaskShellParser.listRecentPackages(
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        )
        return packages.toTypedArray()
    }

    override fun getRecentTasks(): Array<String> {
        val dumps = readActivityDumps()
        val titleMap = TaskShellParser.parseTaskTitles(
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        )
        val componentMap = TaskShellParser.parseTaskTopComponents(
            dumps.activities,
            dumps.taskList,
            dumps.recents,
        )
        val entries = TaskShellParser.listRecentTaskEntries(
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        ).map { entry ->
            TaskShellParser.enrichTaskEntry(entry, titleMap, componentMap)
        }
        if (entries.isNotEmpty()) {
            return entries.map { entry ->
                val topComponent = componentMap[entry.taskId].orEmpty()
                "${entry.taskId}\t${entry.rawIdentifier}\t${entry.taskTitle.orEmpty()}\t$topComponent"
            }.toTypedArray()
        }
        return TaskShellParser.listRecentPackages(
            dumps.recents,
            dumps.taskList,
            dumps.activities,
        ).map { "0\t$it" }.toTypedArray()
    }

    override fun switchToTask(
        taskIdStr: String?,
        identifier: String?,
        topComponentStr: String?,
    ): Boolean {
        invalidateActivityDumps()
        val dumps = readActivityDumps()
        val rawId = identifier?.trim().orEmpty()
        val taskId = taskIdStr?.toIntOrNull()?.takeIf { it > 0 }
            ?: if (rawId.isNotEmpty()) {
                TaskShellParser.findTaskIdForIdentifier(
                    rawId,
                    dumps.recents,
                    dumps.taskList,
                    dumps.activities,
                )
            } else {
                null
            } ?: run {
                Log.w(TAG, "switchToTask unresolved taskIdStr=$taskIdStr identifier=$rawId")
                return false
            }

        val component = topComponentStr?.trim()?.takeIf { it.contains('/') }
            ?: TaskShellParser.findComponentForTaskId(
                taskId,
                dumps.taskList,
                dumps.activities,
                dumps.recents,
            )

        Log.i(TAG, "switchToTask taskId=$taskId identifier=$rawId component=$component")

        if (switchToTaskViaRecents(taskId)) {
            Log.i(TAG, "switchToTask($taskId) via recents succeeded")
            return true
        }
        if (switchToTaskViaMoveToFront(taskId)) {
            Log.i(TAG, "switchToTask($taskId) via moveTaskToFront succeeded")
            return true
        }
        if (focusTaskViaShell(taskId)) {
            Log.i(TAG, "switchToTask($taskId) via shell focus succeeded")
            return true
        }
        if (component != null && launchComponentForTask(taskId, component)) {
            Log.i(TAG, "switchToTask($taskId) via component launch succeeded")
            return true
        }
        Log.w(TAG, "switchToTask($taskId) failed")
        return false
    }

    override fun showVoiceAssistant(): Boolean {
        if (shellCommand("cmd", "voiceinteraction", "show")) {
            Log.i(TAG, "showVoiceAssistant via cmd voiceinteraction show succeeded")
            return true
        }
        Log.w(TAG, "showVoiceAssistant failed")
        return false
    }

    override fun runShellCommand(cmd: Array<out String>?): Boolean {
        if (cmd.isNullOrEmpty()) return false
        return shellCommand(*cmd)
    }

    override fun runShellCommandOutput(cmd: Array<out String>?): String {
        if (cmd.isNullOrEmpty()) return formatShellOutput(-1, "Empty command")
        val result = shellCommandWithOutput(*cmd)
        return formatShellOutput(result.exitCode, result.output)
    }

    override fun runShellCommandLine(command: String?, useRoot: Boolean, forceAdb: Boolean): String {
        val trimmed = command?.trim().orEmpty()
        if (trimmed.isEmpty()) return formatShellOutput(-1, "Empty command")
        val wantRoot = useRoot && !forceAdb
        val result = when {
            wantRoot -> runAsRootUser(trimmed)
            else -> runAsShellUser(trimmed)
        }
        return formatShellOutput(result.exitCode, result.output)
    }

    override fun probeRootAvailable(): Boolean {
        return when {
            Process.myUid() == 0 -> true
            else -> {
                val result = runAsRootUser("id -u")
                result.exitCode == 0 && parseNumericUid(result.output) == 0
            }
        }
    }

    private fun buildPlainShellArgs(command: String): Array<String> =
        arrayOf(resolveShPath(), "-c", command)

    private fun runAsRootUser(command: String): ShellExecResult {
        if (Process.myUid() == 0) {
            return shellCommandWithOutput(*buildPlainShellArgs(command))
        }
        val su = resolveSuInvocation()
        val q = shellQuote(command)
        val scripts = listOf(
            "$su -c $q",
            "$su 0 sh -c $q",
        )
        return runFirstSuccessfulShellScript(scripts, command)
    }

    private fun runAsShellUser(command: String): ShellExecResult {
        if (Process.myUid() != 0) {
            return shellCommandWithOutput(*buildPlainShellArgs(command))
        }
        val wrapper = findShellDowngradeWrapper()
            ?: return ShellExecResult(
                exitCode = -1,
                output = "无法降级到 adb/shell 身份（Shizuku 当前以 Root 运行）。\n" +
                    "请改用 adb/无线调试方式启动 Shizuku。",
            )
        val result = shellCommandWithOutput(resolveShPath(), "-c", wrapper(command))
        return ShellExecResult(
            exitCode = result.exitCode,
            output = SHELL_DOWNGRADE_HINT + result.output,
        )
    }

    /** Probe each candidate wrapper with `id -u`, then reuse the first that yields a non-root uid. */
    private fun findShellDowngradeWrapper(): ((String) -> String)? {
        val sh = resolveShPath()
        val su = resolveSuInvocation()
        val candidates = listOf(
            { cmd: String -> "toybox setuidgid 2000 $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "toybox setuidgid shell $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "/system/bin/toybox setuidgid 2000 $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "/system/bin/toybox setuidgid shell $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "setuidgid 2000 $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "setuidgid shell $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "$su --user shell -c ${shellQuote(cmd)}" },
            { cmd: String -> "$su shell -c ${shellQuote(cmd)}" },
            { cmd: String -> "$su shell $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "$su -c \"$sh -c ${shellQuote(cmd)}\" shell" },
            { cmd: String -> "$su 2000 $sh -c ${shellQuote(cmd)}" },
            { cmd: String -> "/data/adb/ap/bin/apd su shell -c ${shellQuote(cmd)}" },
            { cmd: String -> "/data/adb/ksud su shell -c ${shellQuote(cmd)}" },
        )
        for (wrap in candidates) {
            val probe = shellCommandWithOutput(sh, "-c", wrap("id -u"))
            val uid = parseNumericUid(probe.output)
            if (probe.exitCode == 0 && uid != null && uid != 0) {
                return wrap
            }
        }
        return null
    }

    private fun runFirstSuccessfulShellScript(scripts: List<String>, command: String): ShellExecResult {
        var last = ShellExecResult(-1, "su 执行失败")
        for (script in scripts) {
            val result = shellCommandWithOutput(resolveShPath(), "-c", script)
            last = result
            if (result.exitCode == 0) return result
        }
        return last
    }

    private fun parseNumericUid(output: String): Int? {
        val trimmed = output.trim()
        trimmed.toIntOrNull()?.let { return it }
        return Regex("""uid=(\d+)""").find(trimmed)?.groupValues?.get(1)?.toIntOrNull()
    }

    private fun resolveShPath(): String =
        if (java.io.File(SYSTEM_SH).exists()) SYSTEM_SH else "/bin/sh"

    private fun resolveSuInvocation(): String {
        val candidates = listOf(
            "/sbin/su",
            "/system/xbin/su",
            SYSTEM_SU,
            "/vendor/bin/su",
            "/debug_ramdisk/su",
            "/data/adb/magisk/magisk",
        )
        return candidates.firstOrNull { java.io.File(it).exists() } ?: "su"
    }

    private fun shellQuote(command: String): String =
        "'" + command.replace("'", "'\\''") + "'"

    private fun launchComponentForTask(taskId: Int, component: String): Boolean {
        val attempts = listOf(
            arrayOf(
                "am", "start", "-n", component,
                "--activity-single-top", "--activity-clear-top", "--activity-reorder-to-front",
            ),
            arrayOf(
                "am", "start", "-n", component,
                "--activity-single-top", "--activity-clear-top",
            ),
            arrayOf("am", "start", "-n", component),
        )
        for (command in attempts) {
            if (shellCommand(*command)) {
                focusTaskViaShell(taskId)
                return true
            }
        }
        return false
    }

    private fun relaunchTopActivityForTask(taskId: Int, dumps: ActivityDumps): Boolean {
        val component = TaskShellParser.findComponentForTaskId(
            taskId,
            dumps.taskList,
            dumps.activities,
            dumps.recents,
        ) ?: return false
        return launchComponentForTask(taskId, component)
    }

    override fun forceStopPackage(packageName: String?): Boolean {
        if (packageName.isNullOrBlank()) return false
        val stopped = shellCommand("am", "force-stop", packageName)
        Log.i(TAG, "forceStopPackage($packageName) -> $stopped")
        return stopped
    }

    override fun getPublishedShortcuts(packageName: String?): Array<String> {
        if (packageName.isNullOrBlank()) return emptyArray()
        val merged = linkedMapOf<String, String>()
        fun absorb(entries: List<Pair<String, String>>) {
            entries.forEach { (id, label) ->
                merged.putIfAbsent(id, label)
            }
        }
        val flagSets = listOf("15", "1039")
        for (flags in flagSets) {
            val dump = shellOutput(
                "cmd", "shortcut", "get-shortcuts", "--user", "0", "--flags", flags, packageName,
            )
            absorb(ShortcutShellParser.parse(dump, packageName))
        }
        val packageDump = shellOutput("dumpsys", "shortcut", "--user", "0", packageName)
        absorb(ShortcutShellParser.parse(packageDump, packageName))
        if (merged.isEmpty()) {
            val launcherPackage = resolveDefaultLauncherPackage()
            if (launcherPackage.isNotBlank()) {
                val fullDump = shellOutput("dumpsys", "shortcut", "--user", "0")
                absorb(ShortcutShellParser.parse(fullDump, packageName))
            }
        }
        val filtered = merged.filter { (id, label) -> ShortcutDisplayRules.isDisplayable(id, label) }
        Log.i(TAG, "getPublishedShortcuts($packageName) -> ${filtered.size}")
        return filtered.map { (id, label) -> "$id\t$label" }.toTypedArray()
    }

    private fun resolveDefaultLauncherPackage(): String {
        val roleDump = shellOutput("cmd", "role", "get-role-holders", "android.app.role.HOME")
        parseLauncherPackage(roleDump)?.let { return it }
        val legacyDump = shellOutput("cmd", "shortcut", "get-default-launcher", "--user", "0")
        return parseLauncherPackage(legacyDump).orEmpty()
    }

    private fun parseLauncherPackage(dump: String): String? {
        return dump.lineSequence()
            .map { it.trim() }
            .firstOrNull { line ->
                line.isNotBlank() &&
                    !line.equals("Success", ignoreCase = true) &&
                    !line.startsWith("Error:", ignoreCase = true) &&
                    line.contains('.') &&
                    !line.contains(' ')
            }
    }

    override fun startPublishedShortcut(packageName: String?, shortcutId: String?): Boolean {
        if (packageName.isNullOrBlank() || shortcutId.isNullOrBlank()) return false
        val attempts = listOf(
            arrayOf("cmd", "shortcut", "start-shortcut", "--user", "0", packageName, shortcutId),
            arrayOf("cmd", "shortcut", "start-shortcut", packageName, shortcutId),
        )
        val started = attempts.any { shellCommand(*it) }
        Log.i(TAG, "startPublishedShortcut($packageName, $shortcutId) -> $started")
        return started
    }

    override fun moveTaskToFreeWindow(
        taskIdStr: String?,
        windowingMode: Int,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int,
    ): Boolean {
        return try {
            val taskId = taskIdStr?.toIntOrNull()?.takeIf { it > 0 } ?: return false
            val bounds = Rect(left, top, right, bottom)
            val frontTaskId = readFrontTask()?.taskId
            val isFrontTask = frontTaskId == taskId
            Log.i(
                TAG,
                "moveTaskToFreeWindow taskId=$taskId frontTaskId=$frontTaskId isFront=$isFrontTask mode=$windowingMode bounds=$bounds",
            )
            if (isFrontTask) {
                moveFrontTaskToFreeWindow(taskId, windowingMode, bounds)
            } else {
                moveBackgroundTaskToFreeWindow(taskId, windowingMode, bounds)
            }
        } catch (error: Exception) {
            Log.e(TAG, "moveTaskToFreeWindow failed", error)
            false
        }
    }

    private fun moveFrontTaskToFreeWindow(taskId: Int, windowingMode: Int, bounds: Rect): Boolean {
        for (mode in candidateWindowingModes(windowingMode)) {
            if (moveTaskToFreeWindowViaRecents(taskId, mode, bounds)) {
                Log.i(TAG, "moveFrontTaskToFreeWindow($taskId) via recents mode=$mode succeeded")
                return true
            }
        }
        for (mode in candidateWindowingModes(windowingMode)) {
            if (moveTaskToFreeWindowViaSystemApi(taskId, mode, bounds)) {
                Log.i(TAG, "moveFrontTaskToFreeWindow($taskId) via ATM mode=$mode succeeded")
                return true
            }
        }
        for (mode in candidateWindowingModes(windowingMode)) {
            if (relaunchViaShell(taskId, mode, bounds)) {
                Log.i(TAG, "moveFrontTaskToFreeWindow($taskId) via am start mode=$mode succeeded")
                return true
            }
        }
        val shellResized = moveTaskToFreeWindowViaShell(taskId, bounds)
        Log.i(TAG, "moveFrontTaskToFreeWindow($taskId) shell resize success=$shellResized")
        return shellResized
    }

    private fun moveBackgroundTaskToFreeWindow(taskId: Int, windowingMode: Int, bounds: Rect): Boolean {
        for (mode in candidateWindowingModes(windowingMode)) {
            if (relaunchViaShell(taskId, mode, bounds)) {
                Log.i(TAG, "moveBackgroundTaskToFreeWindow($taskId) via am start mode=$mode succeeded")
                return true
            }
        }
        for (mode in candidateWindowingModes(windowingMode)) {
            if (moveTaskToFreeWindowViaSystemApi(taskId, mode, bounds)) {
                Log.i(TAG, "moveBackgroundTaskToFreeWindow($taskId) via ATM mode=$mode succeeded")
                return true
            }
        }
        if (focusAndResizeTaskViaShell(taskId, bounds)) {
            Log.i(TAG, "moveBackgroundTaskToFreeWindow($taskId) via shell focus+resize succeeded")
            return true
        }
        for (mode in candidateWindowingModes(windowingMode)) {
            if (moveTaskToFreeWindowViaRecents(taskId, mode, bounds)) {
                Log.i(TAG, "moveBackgroundTaskToFreeWindow($taskId) via recents mode=$mode succeeded")
                return true
            }
        }
        val shellResized = moveTaskToFreeWindowViaShell(taskId, bounds)
        Log.i(TAG, "moveBackgroundTaskToFreeWindow($taskId) shell resize success=$shellResized")
        return shellResized
    }

    private fun readFrontTask(): ShellTaskEntry? {
        return TaskShellParser.findFrontTask(shellOutput("dumpsys", "activity", "activities"))
    }

    private fun candidateWindowingModes(primary: Int): IntArray {
        return linkedSetOf(primary, 11, 5, 100, 102).toIntArray()
    }

    private fun moveTaskToFreeWindowViaRecents(taskId: Int, windowingMode: Int, bounds: Rect): Boolean {
        return try {
            val options = ActivityOptions.makeBasic()
            applyLaunchWindowingMode(options, windowingMode)
            options.setLaunchBounds(bounds)
            val bundle = options.toBundle() ?: Bundle()
            if (bundle.getInt(KEY_WINDOWING_MODE, -1) == -1) {
                bundle.putInt(KEY_WINDOWING_MODE, windowingMode)
            }
            invokeStartActivityFromRecents(taskId, bundle)
        } catch (e: Exception) {
            Log.w(TAG, "startActivityFromRecents failed taskId=$taskId mode=$windowingMode", e)
            false
        }
    }

    private fun switchToTaskViaRecents(taskId: Int): Boolean {
        return invokeStartActivityFromRecents(taskId, ActivityOptions.makeBasic().toBundle() ?: Bundle())
    }

    private fun invokeStartActivityFromRecents(taskId: Int, bundle: Bundle): Boolean {
        return try {
            val atm = activityTaskManager()
            val method = atm.javaClass.getMethod(
                "startActivityFromRecents",
                Int::class.javaPrimitiveType,
                Bundle::class.java,
            )
            val result = (method.invoke(atm, taskId, bundle) as? Number)?.toInt() ?: return false
            Log.i(TAG, "startActivityFromRecents taskId=$taskId result=$result")
            result in START_SUCCESS..START_DELIVERED_TO_TOP
        } catch (e: Exception) {
            Log.w(TAG, "invokeStartActivityFromRecents failed taskId=$taskId", e)
            false
        }
    }

    private fun switchToTaskViaMoveToFront(taskId: Int): Boolean {
        return try {
            val atm = activityTaskManager()
            runCatching {
                atm.javaClass.getMethod(
                    "moveTaskToFront",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    Bundle::class.java,
                ).invoke(atm, taskId, 0, null)
            }.isSuccess
        } catch (e: Exception) {
            Log.w(TAG, "switchToTaskViaMoveToFront failed taskId=$taskId", e)
            false
        }
    }

    private fun applyLaunchWindowingMode(options: ActivityOptions, mode: Int) {
        try {
            ActivityOptions::class.java
                .getMethod("setLaunchWindowingMode", Int::class.javaPrimitiveType)
                .invoke(options, mode)
        } catch (_: Exception) {
        }
    }

    private fun moveTaskToFreeWindowViaSystemApi(taskId: Int, windowingMode: Int, bounds: Rect): Boolean {
        return try {
            val atm = activityTaskManager()
            var windowingApplied = false
            runCatching {
                atm.javaClass.getMethod(
                    "setTaskWindowingMode",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    Boolean::class.javaPrimitiveType,
                ).invoke(atm, taskId, windowingMode, true)
                windowingApplied = true
            }
            runCatching {
                atm.javaClass.getMethod(
                    "resizeTask",
                    Int::class.javaPrimitiveType,
                    Rect::class.java,
                    Int::class.javaPrimitiveType,
                ).invoke(atm, taskId, bounds, RESIZE_MODE_SYSTEM)
            }
            val options = ActivityOptions.makeBasic()
            applyLaunchWindowingMode(options, windowingMode)
            options.setLaunchBounds(bounds)
            val bundle = options.toBundle() ?: Bundle()
            if (bundle.getInt(KEY_WINDOWING_MODE, -1) == -1) {
                bundle.putInt(KEY_WINDOWING_MODE, windowingMode)
            }
            val movedToFront = runCatching {
                atm.javaClass.getMethod(
                    "moveTaskToFront",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    Bundle::class.java,
                ).invoke(atm, taskId, 0, bundle) as? Boolean
            }.getOrNull() == true
            windowingApplied || movedToFront
        } catch (e: Exception) {
            Log.w(TAG, "moveTaskToFreeWindowViaSystemApi failed taskId=$taskId", e)
            false
        }
    }

    private fun focusAndResizeTaskViaShell(taskId: Int, bounds: Rect): Boolean {
        val focused = focusTaskViaShell(taskId)
        val resized = moveTaskToFreeWindowViaShell(taskId, bounds)
        return focused && resized
    }

    private fun focusTaskViaShell(taskId: Int): Boolean {
        return shellCommand("cmd", "activity", "task", "focus", taskId.toString())
    }

    private fun moveTaskToFreeWindowViaShell(taskId: Int, bounds: Rect): Boolean {
        return shellCommand(
            "cmd", "activity", "task", "resize",
            taskId.toString(),
            bounds.left.toString(),
            bounds.top.toString(),
            bounds.right.toString(),
            bounds.bottom.toString(),
        )
    }

    private fun relaunchViaShell(taskId: Int, windowingMode: Int, bounds: Rect): Boolean {
        val taskListDump = shellOutput("cmd", "activity", "task", "list")
        val activitiesDump = shellOutput("dumpsys", "activity", "activities")
        val component = TaskShellParser.findComponentForTaskId(
            taskId,
            taskListDump,
            activitiesDump,
        ) ?: return false
        if (!shellCommand(
                "am", "start", "-n", component,
                "--windowingMode", windowingMode.toString(),
                "--activity-single-top", "--activity-clear-top",
            )
        ) {
            return false
        }
        return moveTaskToFreeWindowViaShell(taskId, bounds)
    }

    private fun removeTaskViaSystemApi(taskId: Int): Boolean {
        return try {
            val atm = activityTaskManager()
            val attempts = listOf(
                { atm.javaClass.getMethod("removeTask", Int::class.javaPrimitiveType).invoke(atm, taskId) as? Boolean },
                {
                    atm.javaClass.getMethod(
                        "removeTask",
                        Int::class.javaPrimitiveType,
                        Boolean::class.javaPrimitiveType,
                    ).invoke(atm, taskId, true) as? Boolean
                },
            )
            attempts.any { runCatching { it() }.getOrNull() == true }
        } catch (e: Exception) {
            false
        }
    }

    private fun activityTaskManager(): Any {
        val serviceManager = Class.forName("android.os.ServiceManager")
        val binder = serviceManager.getMethod("getService", String::class.java)
            .invoke(null, "activity_task") as IBinder
        val stubClass = Class.forName("android.app.IActivityTaskManager\$Stub")
        return stubClass.getMethod("asInterface", IBinder::class.java).invoke(null, binder)
            ?: error("IActivityTaskManager is null")
    }

    private fun shellCommand(vararg cmd: String): Boolean {
        return runCatching {
            val process = ProcessBuilder(*cmd).redirectErrorStream(true).start()
            val exitCode = process.waitFor()
            process.inputStream.bufferedReader().readText()
            process.destroy()
            exitCode == 0
        }.getOrDefault(false)
    }

    private fun shellOutput(vararg cmd: String): String {
        return shellCommandWithOutput(*cmd).output
    }

    private data class ShellExecResult(val exitCode: Int, val output: String)

    private fun shellCommandWithOutput(vararg cmd: String): ShellExecResult {
        return runCatching {
            val process = ProcessBuilder(*cmd)
                .redirectErrorStream(true)
                .directory(java.io.File("/"))
                .apply {
                    environment()["PATH"] = "/system/bin:/system/xbin:/vendor/bin:/product/bin"
                }
                .start()
            val finished = process.waitFor(SHELL_COMMAND_TIMEOUT_MS, java.util.concurrent.TimeUnit.MILLISECONDS)
            if (!finished) {
                process.destroyForcibly()
                return ShellExecResult(-1, "Command timed out after ${SHELL_COMMAND_TIMEOUT_MS / 1000}s")
            }
            val text = buildString {
                process.inputStream.bufferedReader().use { reader ->
                    val content = reader.readText()
                    if (content.isNotEmpty()) append(content.trimEnd())
                }
                if (isEmpty()) {
                    append("(no output, exit=${process.exitValue()})")
                }
            }
            process.destroy()
            ShellExecResult(process.exitValue(), text)
        }.getOrElse { error ->
            ShellExecResult(-1, error.message ?: "Execution failed")
        }
    }

    private fun formatShellOutput(exitCode: Int, output: String): String =
        "$exitCode\n---\n$output"

    private data class ActivityDumps(
        val atMs: Long,
        val recents: String,
        val taskList: String,
        val activities: String,
    )

    @Volatile
    private var cachedActivityDumps: ActivityDumps? = null

    private fun readActivityDumps(): ActivityDumps {
        val now = SystemClock.elapsedRealtime()
        cachedActivityDumps?.let { cache ->
            if (now - cache.atMs < ACTIVITY_DUMP_CACHE_MS) return cache
        }
        return ActivityDumps(
            atMs = now,
            recents = shellOutput("dumpsys", "activity", "recents"),
            taskList = shellOutput("cmd", "activity", "task", "list"),
            activities = shellOutput("dumpsys", "activity", "activities"),
        ).also { cachedActivityDumps = it }
    }

    private fun invalidateActivityDumps() {
        cachedActivityDumps = null
    }

    companion object {
        private const val TAG = "TaskManagerUserService"
        const val API_VERSION = ShizukuUserServiceHost.SERVICE_BUILD
        const val SHELL_DOWNGRADE_HINT = "提示:已将root降权至shell\n"
        private const val SHELL_COMMAND_TIMEOUT_MS = 30_000L
        private const val SYSTEM_SH = "/system/bin/sh"
        private const val SYSTEM_SU = "/system/bin/su"
        private const val ACTIVITY_DUMP_CACHE_MS = 1_500L
        private const val RESIZE_MODE_SYSTEM = 0
        private const val KEY_WINDOWING_MODE = "android.activity.windowingMode"
        private const val START_SUCCESS = 0
        private const val START_DELIVERED_TO_TOP = 3
    }
}
