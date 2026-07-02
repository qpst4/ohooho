package com.slideindex.app.shell

import java.util.UUID

data class ShellCommand(
    val id: String = UUID.randomUUID().toString(),
    val label: String,
    val command: String,
)

object ShellCommandCodec {
    private const val SEP = "\u001E"
    private const val LIST_SEP = "\u001F"
    private const val SYSTEM_SH = "/system/bin/sh"
    private const val SYSTEM_SU = "/system/bin/su"

    fun encode(item: ShellCommand): String =
        listOf(item.id, item.label, item.command).joinToString(SEP)

    fun decode(raw: String): ShellCommand? {
        val firstSep = raw.indexOf(SEP)
        if (firstSep <= 0) return null
        val id = raw.substring(0, firstSep)
        val secondSep = raw.indexOf(SEP, firstSep + 1)
        if (secondSep <= firstSep) return null
        val label = raw.substring(firstSep + 1, secondSep)
        val thirdSep = raw.indexOf(SEP, secondSep + 1)
        val command = if (thirdSep <= secondSep) {
            raw.substring(secondSep + 1)
        } else {
            raw.substring(secondSep + 1, thirdSep)
        }
        if (label.isBlank() || command.isBlank()) return null
        return ShellCommand(id, label, command)
    }

    fun encodeAll(items: List<ShellCommand>): Set<String> =
        if (items.isEmpty()) {
            emptySet()
        } else {
            setOf(items.joinToString(LIST_SEP) { encode(it) })
        }

    fun decodeAll(raw: Set<String>): List<ShellCommand> {
        if (raw.isEmpty()) return emptyList()
        val decoded = if (raw.size == 1) {
            val only = raw.first()
            if (LIST_SEP in only) {
                only.split(LIST_SEP).mapNotNull { decode(it) }
            } else {
                listOfNotNull(decode(only))
            }
        } else {
            raw.mapNotNull { decode(it) }
        }
        return decoded
    }

    fun buildExecArgs(commandLine: String, useRoot: Boolean): Array<String> {
        val trimmed = commandLine.trim()
        require(trimmed.isNotEmpty()) { "Empty command" }
        return if (useRoot) {
            arrayOf(SYSTEM_SH, "-c", "${resolveSuInvocation()} -c ${shellQuote(trimmed)}")
        } else {
            arrayOf(SYSTEM_SH, "-c", trimmed)
        }
    }

    private fun resolveSuInvocation(): String {
        val candidates = listOf(
            "/sbin/su",
            "/system/xbin/su",
            SYSTEM_SU,
            "/vendor/bin/su",
            "/debug_ramdisk/su",
            "/data/adb/magisk/magisk",
        )
        return candidates.firstOrNull { java.io.File(it).exists() } ?: "su"
    }

    private fun shellQuote(command: String): String =
        "'" + command.replace("'", "'\\''") + "'"
}
