package com.slideindex.app.message



import com.slideindex.app.R



object MessageThemeCatalog {

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



    private val cardThemes = listOf(

        cardTheme(

            id = "card_black",

            labelRes = R.string.message_theme_pure_black,

            backgroundResId = R.drawable.bg_menu_white,

            titleColor = "#F5F5F5",

            backgroundTintArgb = 0xFF000000.toInt(),

            backgroundAlpha = 180,

        ),

        cardTheme(

            id = "miui",

            labelRes = R.string.message_theme_miui,

            backgroundResId = R.drawable.bg_message_miui,

        ),

        cardTheme(

            id = "cool_black",

            labelRes = R.string.message_theme_cool_black,

            backgroundResId = R.drawable.bg_message_cool_black,

            titleColor = "#F5F5F5",

        ),

        cardTheme(

            id = "green_mountains",

            labelRes = R.string.message_theme_green_mountain,

            backgroundResId = R.drawable.bg_message_card_green_mountains,

        ),

        cardTheme(

            id = "pure_text",

            labelRes = R.string.message_theme_pure_text,

            backgroundResId = R.drawable.bg_message_card_pure_text,

        ),

        cardTheme(

            id = "summer_watermelon",

            labelRes = R.string.message_theme_watermelon,

            backgroundResId = R.drawable.bg_message_watermelon,

        ),

        cardTheme(

            id = "summer_water",

            labelRes = R.string.message_theme_summer_water,

            backgroundResId = R.drawable.bg_message_water,

        ),

        cardTheme(

            id = DEFAULT_CARD_THEME_ID,

            labelRes = R.string.message_theme_book_page,

            backgroundResId = R.drawable.bg_message_card_book,

        ),

        cardTheme(

            id = "card_luzi",

            labelRes = R.string.message_theme_stove,

            backgroundResId = R.drawable.bg_message_card_luzi,

            titleColor = "#B15722",

        ),

        cardTheme(

            id = "card_cat",

            labelRes = R.string.message_theme_cat,

            backgroundResId = R.drawable.bg_message_card_cat,

            titleColor = "#39496A",

        ),

        cardTheme(

            id = "card_dialog_box",

            labelRes = R.string.message_theme_dialog,

            backgroundResId = R.drawable.bg_message_card_dialog_box,

        ),

    )



    private val sideThemes = listOf(

        sideTheme(

            id = DEFAULT_SIDE_THEME_ID,

            labelRes = R.string.message_theme_default_side,

            sideLeftResId = R.drawable.bg_arc_left,

            sideRightResId = R.drawable.bg_arc_right,

        ),

        sideTheme(

            id = "side_message_black",

            labelRes = R.string.message_theme_black_side,

            sideLeftResId = R.drawable.bg_arc_black_left,

            sideRightResId = R.drawable.bg_arc_black_right,

            titleColor = "#FFFFFF",

        ),

        sideTheme(

            id = "side_message_book",

            labelRes = R.string.message_theme_book_side,

            sideLeftResId = R.drawable.bg_message_side_message_book_left,

            sideRightResId = R.drawable.bg_message_side_message_book_right,

        ),

        sideTheme(

            id = "side_message_luzi",

            labelRes = R.string.message_theme_stove_side,

            sideLeftResId = R.drawable.bg_message_side_message_luzi_left,

            sideRightResId = R.drawable.bg_message_side_message_luzi_right,

            titleColor = "#B15722",

        ),

        sideTheme(

            id = "side_message_cat",

            labelRes = R.string.message_theme_cat_side,

            sideLeftResId = R.drawable.bg_message_side_message_cat_left,

            sideRightResId = R.drawable.bg_message_side_message_cat_right,

            titleColor = "#39496A",

        ),

        sideTheme(

            id = "side_message_dialog_box",

            labelRes = R.string.message_theme_dialog_side,

            sideLeftResId = R.drawable.bg_message_side_message_dialog_box_left,

            sideRightResId = R.drawable.bg_message_side_message_dialog_box_right,

        ),

    ) + WeipopSideThemes.themes()



    private val danmakuThemes = listOf(

        danmakuTheme(

            id = DEFAULT_DANMAKU_THEME_ID,

            labelRes = R.string.message_theme_default_barrage,

            backgroundResId = R.drawable.bg_danmaku,

        ),

        danmakuTheme(

            id = "danmaku_dark",

            labelRes = R.string.message_theme_dark_barrage,

            backgroundResId = R.drawable.bg_danmaku,

            titleColor = "#F5F5F5",

            backgroundTintArgb = 0xFF101010.toInt(),

            backgroundAlpha = 230,

        ),

        danmakuTheme(

            id = "danmaku_book",

            labelRes = R.string.message_theme_book_barrage,

            backgroundResId = R.drawable.bg_message_card_book,

            avatarTranslationYDp = 1,

        ),

        danmakuTheme(

            id = "danmaku_luzi",

            labelRes = R.string.message_theme_stove_barrage,

            backgroundResId = R.drawable.bg_message_card_luzi,

            titleColor = "#B15722",

            avatarTranslationYDp = 4,

        ),

        danmakuTheme(

            id = "danmaku_cat",

            labelRes = R.string.message_theme_cat_barrage,

            backgroundResId = R.drawable.bg_message_danmaku_message_cat,

            titleColor = "#39496A",

            avatarTranslationYDp = 4,

        ),

        danmakuTheme(

            id = "danmaku_dialog_box",

            labelRes = R.string.message_theme_dialog_barrage,

            backgroundResId = R.drawable.bg_message_card_dialog_box,

            avatarTranslationYDp = 3,

        ),

    )



    fun findTheme(themeId: String): MessageThemeSpec? {
        val normalizedId = normalizeThemeId(themeId)
        return (cardThemes + sideThemes + danmakuThemes).firstOrNull { it.id == normalizedId }
    }

    fun normalizeThemeId(themeId: String): String = legacyThemeIds[themeId] ?: themeId



    fun themeFor(style: MessageStyle, themeId: String): MessageThemeSpec {

        val normalizedId = normalizeThemeId(themeId)

        return themesFor(style).firstOrNull { it.id == normalizedId }

            ?: themesFor(style).first()

    }



    fun themesFor(style: MessageStyle): List<MessageThemeSpec> = when (style) {

        MessageStyle.Danmaku -> danmakuThemes

        MessageStyle.SideBubble -> sideThemes

        MessageStyle.DarkCard -> cardThemes

        else -> cardThemes

    }



    fun defaultThemeIdFor(style: MessageStyle): String = when (style) {

        MessageStyle.Danmaku -> DEFAULT_DANMAKU_THEME_ID

        MessageStyle.SideBubble -> DEFAULT_SIDE_THEME_ID

        else -> DEFAULT_CARD_THEME_ID

    }



    private fun cardTheme(

        id: String,

        labelRes: Int,

        backgroundResId: Int,

        titleColor: String = "#474747",

        backgroundTintArgb: Int? = null,

        backgroundAlpha: Int = 255,

    ): MessageThemeSpec {

        val titleArgb = MessageThemeColors.parseHex(titleColor)

        return MessageThemeSpec(

            id = id,

            style = MessageStyle.DarkCard,

            labelRes = labelRes,

            backgroundResId = backgroundResId,

            titleColorArgb = titleArgb,

            contentColorArgb = MessageThemeColors.contentColor(titleArgb),

            cornerRadiusDp = 14f,

            paddingHorizontalDp = 12f,

            avatarStartPaddingDp = 10f,

            backgroundTintArgb = backgroundTintArgb,

            backgroundAlpha = backgroundAlpha,

        )

    }



    private fun sideTheme(

        id: String,

        labelRes: Int,

        sideLeftResId: Int,

        sideRightResId: Int,

        titleColor: String = "#474747",

    ): MessageThemeSpec {

        val titleArgb = MessageThemeColors.parseHex(titleColor)

        return MessageThemeSpec(

            id = id,

            style = MessageStyle.SideBubble,

            labelRes = labelRes,

            backgroundResId = sideRightResId,

            sideLeftResId = sideLeftResId,

            sideRightResId = sideRightResId,

            titleColorArgb = titleArgb,

            contentColorArgb = MessageThemeColors.contentColor(titleArgb),

            cornerRadiusDp = 18f,

            paddingHorizontalDp = 12f,

            paddingVerticalDp = 8f,

            avatarStartPaddingDp = 8f,

        )

    }



    private fun danmakuTheme(

        id: String,

        labelRes: Int,

        backgroundResId: Int,

        titleColor: String = "#474747",

        backgroundTintArgb: Int? = null,

        backgroundAlpha: Int = 255,

        avatarTranslationYDp: Int = 0,

    ): MessageThemeSpec {

        val titleArgb = MessageThemeColors.parseHex(titleColor)

        return MessageThemeSpec(

            id = id,

            style = MessageStyle.Danmaku,

            labelRes = labelRes,

            backgroundResId = backgroundResId,

            titleColorArgb = titleArgb,

            contentColorArgb = MessageThemeColors.contentColor(titleArgb),

            cornerRadiusDp = 20f,

            paddingHorizontalDp = 10f,

            paddingVerticalDp = 6f,

            backgroundTintArgb = backgroundTintArgb,

            backgroundAlpha = backgroundAlpha,

            avatarTranslationYDp = avatarTranslationYDp,

        )

    }

}


