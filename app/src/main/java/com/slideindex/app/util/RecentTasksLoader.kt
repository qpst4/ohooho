package com.slideindex.app.util

import com.slideindex.app.data.AppRepository

/**
 * Loads the task switcher list from system recents (via Shizuku), not UsageStats.
 */
object RecentTasksLoader {

    fun load(appRepository: AppRepository): List<RecentAppEntry> {
        val packages = TaskManagerUtil.refreshRecentTaskPackages()
        return buildEntries(appRepository, packages)
    }

    fun loadCached(appRepository: AppRepository): List<RecentAppEntry> {
        return buildEntries(appRepository, TaskManagerUtil.peekRecentTaskPackages())
    }

    private fun buildEntries(appRepository: AppRepository, packages: List<String>): List<RecentAppEntry> {
        if (!TaskManagerUtil.hasPermission()) return emptyList()
        return packages.mapNotNull { packageName ->
            appRepository.lookupApp(packageName)?.let { RecentAppEntry(it, 0L) }
        }
    }
}
