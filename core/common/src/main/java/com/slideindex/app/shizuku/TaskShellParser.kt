package com.slideindex.app.shizuku

data class ShellTaskEntry(
    val taskId: Int,
    val packageName: String,
    val rawIdentifier: String = packageName,
    val taskTitle: String? = null,
)

object TaskShellParser {

    /** Task card titles from dumpsys (taskDescription / window title). */
    fun parseTaskTitles(vararg sources: String): Map<Int, String> =
        TaskShellParserTitles.parseTaskTitles(*sources)

    /** Top/resumed activity component per task id. */
    fun parseTaskTopComponents(vararg sources: String): Map<Int, String> =
        TaskShellParserTitles.parseTaskTopComponents(*sources)

    fun enrichTaskEntry(
        entry: ShellTaskEntry,
        titleMap: Map<Int, String>,
        componentMap: Map<Int, String>,
    ): ShellTaskEntry = TaskShellParserTitles.enrichTaskEntry(entry, titleMap, componentMap)

    fun parseRecentsDump(output: String): List<ShellTaskEntry> =
        TaskShellParserEntries.parseRecentsDump(output)

    fun parseRecentsTaskIds(output: String): Set<Int> =
        TaskShellParserEntries.parseRecentsTaskIds(output)

    fun scanPackagesInRecentsDump(recentsDump: String): Set<String> =
        TaskShellParserEntries.scanPackagesInRecentsDump(recentsDump)

    fun parseCmdTaskList(output: String): List<ShellTaskEntry> =
        TaskShellParserEntries.parseCmdTaskList(output)

    fun findTaskIdForIdentifier(identifier: String, vararg outputs: String): Int? =
        TaskShellParserLookup.findTaskIdForIdentifier(identifier, *outputs)

    fun findTaskIdForComponent(component: String, vararg outputs: String): Int? =
        TaskShellParserLookup.findTaskIdForComponent(component, *outputs)

    fun findTaskIdsForPackage(packageName: String, vararg outputs: String): List<Int> =
        TaskShellParserLookup.findTaskIdsForPackage(packageName, *outputs)

    fun listRecentPackages(vararg outputs: String): List<String> =
        TaskShellParserEntries.listRecentPackages(*outputs)

    fun listRecentTaskEntries(vararg outputs: String): List<ShellTaskEntry> =
        TaskShellParserEntries.listRecentTaskEntries(*outputs)

    fun matchesIdentifier(entry: ShellTaskEntry, identifier: String): Boolean =
        TaskShellParserEntries.matchesIdentifier(entry, identifier)

    fun listRecentTaskEntriesFromCmdTaskList(taskListDump: String): List<ShellTaskEntry> =
        TaskShellParserEntries.listRecentTaskEntriesFromCmdTaskList(taskListDump)

    /** All tasks from cmd output — no recents-dump cross-check (Flyme / OEM fast path). */
    fun listAllCmdTaskEntries(taskListDump: String): List<ShellTaskEntry> =
        TaskShellParserEntries.listAllCmdTaskEntries(taskListDump)

    fun listRecentTaskEntriesFromRecentsDump(recentsDump: String): List<ShellTaskEntry> =
        TaskShellParserEntries.listRecentTaskEntriesFromRecentsDump(recentsDump)

    fun filterRecentEntries(entries: List<ShellTaskEntry>): List<ShellTaskEntry> =
        TaskShellParserEntries.filterRecentEntries(entries)

    fun parseAmStackList(output: String): List<ShellTaskEntry> =
        TaskShellParserEntries.parseAmStackList(output)

    fun parseActivitiesDump(output: String): List<ShellTaskEntry> =
        TaskShellParserEntries.parseActivitiesDump(output)

    fun findFrontTask(activitiesDump: String): ShellTaskEntry? =
        TaskShellParserLookup.findFrontTask(activitiesDump)

    fun findPackageForTaskId(taskId: Int, vararg outputs: String): String? =
        TaskShellParserLookup.findPackageForTaskId(taskId, *outputs)

    fun findComponentForTaskId(taskId: Int, vararg outputs: String): String? =
        TaskShellParserLookup.findComponentForTaskId(taskId, *outputs)
}
