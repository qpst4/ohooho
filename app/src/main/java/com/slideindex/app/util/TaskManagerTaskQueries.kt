package com.slideindex.app.util

import android.util.Log
import com.slideindex.app.shizuku.ITaskManagerService

internal object TaskManagerTaskQueries {
    private const val TAG = "TaskManagerUtil"

    fun parseRecentTaskRows(rows: Array<String>): List<TaskManagerUtil.RecentTaskRef> =
        rows.mapNotNull(::parseRecentTaskRow)

    fun fetchRecentTasksFromService(taskService: ITaskManagerService): List<TaskManagerUtil.RecentTaskRef> {
        val tasks = runCatching {
            parseRecentTaskRows(taskService.getRecentTasks())
        }.getOrElse { error ->
            Log.e(TAG, "refreshRecentTasks failed", error)
            emptyList()
        }
        Log.i(
            TAG,
            "refreshRecentTasks (${tasks.size}): ${tasks.joinToString { "${it.taskId}|${it.identifier}" }}",
        )
        return tasks
    }

    fun parseRecentTaskRow(row: String): TaskManagerUtil.RecentTaskRef? {
        val trimmed = row.trim()
        if (trimmed.isEmpty()) return null
        val tabParts = trimmed.split('\t')
        if (tabParts.size >= 2) {
            val taskId = tabParts[0].trim().toIntOrNull() ?: return null
            val identifier = tabParts[1].trim()
            if (identifier.isEmpty()) return null
            val title = tabParts.getOrNull(2)?.trim()?.takeIf { it.isNotEmpty() }
            val topComponent = tabParts.getOrNull(3)?.trim()?.takeIf { it.contains('/') }
            return TaskManagerUtil.RecentTaskRef(taskId, identifier, title, topComponent)
        }
        val match = Regex("^(\\d+)\\s+(\\S+)$").find(trimmed) ?: return null
        val taskId = match.groupValues[1].toIntOrNull() ?: return null
        val identifier = match.groupValues[2].trim()
        if (identifier.isEmpty()) return null
        return TaskManagerUtil.RecentTaskRef(taskId, identifier)
    }

    fun resolveTaskIdFromIds(ids: Array<String>): Int? =
        ids.singleOrNull()?.toIntOrNull() ?: ids.firstOrNull()?.toIntOrNull()
}
