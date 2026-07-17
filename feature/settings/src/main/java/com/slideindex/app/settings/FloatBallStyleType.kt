package com.slideindex.app.settings

/** 悬浮球外观样式类型（参考 FooView）。 */
enum class FloatBallStyleType(val storageKey: String) {
    DEFAULT("default"),
    PRESET_1("preset_1"),
    PRESET_2("preset_2"),
    PRESET_3("preset_3"),
    PRESET_4("preset_4"),
    CUSTOM_IMAGE("custom_image"),
    SLIDESHOW("slideshow"),
    GIF("gif"),
    ;

    companion object {
        fun fromStorageKey(key: String?): FloatBallStyleType =
            entries.firstOrNull { it.storageKey == key } ?: DEFAULT
    }
}
