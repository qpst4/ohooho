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

        fun widget(appWidgetId: Int, label: String = "") =
            QuickLauncherItem(QuickLauncherItemType.WIDGET, appWidgetId.toString(), label)
    }
}

object QuickLauncherItemCodec {
    private const val SEP = "\u001E"

    fun encode(item: QuickLauncherItem): String =
        listOf(item.type.id, item.payload, item.label).joinToString(SEP)

    fun decode(raw: String): QuickLauncherItem? {
        val parts = raw.split(SEP, limit = 3)
        if (parts.size < 2) return null
        val type = QuickLauncherItemType.fromId(parts[0].toIntOrNull() ?: return null)
        return QuickLauncherItem(type, parts[1], parts.getOrElse(2) { "" })
    }

    fun encodeAll(items: List<QuickLauncherItem>): Set<String> = items.map { encode(it) }.toSet()

    fun decodeAll(raw: Set<String>): List<QuickLauncherItem> =
        raw.mapNotNull { decode(it) }
}
