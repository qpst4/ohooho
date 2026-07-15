package com.slideindex.app.settings

enum class FloatBallPositionMode(val storageKey: String) {
    LEFT("left"),
    RIGHT("right"),
    BOTH_EDGES("both_edges"),
    CUSTOM("custom"),
    ;

    companion object {
        fun fromStorageKey(key: String?): FloatBallPositionMode =
            entries.firstOrNull { it.storageKey == key } ?: RIGHT
    }
}

enum class FloatBallSide(val storageKey: String) {
    LEFT("left"),
    RIGHT("right"),
    ;

    companion object {
        fun fromStorageKey(key: String?): FloatBallSide =
            entries.firstOrNull { it.storageKey == key } ?: RIGHT

        fun opposite(side: FloatBallSide): FloatBallSide = when (side) {
            LEFT -> RIGHT
            RIGHT -> LEFT
        }
    }
}
