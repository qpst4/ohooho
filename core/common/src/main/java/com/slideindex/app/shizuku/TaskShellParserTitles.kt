package com.slideindex.app.shizuku

internal object TaskShellParserTitles {

    fun parseTaskTitles(vararg sources: String): Map<Int, String> {
        val out = linkedMapOf<Int, String>()
        sources.forEach { source ->
            if (source.isBlank()) return@forEach
            parseTaskBlockTitles(source, out)
            parseWindowTitles(source, out)
            parseProximityTitles(source, out)
        }
        return out
    }

    fun parseTaskTopComponents(vararg sources: String): Map<Int, String> {
        val perTask = linkedMapOf<Int, MutableList<String>>()
        sources.forEach { source ->
            if (source.isBlank()) return@forEach
            collectActivityRecordComponents(source, perTask)
            collectTopActivityLines(source, perTask)
            collectRealActivityFields(source, perTask)
        }
        return perTask.mapValues { (_, components) -> components.last() }
    }

    fun enrichTaskEntry(
        entry: ShellTaskEntry,
        titleMap: Map<Int, String>,
        componentMap: Map<Int, String>,
    ): ShellTaskEntry {
        val component = componentMap[entry.taskId]
        return ShellTaskEntry(
            taskId = entry.taskId,
            packageName = entry.packageName,
            rawIdentifier = if (component != null) {
                preferRawIdentifier(component, entry.rawIdentifier)
            } else {
                entry.rawIdentifier
            },
            taskTitle = preferNonBlank(entry.taskTitle, titleMap[entry.taskId]),
        )
    }

    fun preferNonBlank(current: String?, incoming: String?): String? {
        return current?.takeIf { it.isNotBlank() } ?: incoming?.takeIf { it.isNotBlank() }
    }

    fun preferRawIdentifier(current: String, incoming: String): String {
        if (incoming.contains('/') && !current.contains('/')) return incoming
        if (incoming.count { it == '.' } > current.count { it == '.' }) return incoming
        if (incoming.length > current.length) return incoming
        return current
    }

    fun extractTitleFromLine(line: String): String? {
        listOf(
            TaskShellParserPatterns.TASK_DESC_LABEL,
            TaskShellParserPatterns.TASK_DESC_LABEL_PLAIN,
            TaskShellParserPatterns.TASK_DESC_LABEL_CN,
            TaskShellParserPatterns.TASK_DESC_LABEL_CN_PLAIN,
            TaskShellParserPatterns.TASK_TITLE_QUOTED,
            TaskShellParserPatterns.TASK_TITLE_PLAIN,
        ).forEach { pattern ->
            pattern.matcher(line).let { matcher ->
                if (matcher.find()) {
                    return cleanTaskTitle(matcher.group(1))
                }
            }
        }
        return null
    }

    fun cleanTaskTitle(raw: String?): String? {
        val title = raw?.trim()?.trim('"').orEmpty()
            .substringBefore(" icon=")
            .substringBefore(" primaryColor=")
            .trim()
        if (title.isEmpty() || title.equals("null", ignoreCase = true)) return null
        return title
    }

    fun parseTaskIdFromActivityLine(line: String): Int? {
        TaskShellParserPatterns.GENERIC_TASK_ID.matcher(line).let { matcher ->
            if (matcher.find()) return matcher.group(1)?.toIntOrNull()
        }
        TaskShellParserPatterns.GENERIC_HASH_ID.matcher(line).let { matcher ->
            if (matcher.find()) return matcher.group(1)?.toIntOrNull()
        }
        return null
    }

    fun parsePackageFromActivityLine(line: String): String? {
        return parseComponentFromActivityLine(line)?.substringBefore('/')?.trim()?.takeIf { it.isNotEmpty() }
    }

    fun parseComponentFromActivityLine(line: String): String? {
        val uIndex = line.indexOf(" u0 ")
        if (uIndex >= 0) {
            val segment = line.substring(uIndex + 4)
            val end = segment.indexOfFirst { it == ' ' || it == '}' }
            val component = if (end > 0) segment.substring(0, end) else segment
            if (component.contains('/')) return component.trim()
        }
        val componentIndex = line.indexOf("ComponentInfo{")
        if (componentIndex >= 0) {
            val segment = line.substring(componentIndex + "ComponentInfo{".length)
            val end = segment.indexOf('}')
            val component = if (end > 0) segment.substring(0, end) else segment
            if (component.contains('/')) return component.trim()
        }
        TaskShellParserPatterns.PACKAGE_NAME_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                return matcher.group(1)?.substringBefore('/')?.trim()
            }
        }
        return null
    }

    private fun parseTaskBlockTitles(source: String, out: MutableMap<Int, String>) {
        var currentTaskId: Int? = null
        for (line in source.lineSequence()) {
            TaskShellParserPatterns.RECENT_TASK_ID.matcher(line).let { matcher ->
                if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
            }
            TaskShellParserPatterns.TASK_ID_LINE.matcher(line).let { matcher ->
                if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
            }
            if (line.contains("Task{") || line.contains("TaskRecord{")) {
                TaskShellParserPatterns.GENERIC_HASH_ID.matcher(line).let { matcher ->
                    if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                }
            }
            TaskShellParserPatterns.M_LAST_TASK_DESC.matcher(line).let { matcher ->
                if (matcher.find()) {
                    val title = cleanTaskTitle(matcher.group(1)) ?: return@let
                    val taskId = currentTaskId ?: parseTaskIdFromActivityLine(line) ?: return@let
                    out.putIfAbsent(taskId, title)
                }
            }
            extractTitleFromLine(line)?.let { title ->
                val taskId = currentTaskId ?: parseTaskIdFromActivityLine(line) ?: return@let
                out.putIfAbsent(taskId, title)
            }
        }
    }

    private fun parseWindowTitles(source: String, out: MutableMap<Int, String>) {
        if (!source.contains("Window #") && !source.contains("mWindowAttributes")) return
        var currentTaskId: Int? = null
        for (line in source.lineSequence()) {
            if (line.contains("taskId=")) {
                currentTaskId = TaskShellParserPatterns.TASK_ID_FIELD.matcher(line).let { matcher ->
                    if (matcher.find()) matcher.group(1)?.toIntOrNull() else null
                } ?: line.substringAfter("taskId=").substringBefore(' ').substringBefore('}').toIntOrNull()
            }
            TaskShellParserPatterns.TASK_TITLE_PLAIN.matcher(line).let { matcher ->
                if (matcher.find()) {
                    val title = cleanTaskTitle(matcher.group(1)) ?: return@let
                    val taskId = currentTaskId ?: return@let
                    if (title.length in 2..40) out.putIfAbsent(taskId, title)
                }
            }
        }
    }

    private fun parseProximityTitles(source: String, out: MutableMap<Int, String>) {
        TaskShellParserPatterns.GENERIC_TASK_ID.matcher(source).let { matcher ->
            while (matcher.find()) {
                val taskId = matcher.group(1)?.toIntOrNull() ?: continue
                if (out.containsKey(taskId)) continue
                val start = (matcher.start() - 120).coerceAtLeast(0)
                val end = (matcher.end() + 900).coerceAtMost(source.length)
                val window = source.substring(start, end)
                extractFirstTitleFromText(window)?.let { title ->
                    out.putIfAbsent(taskId, title)
                }
            }
        }
    }

    private fun extractFirstTitleFromText(text: String): String? {
        TaskShellParserPatterns.M_LAST_TASK_DESC.matcher(text).let { matcher ->
            if (matcher.find()) return cleanTaskTitle(matcher.group(1))
        }
        for (line in text.lineSequence()) {
            extractTitleFromLine(line)?.let { return it }
        }
        return null
    }

    private fun collectActivityRecordComponents(source: String, perTask: MutableMap<Int, MutableList<String>>) {
        listOf(
            TaskShellParserPatterns.ACTIVITY_RECORD_COMPONENT,
            TaskShellParserPatterns.HIST_ACTIVITY_COMPONENT,
        ).forEach { pattern ->
            pattern.matcher(source).let { matcher ->
                while (matcher.find()) {
                    val component = matcher.group(1)?.trim().orEmpty()
                    val taskId = matcher.group(2)?.toIntOrNull() ?: continue
                    if (component.contains('/')) {
                        perTask.getOrPut(taskId) { mutableListOf() }.add(component)
                    }
                }
            }
        }
    }

    private fun collectTopActivityLines(source: String, perTask: MutableMap<Int, MutableList<String>>) {
        var currentTaskId: Int? = null
        for (line in source.lineSequence()) {
            TaskShellParserPatterns.TASK_ID_LINE.matcher(line).let { matcher ->
                if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
            }
            if (!TaskShellParserPatterns.TOP_ACTIVITY_FIELD.matcher(line).find()) continue
            val component = parseComponentFromActivityLine(line) ?: continue
            val taskId = parseTaskIdFromActivityLine(line) ?: currentTaskId ?: continue
            perTask.getOrPut(taskId) { mutableListOf() }.add(component)
        }
    }

    private fun collectRealActivityFields(source: String, perTask: MutableMap<Int, MutableList<String>>) {
        var currentTaskId: Int? = null
        for (line in source.lineSequence()) {
            TaskShellParserPatterns.TASK_ID_LINE.matcher(line).let { matcher ->
                if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
            }
            if (line.contains("Task{") || line.contains("TaskRecord{")) {
                TaskShellParserPatterns.GENERIC_HASH_ID.matcher(line).let { matcher ->
                    if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                }
            }
            TaskShellParserPatterns.REAL_ACTIVITY_FIELD.matcher(line).let { matcher ->
                if (!matcher.find()) return@let
                val component = matcher.group(1)?.trim().orEmpty()
                if (!component.contains('/')) return@let
                val taskId = currentTaskId ?: parseTaskIdFromActivityLine(line) ?: return@let
                perTask.getOrPut(taskId) { mutableListOf() }.add(component)
            }
        }
    }
}
