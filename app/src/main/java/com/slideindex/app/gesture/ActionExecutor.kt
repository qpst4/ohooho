package com.slideindex.app.gesture

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.slideindex.app.data.AppRepository
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.launcher.QuickLauncherItemType
import com.slideindex.app.service.SlideIndexAccessibilityService
import com.slideindex.app.service.OverlayService
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.shouldLaunchFullscreen
import com.slideindex.app.util.FreeWindowLauncher
import com.slideindex.app.util.TaskExclusions
import com.slideindex.app.util.TaskManagerUtil

class ActionExecutor(
    private val context: Context,
    private val appRepository: AppRepository,
) {
    private val mainHandler = Handler(Looper.getMainLooper())

    fun execute(action: GestureAction, settings: AppSettings, longPressArmed: Boolean = false) {
        when (action) {
            GestureAction.OpenIndex, GestureAction.QuickLauncher, GestureAction.TaskSwitcher, GestureAction.None -> Unit
            is GestureAction.LaunchApp -> launchApp(action.packageName, settings, longPressArmed)
            GestureAction.Back, GestureAction.Home, GestureAction.Recents -> {
                SlideIndexAccessibilityService.perform(action)
            }
            GestureAction.CloseCurrentApp -> closeCurrentApp()
            GestureAction.FreeWindowCurrentApp -> freeWindowForegroundApp(settings)
        }
    }

    fun launchQuickItem(item: QuickLauncherItem, settings: AppSettings, longPressArmed: Boolean = false) {
        when (item.type) {
            QuickLauncherItemType.APP -> launchApp(item.payload, settings, longPressArmed)
            QuickLauncherItemType.SHORTCUT -> launchShortcut(item.payload, settings, longPressArmed)
            QuickLauncherItemType.WIDGET -> Unit
        }
    }

    private fun launchApp(packageName: String, settings: AppSettings, longPressArmed: Boolean) {
        val app = appRepository.getCachedApps().firstOrNull { it.packageName == packageName } ?: return
        val fullscreen = settings.shouldLaunchFullscreen(longPressArmed)
        appRepository.launchApp(app, settings, fullscreen)
    }

    private fun launchShortcut(componentFlat: String, settings: AppSettings, longPressArmed: Boolean) {
        val component = ComponentName.unflattenFromString(componentFlat) ?: return
        val intent = Intent(Intent.ACTION_MAIN).apply {
            setComponent(component)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        val fullscreen = settings.shouldLaunchFullscreen(longPressArmed)
        if (fullscreen || !settings.freeWindowEnabled) {
            context.startActivity(intent)
        } else {
            FreeWindowLauncher.launch(context, intent, settings, fullscreen = false)
        }
    }

    private fun closeCurrentApp() {
        if (!TaskManagerUtil.hasPermission()) return
        Thread { TaskManagerUtil.removeCurrentFrontAppTask() }.start()
    }

    private fun freeWindowForegroundApp(settings: AppSettings) {
        val effectiveSettings = settings.copy(freeWindowEnabled = true)
        if (TaskManagerUtil.hasPermission()) {
            Thread {
                try {
                    val moved = TaskManagerUtil.moveFrontTaskToFreeWindow(effectiveSettings)
                    if (!moved) {
                        val packageName = resolveFreeWindowTargetPackage() ?: return@Thread
                        mainHandler.post {
                            runCatching {
                                launchFreeWindowFallback(packageName, effectiveSettings)
                            }.onFailure { error ->
                                Log.e(TAG, "launchFreeWindowFallback failed", error)
                            }
                        }
                    }
                } catch (error: Exception) {
                    Log.e(TAG, "freeWindowForegroundApp failed", error)
                }
            }.start()
            return
        }
        runCatching {
            val packageName = resolveFreeWindowTargetPackage() ?: return
            launchFreeWindowFallback(packageName, effectiveSettings)
        }.onFailure { error ->
            Log.e(TAG, "freeWindowForegroundApp failed", error)
        }
    }

    private fun resolveFreeWindowTargetPackage(): String? {
        val selfPackage = context.packageName
        return listOfNotNull(
            OverlayService.gestureForegroundPackage,
            OverlayService.foregroundPackage,
        ).firstOrNull { !TaskExclusions.shouldSkipFreeWindow(it, selfPackage) }
    }

    private fun launchFreeWindowFallback(packageName: String, settings: AppSettings) {
        val app = appRepository.getCachedApps().firstOrNull { it.packageName == packageName }
            ?: appRepository.lookupApp(packageName)
            ?: return
        appRepository.launchApp(app, settings, fullscreen = false)
    }

    companion object {
        private const val TAG = "ActionExecutor"
    }
}
