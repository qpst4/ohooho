package com.slideindex.app.shizuku

import com.slideindex.app.util.TaskExclusions
import java.util.regex.Pattern

internal data class ShellTaskEntry(
    val taskId: Int,
    val packageName: String,
)

internal object TaskShellParser {

    private val RECENT_TASK_LINE = Pattern.compile(
        "Recent #\\d+: Task(?:Record)?\\{[^#]*#(\\d+)\\s[^}]*A=(?:\\d+:)?([^\\s}/]+)",
    )
    private val TASK_ID_LINE = Pattern.compile("Task id #(\\d+)")
    private val PACKAGE_NAME_FIELD = Pattern.compile("(?:packageName|realActivity|baseActivity)=([\\w.]+)")
    private val RESUMED_ACTIVITY = Pattern.compile(
        "(?:mResumedActivity|ResumedActivity|topResumedActivity)[^\\n]*\\bt(\\d+)\\b",
    )
    private val GENERIC_TASK_ID = Pattern.compile("\\bt(\\d+)\\b")
    private val GENERIC_HASH_ID = Pattern.compile("#(\\d+)")

    private val EXCLUDED_PACKAGES = TaskExclusions.LAUNCHER_AND_SYSTEM

    fun parseRecentsDump(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        for (line in output.lineSequence()) {
            RECENT_TASK_LINE.matcher(line).let { matcher ->
                if (matcher.find()) {
                    addEntry(entries, matcher.group(1)?.toIntOrNull(), matcher.group(2)?.trim())
                }
            }
        }
        return entries
    }

    fun parseCmdTaskList(output: String): List<ShellTaskEntry> {
        val entries = mutableListOf<ShellTaskEntry>()
        var currentTaskId: Int? = null
        for (line in output.lineSequence()) {
            when {
                line.contains("taskId=") -> {
                    currentTaskId = line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                }
                line.contains("id=") && line.trimStart().startsWith("id=") -> {
                    currentTaskId = line.substringAfter("id=").substringBefore(' ').toIntOrNull()
                }
                currentTaskId != null && (line.contains("realActivity=") || line.contains("baseIntent=")) -> {
                    parsePackageFromActivityLine(line)?.let { pkg ->
                        addEntry(entries, currentTaskId, pkg)
                    }
                    currentTaskId = null
                }
            }
        }
        return entries
    }

    fun findTaskIdsForPackage(packageName: String, vararg outputs: String): List<Int> {
        val ids = linkedSetOf<Int>()
        outputs.forEach { output ->
            parseRecentsDump(output).forEach { if (it.packageName == packageName) ids += it.taskId }
            parseCmdTaskList(output).forEach { if (it.packageName == packageName) ids += it.taskId }
        }
        return ids.filter(::isValidTaskId).toList()
    }

    fun listRecentPackages(vararg outputs: String): List<String> {
        val packages = LinkedHashSet<String>()
        outputs.forEach { output ->
            parseRecentsDump(output).forEach { packages += it.packageName }
            parseCmdTaskList(output).forEach { packages += it.packageName }
            parseAmStackList(output).forEach { packages += it.packageName }
        }
        packages.removeAll(EXCLUDED_PACKAGES)
        return packages.toList()
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
                    parsePackageFromActivityLine(line)?.let { pkg ->
                        addEntry(entries, currentTaskId, pkg)
                    }
                    currentTaskId = null
                }
            }
        }
        return entries
    }

    fun findFrontTask(activitiesDump: String): ShellTaskEntry? {
        for (line in activitiesDump.lineSequence()) {
            if (!line.contains("ResumedActivity") && !line.contains("mResumedActivity") &&
                !line.contains("topResumedActivity")
            ) {
                continue
            }
            val taskId = parseTaskIdFromActivityLine(line) ?: continue
            val packageName = parsePackageFromActivityLine(line) ?: continue
            if (!isValidTaskId(taskId)) continue
            val pkg = packageName.substringBefore('/').trim()
            if (pkg.isEmpty() || pkg in EXCLUDED_PACKAGES) continue
            return ShellTaskEntry(taskId, pkg)
        }
        RESUMED_ACTIVITY.matcher(activitiesDump).let { matcher ->
            if (matcher.find()) {
                val taskId = matcher.group(1)?.toIntOrNull()?.takeIf(::isValidTaskId) ?: return null
                return ShellTaskEntry(taskId, "")
            }
        }
        return null
    }

    fun findPackageForTaskId(taskId: Int, vararg outputs: String): String? {
        outputs.forEach { output ->
            parseCmdTaskList(output).forEach {
                if (it.taskId == taskId && it.packageName.isNotBlank()) return it.packageName
            }
            parseRecentsDump(output).forEach {
                if (it.taskId == taskId && it.packageName.isNotBlank()) return it.packageName
            }
        }
        return null
    }

    fun findComponentForTaskId(taskId: Int, taskListDump: String): String? {
        var currentTaskId: Int? = null
        for (line in taskListDump.lineSequence()) {
            when {
                line.contains("Task id #") || line.contains("Task{") && line.contains("#$taskId") -> {
                    TASK_ID_LINE.matcher(line).let { matcher ->
                        if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                    }
                    GENERIC_HASH_ID.matcher(line).let { matcher ->
                        if (matcher.find()) currentTaskId = matcher.group(1)?.toIntOrNull()
                    }
                }
                line.contains("taskId=") -> {
                    currentTaskId = line.substringAfter("taskId=").substringBefore(' ').toIntOrNull()
                }
                currentTaskId == taskId && line.contains("realActivity=") -> {
                    return parseComponentFromActivityLine(line)
                }
                currentTaskId == taskId && line.contains("baseIntent=") -> {
                    return parseComponentFromActivityLine(line)
                }
            }
        }
        return null
    }

    private fun addEntry(entries: MutableList<ShellTaskEntry>, taskId: Int?, packageName: String?) {
        val id = taskId ?: return
        val pkg = packageName?.substringBefore('/')?.trim().orEmpty()
        if (pkg.isEmpty() || !isValidTaskId(id) || pkg in EXCLUDED_PACKAGES) return
        entries += ShellTaskEntry(id, pkg)
    }

    private fun parseTaskIdFromActivityLine(line: String): Int? {
        GENERIC_TASK_ID.matcher(line).let { matcher ->
            if (matcher.find()) return matcher.group(1)?.toIntOrNull()
        }
        GENERIC_HASH_ID.matcher(line).let { matcher ->
            if (matcher.find()) return matcher.group(1)?.toIntOrNull()
        }
        return null
    }

    private fun parsePackageFromActivityLine(line: String): String? {
        return parseComponentFromActivityLine(line)?.substringBefore('/')?.trim()?.takeIf { it.isNotEmpty() }
    }

    private fun parseComponentFromActivityLine(line: String): String? {
        val uIndex = line.indexOf(" u0 ")
        if (uIndex >= 0) {
            val segment = line.substring(uIndex + 4)
            val end = segment.indexOfFirst { it == ' ' || it == '}' }
            val component = if (end > 0) segment.substring(0, end) else segment
            if (component.contains('/')) return component.trim()
        }
        val componentIndex = line.indexOf("ComponentInfo{")
        if (componentIndex >= 0) {
            val segment = line.substring(componentIndex + 15)
            val end = segment.indexOf('}')
            val component = if (end > 0) segment.substring(0, end) else segment
            if (component.contains('/')) return component.trim()
        }
        PACKAGE_NAME_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                return matcher.group(1)?.substringBefore('/')?.trim()
            }
        }
        return null
    }

    private fun isValidTaskId(taskId: Int): Boolean = taskId > 0
}
