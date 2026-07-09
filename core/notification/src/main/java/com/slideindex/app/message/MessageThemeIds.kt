package com.slideindex.app.message

object MessageThemeIds {
    private const val DEFAULT_CARD_THEME_ID = "card_book"
    private const val DEFAULT_SIDE_THEME_ID = "side_message"
    private const val DEFAULT_DANMAKU_THEME_ID = "danmaku"

    private val legacyThemeIds = mapOf(
        "default_dark" to DEFAULT_CARD_THEME_ID,
        "light_card" to "pure_text",
        "default_danmaku" to DEFAULT_DANMAKU_THEME_ID,
        "default_side" to DEFAULT_SIDE_THEME_ID,
        "light_side" to DEFAULT_SIDE_THEME_ID,
    )

    fun normalizeThemeId(themeId: String): String = legacyThemeIds[themeId] ?: themeId

    fun defaultThemeIdFor(style: MessageStyle): String = when (style) {
        MessageStyle.Danmaku -> DEFAULT_DANMAKU_THEME_ID
        MessageStyle.SideBubble -> DEFAULT_SIDE_THEME_ID
        else -> DEFAULT_CARD_THEME_ID
    }
}
