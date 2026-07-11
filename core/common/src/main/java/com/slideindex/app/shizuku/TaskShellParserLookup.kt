package com.slideindex.app.shizuku

internal object TaskShellParserLookup {

    fun findTaskIdForIdentifier(identifier: String, vararg outputs: String): Int? {
        val trimmed = identifier.trim()
        if (trimmed.isEmpty()) return null
        TaskShellParserEntries.listRecentTaskEntries(*outputs).forEach { entry ->
            if (entry.rawIdentifier == trimmed) return entry.taskId
        }
        if (trimmed.contains('/')) {
            findTaskIdForComponent(trimmed, *outputs)?.let { return it }
        }
        val fuzzy = findTaskIdsForPackage(trimmed, *outputs)
        return fuzzy.singleOrNull()
    }

    fun findTaskIdForComponent(component: String, vararg outputs: String): Int? {
        val trimmed = component.trim()
        if (!trimmed.contains('/')) return null
        TaskShellParserTitles.parseTaskTopComponents(*outputs).forEach { (taskId, topComponent) ->
            if (topComponent == trimmed) return taskId
        }
        val pkg = trimmed.substringBefore('/')
        var cls = trimmed.substringAfter('/')
        if (cls.startsWith('.')) cls = pkg + cls
        val normalized = "$pkg/$cls"
        TaskShellParserTitles.parseTaskTopComponents(*outputs).forEach { (taskId, topComponent) ->
            if (topComponent == normalized) return taskId
        }
        return null
    }

    fun findTaskIdsForPackage(packageName: String, vararg outputs: String): List<Int> {
        val ids = linkedSetOf<Int>()
        outputs.forEach { output ->
            TaskShellParserEntries.parseRecentsDump(output).forEach {
                if (TaskShellParserSupport.matchesEntry(it, packageName)) ids += it.taskId
            }
            TaskShellParserEntries.parseCmdTaskList(output).forEach {
                if (TaskShellParserSupport.matchesEntry(it, packageName)) ids += it.taskId
            }
            TaskShellParserEntries.parseActivitiesDump(output).forEach {
                if (TaskShellParserSupport.matchesEntry(it, packageName)) ids += it.taskId
            }
        }
        return ids.filter(TaskShellParserSupport::isValidTaskId).toList()
    }

    fun findPackageForTaskId(taskId: Int, vararg outputs: String): String? {
        outputs.forEach { output ->
            TaskShellParserEntries.parseCmdTaskList(output).forEach {
                if (it.taskId == taskId && it.packageName.isNotBlank()) return it.packageName
            }
            TaskShellParserEntries.parseRecentsDump(output).forEach {
                if (it.taskId == taskId && it.packageName.isNotBlank()) return it.packageName
            }
            TaskShellParserEntries.parseActivitiesDump(output).forEach {
                if (it.taskId == taskId && it.packageName.isNotBlank()) return it.packageName
            }
        }
        return null
    }

    fun findComponentForTaskId(taskId: Int, vararg outputs: String): String? {
        TaskShellParserTitles.parseTaskTopComponents(*outputs)[taskId]?.let { return it }
        for (output in outputs) {
            var currentTaskId: Int? = null
            for (line in output.lineSequence()) {
                if (line.contains("Task id #") || (line.contains("Task{") && line.contains("#$taskId"))) {
                    TaskShellParserPatterns.TASK_ID_LINE.matcher(line).let { matcher ->
                        if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                    }
                }
                if (line.contains("taskId=")) {
                    val id = line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                    if (id == taskId) currentTaskId = taskId
                }
                if (currentTaskId == taskId || TaskShellParserTitles.parseTaskIdFromActivityLine(line) == taskId) {
                    TaskShellParserTitles.parseComponentFromActivityLine(line)?.let { return it }
                }
            }
        }
        val taskListDump = outputs.firstOrNull().orEmpty()
        var currentTaskId: Int? = null
        for (line in taskListDump.lineSequence()) {
            when {
                line.contains("Task id #") || line.contains("Task{") && line.contains("#$taskId") -> {
                    TaskShellParserPatterns.TASK_ID_LINE.matcher(line).let { matcher ->
                        if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                    }
                    TaskShellParserPatterns.GENERIC_HASH_ID.matcher(line).let { matcher ->
                        if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                    }
                }
                line.contains("taskId=") -> {
                    currentTaskId = line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                }
                currentTaskId == taskId && line.contains("realActivity=") -> {
                    return TaskShellParserTitles.parseComponentFromActivityLine(line)
                }
                currentTaskId == taskId && line.contains("baseIntent=") -> {
                    return TaskShellParserTitles.parseComponentFromActivityLine(line)
                }
                currentTaskId == taskId && line.contains("topActivity=") -> {
                    return TaskShellParserTitles.parseComponentFromActivityLine(line)
                }
            }
        }
        return null
    }

    fun findFrontTask(activitiesDump: String): ShellTaskEntry? {
        for (line in activitiesDump.lineSequence()) {
            if (!line.contains("ResumedActivity") && !line.contains("mResumedActivity") &&
                !line.contains("topResumedActivity")
            ) {
                continue
            }
            val taskId = TaskShellParserTitles.parseTaskIdFromActivityLine(line) ?: continue
            val packageName = TaskShellParserTitles.parsePackageFromActivityLine(line) ?: continue
            if (!TaskShellParserSupport.isValidTaskId(taskId)) continue
            val pkg = packageName.substringBefore('/').trim()
            if (pkg.isEmpty() || pkg in TaskShellParserPatterns.EXCLUDED_PACKAGES) continue
            return ShellTaskEntry(taskId, pkg)
        }
        TaskShellParserPatterns.RESUMED_ACTIVITY.matcher(activitiesDump).let { matcher ->
            if (matcher.find()) {
                val taskId = matcher.group(1)?.toIntOrNull()?.takeIf(TaskShellParserSupport::isValidTaskId)
                    ?: return null
                return ShellTaskEntry(taskId, "")
            }
        }
        return null
    }
}
