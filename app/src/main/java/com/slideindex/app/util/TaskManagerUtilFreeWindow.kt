package com.slideindex.app.util

import android.content.Context
import android.util.Log
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.resolvedFreeWindowMode
import com.slideindex.app.shizuku.ITaskManagerService

internal object TaskManagerUtilFreeWindow {
    private const val TAG = "TaskManagerUtil"
    private const val MIN_FREE_WINDOW_API = 5
    private const val MIN_FRONT_PACKAGE_API = 7

    fun movePackageToFreeWindow(
        packageName: String,
        settings: AppSettings,
        hasPermission: Boolean,
        bindFreshService: (Int) -> ITaskManagerService?,
    ): Boolean {
        if (packageName.isBlank() || !hasPermission) return false
        val appContext = TaskManagerUtil.applicationContext()
        return TaskManagerUtil.runOnTaskWorker {
            val taskService = bindFreshService(MIN_FREE_WINDOW_API) ?: return@runOnTaskWorker false
            val taskId = taskService.getTaskIdsForPackage(packageName).firstOrNull()?.takeIf { it.isNotBlank() }
                ?: return@runOnTaskWorker false
            invokeMoveTaskToFreeWindow(taskService, taskId, settings, appContext)
        }
    }

    fun moveFrontTaskToFreeWindow(
        settings: AppSettings,
        hasPermission: Boolean,
        appContext: Context,
        bindFreshService: (Int) -> ITaskManagerService?,
        forceRestartUserService: (Context) -> Unit,
    ): Boolean {
        if (!hasPermission) return false
        return TaskManagerUtil.runOnTaskWorker {
            moveFrontTaskToFreeWindowLocked(
                settings = settings,
                appContext = appContext,
                bindFreshService = bindFreshService,
                forceRestartUserService = forceRestartUserService,
            )
        }
    }

    private fun moveFrontTaskToFreeWindowLocked(
        settings: AppSettings,
        appContext: Context,
        bindFreshService: (Int) -> ITaskManagerService?,
        forceRestartUserService: (Context) -> Unit,
    ): Boolean {
        return try {
            val taskService = bindFreshService(MIN_FRONT_PACKAGE_API) ?: return false
            val taskId = taskService.getFrontTaskId().takeIf { it.isNotBlank() } ?: run {
                Log.w(TAG, "moveFrontTaskToFreeWindow: no front task id")
                return false
            }
            val frontPackage = runCatching {
                taskService.getFrontTaskPackage().takeIf { it.isNotBlank() }
            }.getOrElse { error ->
                Log.w(TAG, "moveFrontTaskToFreeWindow: getFrontTaskPackage failed", error)
                null
            }
            if (frontPackage != null &&
                TaskExclusions.shouldSkipFreeWindow(frontPackage, appContext.packageName)
            ) {
                Log.w(TAG, "moveFrontTaskToFreeWindow: excluded front package=$frontPackage")
                return false
            }
            moveTaskToFreeWindowWithRetry(
                taskService = taskService,
                taskId = taskId,
                settings = settings,
                logPackage = frontPackage,
                appContext = appContext,
                bindFreshService = bindFreshService,
                forceRestartUserService = forceRestartUserService,
            )
        } catch (error: Exception) {
            Log.e(TAG, "moveFrontTaskToFreeWindow failed", error)
            false
        }
    }

    private fun moveTaskToFreeWindowWithRetry(
        taskService: ITaskManagerService,
        taskId: String,
        settings: AppSettings,
        logPackage: String?,
        appContext: Context,
        bindFreshService: (Int) -> ITaskManagerService?,
        forceRestartUserService: (Context) -> Unit,
    ): Boolean {
        var service = taskService
        var moved = invokeMoveTaskToFreeWindow(service, taskId, settings, appContext)
        if (!moved) {
            forceRestartUserService(appContext)
            service = bindFreshService(MIN_FREE_WINDOW_API) ?: return false
            moved = invokeMoveTaskToFreeWindow(service, taskId, settings, appContext)
        }
        Log.i(TAG, "moveFrontTaskToFreeWindow: taskId=$taskId package=$logPackage moved=$moved")
        return moved
    }

    private fun invokeMoveTaskToFreeWindow(
        taskService: ITaskManagerService,
        taskId: String,
        settings: AppSettings,
        appContext: Context,
    ): Boolean {
        return try {
            val bounds = FreeWindowLauncher.launchBounds(appContext, settings)
            val mode = settings.resolvedFreeWindowMode().windowingMode
            taskService.moveTaskToFreeWindow(
                taskId,
                mode,
                bounds.left,
                bounds.top,
                bounds.right,
                bounds.bottom,
            )
        } catch (e: Exception) {
            Log.e(TAG, "invokeMoveTaskToFreeWindow($taskId) failed", e)
            false
        }
    }
}
