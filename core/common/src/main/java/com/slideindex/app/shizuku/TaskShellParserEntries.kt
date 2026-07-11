package com.slideindex.app.shizuku

import com.slideindex.app.util.RecentPackageResolver

internal object TaskShellParserEntries {

    fun parseRecentsDump(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        var pendingTaskId: Int? = null
        var pendingRawIdentifier: String? = null
        var pendingTitle: String? = null
        var inRecentsFile = output.contains("ACTIVITY MANAGER RECENT TASKS")

        fun flushPending() {
            val id = pendingTaskId ?: return
            TaskShellParserSupport.addEntry(entries, id, pendingRawIdentifier, pendingTitle)
            pendingTaskId = null
            pendingRawIdentifier = null
            pendingTitle = null
        }

        for (line in output.lineSequence()) {
            when {
                line.contains("ACTIVITY MANAGER RECENT TASKS") -> inRecentsFile = true
                inRecentsFile && line.startsWith("ACTIVITY MANAGER") &&
                    !line.contains("RECENT TASKS") -> inRecentsFile = false
                line.contains("Recent tasks:") -> inRecentsFile = true
            }
            val header = TaskShellParserPatterns.RECENT_TASK_ID.matcher(line)
            if (header.find() && (inRecentsFile || line.contains("Recent #"))) {
                flushPending()
                pendingTaskId = header.group(1)?.toIntOrNull()
                pendingRawIdentifier = TaskShellParserSupport.extractRawIdentifierFromRecentLine(line)
                pendingTitle = TaskShellParserTitles.extractTitleFromLine(line)
                if (pendingRawIdentifier != null) {
                    flushPending()
                }
                continue
            }
            if (pendingTaskId != null) {
                TaskShellParserTitles.extractTitleFromLine(line)?.let { pendingTitle = it }
                TaskShellParserSupport.extractRawIdentifierFromLine(line)?.let { pendingRawIdentifier = it }
                if (pendingRawIdentifier != null) {
                    flushPending()
                }
            }
        }
        flushPending()
        return entries
    }

    fun parseRecentsTaskIds(output: String): Set<Int> {
        val ids = linkedSetOf<Int>()
        var inRecentsFile = output.contains("ACTIVITY MANAGER RECENT TASKS")
        for (line in output.lineSequence()) {
            when {
                line.contains("ACTIVITY MANAGER RECENT TASKS") -> inRecentsFile = true
                inRecentsFile && line.startsWith("ACTIVITY MANAGER") &&
                    !line.contains("RECENT TASKS") -> inRecentsFile = false
                line.contains("Recent tasks:") -> inRecentsFile = true
            }
            if (!inRecentsFile && !line.contains("Recent #")) continue
            TaskShellParserPatterns.RECENT_TASK_ID.matcher(line).let { matcher ->
                if (matcher.find()) {
                    matcher.group(1)?.toIntOrNull()
                        ?.takeIf(TaskShellParserSupport::isValidTaskId)
                        ?.let { ids += it }
                }
            }
        }
        return ids
    }

    fun scanPackagesInRecentsDump(recentsDump: String): Set<String> {
        val packages = linkedSetOf<String>()
        var inRecentsFile = recentsDump.contains("ACTIVITY MANAGER RECENT TASKS")
        for (line in recentsDump.lineSequence()) {
            when {
                line.contains("ACTIVITY MANAGER RECENT TASKS") -> inRecentsFile = true
                inRecentsFile && line.startsWith("ACTIVITY MANAGER") &&
                    !line.contains("RECENT TASKS") -> inRecentsFile = false
                line.contains("Recent tasks:") -> inRecentsFile = true
            }
            if (!inRecentsFile && !line.contains("Recent #")) continue
            TaskShellParserSupport.extractPackageFromRecentLine(line)?.let { raw ->
                TaskShellParserSupport.packageFromRawIdentifier(raw)?.let { packages += it }
            }
            TaskShellParserSupport.extractPackageFromLine(line)?.let { pkg ->
                packages += pkg
            }
        }
        parseRecentsDump(recentsDump).forEach { packages += it.packageName }
        return packages.filterNot { it in TaskShellParserPatterns.EXCLUDED_PACKAGES }.toSet()
    }

    fun parseCmdTaskList(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        var currentTaskId: Int? = null
        var headerPackage: String? = null
        var bestComponent: String? = null
        var pendingTitle: String? = null

        fun flushCurrent() {
            val id = currentTaskId ?: return
            val raw = bestComponent ?: headerPackage ?: return
            TaskShellParserSupport.addEntry(entries, id, raw, pendingTitle)
            currentTaskId = null
            headerPackage = null
            bestComponent = null
            pendingTitle = null
        }

        for (line in output.lineSequence()) {
            val trimmed = line.trim()
            when {
                TaskShellParserPatterns.CMD_TASK_HEADER.matcher(trimmed).let { matcher ->
                    if (matcher.find()) {
                        flushCurrent()
                        currentTaskId = matcher.group(1)?.toIntOrNull()
                        headerPackage = matcher.group(2)?.trim()?.takeIf { TaskShellParserSupport.isLikelyPackage(it) }
                        true
                    } else {
                        false
                    }
                } -> Unit
                TaskShellParserPatterns.TASK_ID_HEADER.matcher(line).find() -> {
                    flushCurrent()
                    currentTaskId = TaskShellParserPatterns.TASK_ID_HEADER.matcher(line).let { matcher ->
                        matcher.find()
                        matcher.group(1)?.toIntOrNull()
                    }
                }
                line.contains("taskId=") && currentTaskId == null -> {
                    currentTaskId = TaskShellParserPatterns.TASK_ID_FIELD.matcher(line).let { matcher ->
                        if (matcher.find()) matcher.group(1)?.toIntOrNull() else null
                    } ?: line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                }
                currentTaskId != null -> {
                    TaskShellParserTitles.extractTitleFromLine(line)?.let { pendingTitle = it }
                    when {
                        line.contains("topActivity=") -> {
                            TaskShellParserTitles.parseComponentFromActivityLine(line)?.let { bestComponent = it }
                        }
                        bestComponent == null && (
                            line.contains("baseActivity=") ||
                                line.contains("realActivity=") ||
                                line.contains("mActivityComponent=")
                            ) -> {
                            TaskShellParserTitles.parseComponentFromActivityLine(line)?.let { bestComponent = it }
                        }
                        bestComponent == null && line.contains("baseIntent=") -> {
                            TaskShellParserTitles.parseComponentFromActivityLine(line)?.let { bestComponent = it }
                        }
                    }
                }
            }
        }
        flushCurrent()
        return entries
    }

    fun parseAmStackList(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        var currentTaskId: Int? = null
        for (line in output.lineSequence()) {
            when {
                line.contains("taskId=") -> {
                    currentTaskId = line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                }
                currentTaskId != null && line.contains("component=") -> {
                    TaskShellParserTitles.parsePackageFromActivityLine(line)?.let { pkg ->
                        TaskShellParserSupport.addEntry(entries, currentTaskId, pkg)
                    }
                    currentTaskId = null
                }
            }
        }
        return entries
    }

    fun parseActivitiesDump(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        var pendingTaskId: Int? = null
        var pendingRawIdentifier: String? = null
        var pendingTitle: String? = null
        var inRecents = false

        fun flushPending() {
            if (!inRecents) {
                pendingTaskId = null
                pendingRawIdentifier = null
                pendingTitle = null
                return
            }
            val id = pendingTaskId ?: return
            TaskShellParserSupport.addEntry(entries, id, pendingRawIdentifier, pendingTitle)
            pendingTaskId = null
            pendingRawIdentifier = null
            pendingTitle = null
            inRecents = false
        }

        for (line in output.lineSequence()) {
            TaskShellParserPatterns.TASK_RECORD_HEADER.matcher(line).let { matcher ->
                if (matcher.find()) {
                    flushPending()
                    pendingTaskId = matcher.group(1)?.toIntOrNull()
                    pendingRawIdentifier = matcher.group(3)?.trim()?.takeIf { it.isNotEmpty() }
                        ?: matcher.group(2)?.trim()?.takeIf { it.isNotEmpty() }
                    inRecents = line.contains("inRecents=true")
                    pendingTitle = TaskShellParserTitles.extractTitleFromLine(line)
                    if (pendingRawIdentifier != null && inRecents) {
                        flushPending()
                    }
                    return@let
                }
            }
            if (pendingTaskId != null) {
                when {
                    line.contains("inRecents=true") -> inRecents = true
                    line.contains("inRecents=false") -> inRecents = false
                }
                TaskShellParserTitles.extractTitleFromLine(line)?.let { pendingTitle = it }
                TaskShellParserSupport.extractRawIdentifierFromLine(line)?.let { pendingRawIdentifier = it }
                if (pendingRawIdentifier != null && inRecents) {
                    flushPending()
                }
            }
        }
        flushPending()
        return entries
    }

    fun listRecentPackages(vararg outputs: String): List<String> {
        val packages = LinkedHashSet<String>()
        listRecentTaskEntries(*outputs).forEach { packages += it.packageName }
        if (outputs.isNotEmpty()) {
            scanPackagesInRecentsDump(outputs[0]).forEach { packages += it }
        }
        packages.removeAll(TaskShellParserPatterns.EXCLUDED_PACKAGES)
        return packages.toList()
    }

    fun listRecentTaskEntries(vararg outputs: String): List<ShellTaskEntry> {
        if (outputs.isEmpty()) return emptyList()
        val recentsDump = outputs[0]
        val taskListDump = outputs.getOrNull(1).orEmpty()
        val activitiesDump = outputs.getOrNull(2).orEmpty()
        val ordered = LinkedHashMap<Int, ShellTaskEntry>()

        val cmdByTaskId = if (taskListDump.isNotEmpty()) {
            parseCmdTaskList(taskListDump).associateBy { it.taskId }
        } else {
            emptyMap()
        }

        parseRecentsDump(recentsDump).forEach { entry ->
            if (!TaskShellParserSupport.shouldIncludeRecentEntry(entry)) return@forEach
            val enriched = TaskShellParserSupport.enrichFromCmd(entry, cmdByTaskId[entry.taskId])
            TaskShellParserSupport.putOrMergeEntry(ordered, enriched)
        }

        if (activitiesDump.isNotEmpty()) {
            parseActivitiesDump(activitiesDump).forEach { entry ->
                if (!TaskShellParserSupport.shouldIncludeRecentEntry(entry)) return@forEach
                val enriched = TaskShellParserSupport.enrichFromCmd(entry, cmdByTaskId[entry.taskId])
                TaskShellParserSupport.putOrMergeEntry(ordered, enriched)
            }
        }

        val recentsTaskIds = parseRecentsTaskIds(recentsDump).toMutableSet()
        ordered.keys.forEach { recentsTaskIds += it }
        val recentsPackages = scanPackagesInRecentsDump(recentsDump)
        val activityRecentPackages = if (activitiesDump.isNotEmpty()) {
            parseActivitiesDump(activitiesDump).map { it.packageName }.toSet()
        } else {
            emptySet()
        }

        if (taskListDump.isNotEmpty()) {
            parseCmdTaskList(taskListDump).forEach { entry ->
                if (!TaskShellParserSupport.shouldIncludeRecentEntry(entry)) return@forEach
                val inRecents = entry.taskId in recentsTaskIds
                val quickShare = RecentPackageResolver.isQuickShareIdentifier(entry.rawIdentifier)
                val packageInRecents = recentsPackages.any { pkg ->
                    RecentPackageResolver.matches(entry.packageName, pkg) ||
                        RecentPackageResolver.matches(entry.rawIdentifier, pkg)
                }
                val inActivityRecents = activityRecentPackages.any { pkg ->
                    RecentPackageResolver.matches(entry.packageName, pkg) ||
                        RecentPackageResolver.matches(entry.rawIdentifier, pkg)
                }
                if (inRecents || quickShare || packageInRecents || inActivityRecents) {
                    TaskShellParserSupport.putOrMergeEntry(ordered, entry)
                }
            }
        }

        mergeMissingRecentsPackages(ordered, recentsPackages, taskListDump)

        return ordered.values.filter { entry ->
            TaskShellParserSupport.shouldIncludeRecentEntry(entry) &&
                (TaskShellParserSupport.isValidTaskId(entry.taskId) || entry.taskId == 0)
        }
    }

    fun listRecentTaskEntriesFromCmdTaskList(taskListDump: String): List<ShellTaskEntry> {
        return parseCmdTaskList(taskListDump).filter { entry ->
            TaskShellParserSupport.shouldIncludeRecentEntry(entry) && TaskShellParserSupport.isValidTaskId(entry.taskId)
        }
    }

    fun listAllCmdTaskEntries(taskListDump: String): List<ShellTaskEntry> {
        return parseCmdTaskList(taskListDump).filter {
            TaskShellParserSupport.shouldIncludeRecentEntry(it) && TaskShellParserSupport.isValidTaskId(it.taskId)
        }
    }

    fun listRecentTaskEntriesFromRecentsDump(recentsDump: String): List<ShellTaskEntry> {
        return parseRecentsDump(recentsDump).filter {
            TaskShellParserSupport.shouldIncludeRecentEntry(it) && TaskShellParserSupport.isValidTaskId(it.taskId)
        }
    }

    fun filterRecentEntries(entries: List<ShellTaskEntry>): List<ShellTaskEntry> =
        entries.filter {
            TaskShellParserSupport.shouldIncludeRecentEntry(it) &&
                (TaskShellParserSupport.isValidTaskId(it.taskId) || it.taskId == 0)
        }

    fun matchesIdentifier(entry: ShellTaskEntry, identifier: String): Boolean =
        TaskShellParserSupport.matchesIdentifier(entry, identifier)

    private fun mergeMissingRecentsPackages(
        ordered: LinkedHashMap<Int, ShellTaskEntry>,
        recentsPackages: Set<String>,
        taskListDump: String,
    ) {
        if (recentsPackages.isEmpty()) return
        val cmdEntries = if (taskListDump.isNotEmpty()) parseCmdTaskList(taskListDump) else emptyList()
        for (pkg in recentsPackages) {
            if (ordered.values.any { TaskShellParserSupport.matchesEntry(it, pkg) }) continue
            val cmdEntry = cmdEntries.firstOrNull { TaskShellParserSupport.matchesEntry(it, pkg) }
            if (cmdEntry != null && TaskShellParserSupport.shouldIncludeRecentEntry(cmdEntry)) {
                ordered.putIfAbsent(cmdEntry.taskId, cmdEntry)
                continue
            }
            ordered.putIfAbsent(-pkg.hashCode(), ShellTaskEntry(0, pkg, pkg))
        }
    }
}
