package com.slideindex.app.shizuku

import com.slideindex.app.util.RecentPackageResolver

internal object TaskShellParserSupport {

    fun isValidTaskId(taskId: Int): Boolean = taskId > 0

    fun isLikelyPackage(pkg: String): Boolean =
        pkg.contains('.') && !pkg.startsWith('.')

    fun matchesEntry(entry: ShellTaskEntry, packageName: String): Boolean {
        return RecentPackageResolver.matches(entry.rawIdentifier, packageName) ||
            RecentPackageResolver.matches(entry.packageName, packageName)
    }

    fun matchesIdentifier(entry: ShellTaskEntry, identifier: String): Boolean {
        val raw = identifier.trim()
        if (raw.isEmpty()) return false
        return matchesEntry(entry, raw) || entry.rawIdentifier == raw
    }

    fun shouldIncludeRecentEntry(entry: ShellTaskEntry): Boolean {
        if (entry.packageName in TaskShellParserPatterns.EXCLUDED_PACKAGES) return false
        if (shouldExcludeRawIdentifier(entry.rawIdentifier)) return false
        return isLikelyPackage(entry.packageName)
    }

    fun mergeTaskEntries(existing: ShellTaskEntry, incoming: ShellTaskEntry): ShellTaskEntry {
        return ShellTaskEntry(
            taskId = existing.taskId,
            packageName = incoming.packageName.ifBlank { existing.packageName },
            rawIdentifier = TaskShellParserTitles.preferRawIdentifier(existing.rawIdentifier, incoming.rawIdentifier),
            taskTitle = TaskShellParserTitles.preferNonBlank(existing.taskTitle, incoming.taskTitle),
        )
    }

    fun putOrMergeEntry(
        ordered: LinkedHashMap<Int, ShellTaskEntry>,
        entry: ShellTaskEntry,
    ) {
        val existing = ordered[entry.taskId]
        ordered[entry.taskId] = if (existing == null) entry else mergeTaskEntries(existing, entry)
    }

    fun enrichFromCmd(entry: ShellTaskEntry, cmd: ShellTaskEntry?): ShellTaskEntry {
        if (cmd == null) return entry
        return mergeTaskEntries(entry, cmd)
    }

    fun extractPackageFromLine(line: String): String? {
        return packageFromRawIdentifier(extractRawIdentifierFromLine(line))
    }

    fun extractRawIdentifierFromRecentLine(line: String): String? {
        TaskShellParserPatterns.RECENT_COMPONENT_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                return matcher.group(1)?.trim()?.takeIf { it.isNotEmpty() }
            }
        }
        TaskShellParserPatterns.RECENT_A_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                return matcher.group(1)?.trim()?.takeIf { it.isNotEmpty() }
            }
        }
        return extractRawIdentifierFromLine(line)
    }

    fun extractRawIdentifierFromLine(line: String): String? {
        TaskShellParserTitles.parseComponentFromActivityLine(line)?.let { return it.trim() }
        TaskShellParserPatterns.CMP_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                val pkg = matcher.group(1)?.trim().orEmpty()
                if (pkg.isNotEmpty() && line.contains('/')) {
                    val cls = line.substringAfter("$pkg/").substringBefore(' ').substringBefore('}')
                        .trim()
                    if (cls.isNotEmpty()) return "$pkg/$cls"
                }
            }
        }
        TaskShellParserPatterns.PACKAGE_NAME_FIELD.matcher(line).let { matcher ->
            if (matcher.find()) {
                return matcher.group(1)?.trim()?.takeIf { it.isNotEmpty() }
            }
        }
        return null
    }

    fun extractPackageFromRecentLine(line: String): String? {
        return packageFromRawIdentifier(extractRawIdentifierFromRecentLine(line))
    }

    fun packageFromRawIdentifier(raw: String?): String? {
        val component = raw?.trim().orEmpty()
        if (component.isEmpty()) return null
        val normalized = RecentPackageResolver.normalizeIdentifier(component)
        return normalized.takeIf { isLikelyPackage(it) }
    }

    fun addEntry(
        entries: MutableList<ShellTaskEntry>,
        taskId: Int?,
        packageName: String?,
        taskTitle: String? = null,
    ) {
        val id = taskId ?: return
        val raw = packageName?.trim().orEmpty()
        if (raw.isEmpty() || shouldExcludeRawIdentifier(raw)) return
        val normalized = packageFromRawIdentifier(raw) ?: return
        if (!isValidTaskId(id) || normalized in TaskShellParserPatterns.EXCLUDED_PACKAGES) return
        entries += ShellTaskEntry(
            taskId = id,
            packageName = normalized,
            rawIdentifier = raw,
            taskTitle = TaskShellParserTitles.cleanTaskTitle(taskTitle),
        )
    }

    private fun shouldExcludeRawIdentifier(raw: String): Boolean {
        val lower = raw.lowercase()
        return lower.contains("fallbackhome")
    }
}
