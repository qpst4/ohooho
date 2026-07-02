package com.slideindex.app.util

import com.slideindex.app.data.AppRepository
import com.slideindex.app.tasks.TaskSwitcherRepository

/** Facade kept for overlay integration. */
object RecentTasksLoader {

    fun refreshAsync(appRepository: AppRepository, onComplete: (List<RecentAppEntry>) -> Unit) =
        TaskSwitcherRepository.refreshAsync(appRepository, onComplete)

    fun syncFromSystem(appRepository: AppRepository): List<RecentAppEntry> =
        TaskSwitcherRepository.syncFromSystem(appRepository)

    fun requestRefreshAfterSwitch(appRepository: AppRepository) =
        TaskSwitcherRepository.requestRefreshAfterSwitch(appRepository)

    fun removePackages(packages: Collection<String>) =
        TaskSwitcherRepository.removePackages(packages)

    fun removeTaskIds(taskIds: Collection<Int>) =
        TaskSwitcherRepository.removeTaskIds(taskIds)
}
