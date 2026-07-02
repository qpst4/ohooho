package com.slideindex.app.launcher

enum class QuickLauncherItemType(val id: Int) {
    APP(0),
    SHORTCUT(1),
    WIDGET(2),
    ;

    companion object {
        fun fromId(id: Int): QuickLauncherItemType =
            entries.firstOrNull { it.id == id } ?: APP
    }
}

data class QuickLauncherItem(
    val type: QuickLauncherItemType,
    val payload: String,
    val label: String = "",
) {
    companion object {
        fun app(packageName: String, label: String = "") =
            QuickLauncherItem(QuickLauncherItemType.APP, packageName, label)

        fun shortcut(componentFlat: String, label: String = "") =
            QuickLauncherItem(QuickLauncherItemType.SHORTCUT, componentFlat, label)

        fun dynamicShortcut(packageName: String, shortcutId: String, label: String = "") =
            QuickLauncherItem(
                QuickLauncherItemType.SHORTCUT,
                "$packageName${QuickLauncherItemCodec.SHORTCUT_PAYLOAD_SEP}$shortcutId",
                label,
            )

        fun widget(appWidgetId: Int, label: String = "") =
            QuickLauncherItem(QuickLauncherItemType.WIDGET, appWidgetId.toString(), label)
    }
}

object QuickLauncherItemCodec {
    private const val SEP = "\u001E"
    private const val LEGACY_FOLDER_TYPE_ID = 3
    const val SHORTCUT_PAYLOAD_SEP = "\u001C"

    fun encode(item: QuickLauncherItem): String =
        listOf(item.type.id, item.payload, item.label).joinToString(SEP)

    fun decode(raw: String): QuickLauncherItem? {
        val firstSep = raw.indexOf(SEP)
        if (firstSep <= 0) return null
        val typeId = raw.substring(0, firstSep).toIntOrNull() ?: return null
        if (typeId == LEGACY_FOLDER_TYPE_ID) return null
        val type = QuickLauncherItemType.fromId(typeId)
        val lastSep = raw.lastIndexOf(SEP)
        if (lastSep <= firstSep) return null
        val payload = raw.substring(firstSep + 1, lastSep)
        val label = raw.substring(lastSep + 1)
        return QuickLauncherItem(type, payload, label)
    }

    fun parseShortcutPayload(payload: String): Pair<String, String>? {
        val index = payload.indexOf(SHORTCUT_PAYLOAD_SEP)
        if (index <= 0 || index >= payload.lastIndex) return null
        val packageName = payload.substring(0, index)
        val shortcutId = payload.substring(index + 1)
        if (packageName.isBlank() || shortcutId.isBlank()) return null
        return packageName to shortcutId
    }

    fun shortcutKey(packageName: String, shortcutId: String): String =
        "$packageName$SHORTCUT_PAYLOAD_SEP$shortcutId"

    private const val LIST_SEP = "\u001F"

    fun encodeAll(items: List<QuickLauncherItem>): Set<String> =
        if (items.isEmpty()) emptySet() else setOf(items.joinToString(LIST_SEP) { encode(it) })

    fun decodeAll(raw: Set<String>): List<QuickLauncherItem> {
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
}
