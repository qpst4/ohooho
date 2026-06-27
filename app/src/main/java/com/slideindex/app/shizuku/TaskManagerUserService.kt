package com.slideindex.app.shizuku

import android.app.ActivityOptions
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.annotation.Keep

class TaskManagerUserService() : ITaskManagerService.Stub() {

    @Keep
    constructor(context: Context) : this()

    override fun destroy() {
        System.exit(0)
    }

    override fun removeTaskById(taskId: String?) {
        val id = taskId?.toIntOrNull() ?: return
        if (removeTaskViaSystemApi(id)) return
        shellCommand("cmd", "activity", "task", "remove", id.toString())
        shellCommand("am", "stack", "remove", id.toString())
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
        val recentsDump = shellOutput("dumpsys", "activity", "recents")
        val taskListDump = shellOutput("cmd", "activity", "task", "list")
        val ids = TaskShellParser.findTaskIdsForPackage(packageName, recentsDump, taskListDump)
        Log.i(TAG, "getTaskIdsForPackage($packageName) -> ${ids.joinToString()}")
        return ids.map { it.toString() }.toTypedArray()
    }

    override fun getRecentTaskPackages(): Array<String> {
        val recentsDump = shellOutput("dumpsys", "activity", "recents")
        val taskListDump = shellOutput("cmd", "activity", "task", "list")
        val stackListDump = shellOutput("am", "stack", "list")
        val packages = TaskShellParser.listRecentPackages(recentsDump, taskListDump, stackListDump)
        Log.i(TAG, "getRecentTaskPackages -> ${packages.joinToString()}")
        return packages.toTypedArray()
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
            Log.i(TAG, "moveTaskToFreeWindow taskId=$taskId mode=$windowingMode bounds=$bounds")
            for (mode in candidateWindowingModes(windowingMode)) {
                if (moveTaskToFreeWindowViaRecents(taskId, mode, bounds)) {
                    Log.i(TAG, "moveTaskToFreeWindow($taskId) via recents mode=$mode succeeded")
                    return true
                }
            }
            for (mode in candidateWindowingModes(windowingMode)) {
                if (moveTaskToFreeWindowViaSystemApi(taskId, mode, bounds)) {
                    Log.i(TAG, "moveTaskToFreeWindow($taskId) via ATM mode=$mode succeeded")
                    return true
                }
            }
            for (mode in candidateWindowingModes(windowingMode)) {
                if (relaunchViaShell(taskId, mode, bounds)) {
                    Log.i(TAG, "moveTaskToFreeWindow($taskId) via am start mode=$mode succeeded")
                    return true
                }
            }
            val shellResized = moveTaskToFreeWindowViaShell(taskId, bounds)
            Log.i(TAG, "moveTaskToFreeWindow($taskId) shell resize success=$shellResized")
            return shellResized
        } catch (error: Exception) {
            Log.e(TAG, "moveTaskToFreeWindow failed", error)
            false
        }
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
            val atm = activityTaskManager()
            val method = atm.javaClass.getMethod(
                "startActivityFromRecents",
                Int::class.javaPrimitiveType,
                Bundle::class.java,
            )
            val result = (method.invoke(atm, taskId, bundle) as? Number)?.toInt() ?: return false
            Log.i(TAG, "startActivityFromRecents taskId=$taskId mode=$windowingMode result=$result")
            result in START_SUCCESS..START_DELIVERED_TO_TOP
        } catch (e: Exception) {
            Log.w(TAG, "startActivityFromRecents failed taskId=$taskId mode=$windowingMode", e)
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
            var changed = false
            runCatching {
                atm.javaClass.getMethod(
                    "setTaskWindowingMode",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    Boolean::class.javaPrimitiveType,
                ).invoke(atm, taskId, windowingMode, true)
                changed = true
            }
            runCatching {
                atm.javaClass.getMethod(
                    "resizeTask",
                    Int::class.javaPrimitiveType,
                    Rect::class.java,
                    Int::class.javaPrimitiveType,
                ).invoke(atm, taskId, bounds, RESIZE_MODE_SYSTEM)
                changed = true
            }
            runCatching {
                atm.javaClass.getMethod(
                    "moveTaskToFront",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    Bundle::class.java,
                ).invoke(atm, taskId, 0, null)
            }
            changed
        } catch (e: Exception) {
            Log.w(TAG, "moveTaskToFreeWindowViaSystemApi failed taskId=$taskId", e)
            false
        }
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
        val component = TaskShellParser.findComponentForTaskId(taskId, taskListDump) ?: return false
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
            val method = atm.javaClass.getMethod("removeTask", Int::class.javaPrimitiveType)
            method.invoke(atm, taskId) as? Boolean == true
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
        return runCatching {
            val process = ProcessBuilder(*cmd).redirectErrorStream(true).start()
            val text = process.inputStream.bufferedReader().use { it.readText() }
            process.waitFor()
            process.destroy()
            text
        }.getOrDefault("")
    }

    companion object {
        private const val TAG = "TaskManagerUserService"
        const val API_VERSION = 12
        private const val RESIZE_MODE_SYSTEM = 0
        private const val KEY_WINDOWING_MODE = "android.activity.windowingMode"
        private const val START_SUCCESS = 0
        private const val START_DELIVERED_TO_TOP = 3
    }
}
