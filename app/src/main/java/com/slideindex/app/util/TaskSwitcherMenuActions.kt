package com.slideindex.app.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import com.slideindex.app.data.AppRepository
import com.slideindex.app.overlay.TaskSwitcherMenuItem
import com.slideindex.app.overlay.TaskSwitcherMenuItemType
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.R

object TaskSwitcherMenuActions {
    private const val TAG = "TaskSwitcherMenuActions"

    fun buildFixedMenuItems(context: Context): List<TaskSwitcherMenuItem> {
        return listOf(
            TaskSwitcherMenuItem(
                label = context.getString(R.string.task_switcher_menu_free_window),
                type = TaskSwitcherMenuItemType.FREE_WINDOW,
            ),
            TaskSwitcherMenuItem(
                label = context.getString(R.string.task_switcher_menu_app_info),
                type = TaskSwitcherMenuItemType.APP_INFO,
            ),
            TaskSwitcherMenuItem(
                label = context.getString(R.string.task_switcher_menu_force_stop),
                type = TaskSwitcherMenuItemType.FORCE_STOP,
            ),
        )
    }

    fun mergeMenuItems(shortcuts: List<TaskSwitcherMenuItem>, fixed: List<TaskSwitcherMenuItem>): List<TaskSwitcherMenuItem> {
        return shortcuts + fixed
    }

    fun buildMenuItems(context: Context, packageName: String): List<TaskSwitcherMenuItem> {
        val shortcuts = AppShortcutLoader.loadMenuShortcuts(context, packageName)
        return mergeMenuItems(shortcuts, buildFixedMenuItems(context))
    }

    fun execute(
        context: Context,
        item: TaskSwitcherMenuItem,
        packageName: String,
        settings: AppSettings,
        appRepository: AppRepository,
        onTaskRemoved: () -> Unit,
    ) {
        when (item.type) {
            TaskSwitcherMenuItemType.SHORTCUT -> {
                AppShortcutLoader.launchShortcut(context, packageName, item)
            }
            TaskSwitcherMenuItemType.FREE_WINDOW -> {
                launchInFreeWindow(context, packageName, settings, appRepository)
            }
            TaskSwitcherMenuItemType.APP_INFO -> {
                openAppInfo(context, packageName)
            }
            TaskSwitcherMenuItemType.FORCE_STOP -> {
                Thread {
                    val stopped = TaskManagerUtil.forceStopPackage(packageName)
                    if (stopped) {
                        onTaskRemoved()
                    }
                }.start()
            }
        }
    }

    private fun openAppInfo(context: Context, packageName: String) {
        runCatching {
            context.startActivity(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", packageName, null)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                },
            )
        }.onFailure { error ->
            Log.e(TAG, "openAppInfo($packageName) failed", error)
        }
    }

    fun openInFreeWindow(
        context: Context,
        packageName: String,
        settings: AppSettings,
        appRepository: AppRepository,
    ) {
        launchInFreeWindow(context, packageName, settings, appRepository)
    }

    private fun launchInFreeWindow(
        context: Context,
        packageName: String,
        settings: AppSettings,
        appRepository: AppRepository,
    ) {
        val effective = settings.copy(freeWindowEnabled = true)
        Thread {
            val moved = TaskManagerUtil.movePackageToFreeWindow(packageName, effective)
            if (!moved) {
                val app = appRepository.lookupApp(packageName) ?: return@Thread
                appRepository.launchApp(app, effective, fullscreen = false)
            }
        }.start()
    }
}
