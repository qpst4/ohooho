package com.slideindex.app.shell

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ShellTemplateContext(
    val foregroundPackage: String? = null,
    val timestampMs: Long = System.currentTimeMillis(),
) {
    val dateTime: String
        get() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date(timestampMs))
}

object ShellCommandTemplate {
    private val VARIABLES = listOf(
        "{package}" to { ctx: ShellTemplateContext -> ctx.foregroundPackage.orEmpty() },
        "{foreground_package}" to { ctx: ShellTemplateContext -> ctx.foregroundPackage.orEmpty() },
        "{timestamp}" to { ctx: ShellTemplateContext -> ctx.timestampMs.toString() },
        "{datetime}" to { ctx: ShellTemplateContext -> ctx.dateTime },
    )

    fun expand(command: String, context: ShellTemplateContext = ShellTemplateContext()): String {
        var expanded = command
        VARIABLES.forEach { (token, resolver) ->
            if (token in expanded) {
                expanded = expanded.replace(token, resolver(context))
            }
        }
        return expanded
    }

    val supportedVariables: List<String> = VARIABLES.map { it.first }
}
