package com.slideindex.app.gesture

import com.slideindex.app.launcher.QuickLauncherItemCodec

object GestureShortcutPayload {
    private const val COMPONENT_PREFIX = "c:"
    private const val LABEL_SEP = "\u001D"

    sealed class Decoded {
        abstract val label: String

        data class Dynamic(
            val packageName: String,
            val shortcutId: String,
            override val label: String,
        ) : Decoded()

        data class Component(
            val componentFlat: String,
            override val label: String,
        ) : Decoded()
    }

    fun encodeDynamic(packageName: String, shortcutId: String, label: String): String {
        val body = "$packageName${QuickLauncherItemCodec.SHORTCUT_PAYLOAD_SEP}$shortcutId"
        return if (label.isBlank()) body else "$body$LABEL_SEP$label"
    }

    fun encodeComponent(componentFlat: String, label: String): String {
        val body = "$COMPONENT_PREFIX$componentFlat"
        return if (label.isBlank()) body else "$body$LABEL_SEP$label"
    }

    fun decode(payload: String): Decoded? {
        if (payload.isBlank()) return null
        val labelSep = payload.lastIndexOf(LABEL_SEP)
        val (body, label) = if (labelSep >= 0) {
            payload.substring(0, labelSep) to payload.substring(labelSep + 1)
        } else {
            payload to ""
        }
        if (body.startsWith(COMPONENT_PREFIX)) {
            val componentFlat = body.removePrefix(COMPONENT_PREFIX)
            if (componentFlat.isBlank()) return null
            return Decoded.Component(componentFlat, label)
        }
        val dynamic = QuickLauncherItemCodec.parseShortcutPayload(body) ?: return null
        return Decoded.Dynamic(dynamic.first, dynamic.second, label)
    }
}
