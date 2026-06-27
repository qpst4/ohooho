package com.slideindex.app.util

import com.slideindex.app.SlideIndexApp
import com.slideindex.app.data.AppRepository

/**
 * Task switcher list backed by system recents (Shizuku). [syncFromSystem] is the source of truth.
 */
object RecentTasksLoader {

    @Volatile
    private var cachedEntries: List<RecentAppEntry> = emptyList()

    private val mainHandler = android.os.Handler(android.os.Looper.getMainLooper())

    fun peekCached(): List<RecentAppEntry> = cachedEntries

    /** Query system recents and replace local cache (including empty). */
    fun syncFromSystem(appRepository: AppRepository): List<RecentAppEntry> {
        val packages = TaskManagerUtil.refreshRecentTaskPackages()
        cachedEntries = buildEntries(appRepository, packages)
        return cachedEntries
    }

    fun refreshAsync(appRepository: AppRepository, onComplete: (List<RecentAppEntry>) -> Unit) {
        if (!TaskManagerUtil.hasPermission()) {
            cachedEntries = emptyList()
            onComplete(emptyList())
            return
        }
        Thread {
            val fresh = TaskManagerUtil.runOnTaskWorker {
                syncFromSystem(appRepository)
            }
            mainHandler.post { onComplete(fresh) }
        }.start()
    }

    fun removePackages(packages: Collection<String>) {
        if (packages.isEmpty()) return
        val remove = packages.toSet()
        cachedEntries = cachedEntries.filterNot { it.app.packageName in remove }
        packages.forEach { TaskManagerUtil.removePackageFromCache(it) }
    }

    private fun appContext() = SlideIndexApp.instance.applicationContext

    private fun buildEntries(appRepository: AppRepository, packages: List<String>): List<RecentAppEntry> {
        if (packages.isEmpty()) return emptyList()
        val lockedPackages = TaskSwitcherLockStore.lockedPackages(appContext())
        return packages.mapNotNull { packageName ->
            appRepository.lookupApp(packageName)?.let { app ->
                RecentAppEntry(app, 0L, packageName in lockedPackages)
            }
        }
    }
}
