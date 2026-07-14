package com.slideindex.app.settings

import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.launcher.QuickLauncherItemCodec

enum class FloatingPointerEdgeSide {
    TOP,
    LEFT,
    RIGHT,
    BOTTOM,
    ;

    val storageKey: String
        get() = when (this) {
            TOP -> "topEdgeBar"
            LEFT -> "leftEdgeBar"
            RIGHT -> "rightEdgeBar"
            BOTTOM -> "bottomEdgeBar"
        }
}

data class FloatingPointerEdgeActionSlot(
    val action: GestureAction,
    val sizeWeight: Int = 1,
)

data class FloatingPointerEdgeBar(
    val enabled: Boolean = false,
    val actions: List<FloatingPointerEdgeActionSlot> = listOf(
        FloatingPointerEdgeActionSlot(GestureAction.None),
    ),
) {
    fun totalWeight(): Int = actions.sumOf { it.sizeWeight.coerceAtLeast(1) }.coerceAtLeast(1)

    fun layoutSlots(): List<FloatingPointerEdgeActionSlot> =
        if (actions.isEmpty()) listOf(FloatingPointerEdgeActionSlot(GestureAction.None)) else actions
}

data class FloatingPointerEdgeActionsConfig(
    val top: FloatingPointerEdgeBar = FloatingPointerEdgeActionsCodec.defaultTopBar(),
    val left: FloatingPointerEdgeBar = FloatingPointerEdgeActionsCodec.defaultSideBar(),
    val right: FloatingPointerEdgeBar = FloatingPointerEdgeActionsCodec.defaultSideBar(),
    val bottom: FloatingPointerEdgeBar = FloatingPointerEdgeActionsCodec.defaultBottomBar(),
) {
    fun bar(side: FloatingPointerEdgeSide): FloatingPointerEdgeBar = when (side) {
        FloatingPointerEdgeSide.TOP -> top
        FloatingPointerEdgeSide.LEFT -> left
        FloatingPointerEdgeSide.RIGHT -> right
        FloatingPointerEdgeSide.BOTTOM -> bottom
    }

    fun withBar(side: FloatingPointerEdgeSide, bar: FloatingPointerEdgeBar): FloatingPointerEdgeActionsConfig =
        when (side) {
            FloatingPointerEdgeSide.TOP -> copy(top = bar)
            FloatingPointerEdgeSide.LEFT -> copy(left = bar)
            FloatingPointerEdgeSide.RIGHT -> copy(right = bar)
            FloatingPointerEdgeSide.BOTTOM -> copy(bottom = bar)
        }
}

object FloatingPointerEdgeActionsCodec {
    private const val ENTRY_SEP = "\u001E"
    private const val FIELD_SEP = "\u001D"
    private const val SLOT_SEP = "\u001F"
    private const val LEGACY_SLOT_SEP = "|"
    private const val WEIGHT_SEP = ":"
    const val MAX_SLOTS_PER_EDGE = 8

    fun defaultConfig(): FloatingPointerEdgeActionsConfig = FloatingPointerEdgeActionsConfig()

    fun defaultTopBar(): FloatingPointerEdgeBar = FloatingPointerEdgeBar(
        enabled = true,
        actions = listOf(
            FloatingPointerEdgeActionSlot(GestureAction.OpenNotifications),
            FloatingPointerEdgeActionSlot(GestureAction.OpenQuickSettings),
        ),
    )

    fun defaultSideBar(): FloatingPointerEdgeBar = FloatingPointerEdgeBar(
        enabled = false,
        actions = listOf(
            FloatingPointerEdgeActionSlot(GestureAction.Back),
            FloatingPointerEdgeActionSlot(GestureAction.None),
            FloatingPointerEdgeActionSlot(GestureAction.None),
        ),
    )

    fun defaultBottomBar(): FloatingPointerEdgeBar = FloatingPointerEdgeBar(
        enabled = false,
        actions = listOf(
            FloatingPointerEdgeActionSlot(GestureAction.None),
            FloatingPointerEdgeActionSlot(GestureAction.None),
        ),
    )

    fun decode(encoded: Set<String>): FloatingPointerEdgeActionsConfig {
        if (encoded.isEmpty()) return defaultConfig()
        val defaults = defaultConfig()
        var config = defaults
        FloatingPointerEdgeSide.entries.forEach { side ->
            val entry = encoded.firstOrNull { it.startsWith(side.storageKey + FIELD_SEP) } ?: return@forEach
            decodeBar(entry)?.let { config = config.withBar(side, it) }
        }
        return config
    }

    fun encode(config: FloatingPointerEdgeActionsConfig): Set<String> =
        FloatingPointerEdgeSide.entries.map { side ->
            encodeBar(side.storageKey, config.bar(side))
        }.toSet()

    private fun decodeBar(entry: String): FloatingPointerEdgeBar? {
        val parts = entry.split(FIELD_SEP)
        if (parts.size < 3) return null
        val enabled = parts[1] == "1"
        val slotsRaw = parts.drop(2).joinToString(FIELD_SEP)
        val slotSep = if (slotsRaw.contains(SLOT_SEP)) SLOT_SEP else LEGACY_SLOT_SEP
        val slots = slotsRaw.split(slotSep).mapNotNull { slotEntry ->
            if (slotEntry.isBlank()) return@mapNotNull null
            val weightSep = slotEntry.indexOf(WEIGHT_SEP)
            if (weightSep <= 0) return@mapNotNull null
            val weight = slotEntry.substring(0, weightSep).toIntOrNull()?.coerceIn(1, 10) ?: return@mapNotNull null
            val payload = slotEntry.substring(weightSep + 1)
            val action = QuickLauncherItemCodec.parseActionPayload(payload) ?: return@mapNotNull null
            FloatingPointerEdgeActionSlot(sanitizeEdgeAction(action), weight)
        }
        return FloatingPointerEdgeBar(
            enabled = enabled,
            actions = slots.ifEmpty { listOf(FloatingPointerEdgeActionSlot(GestureAction.None)) },
        )
    }

    private fun encodeBar(key: String, bar: FloatingPointerEdgeBar): String {
        val slots = bar.actions.joinToString(SLOT_SEP) { slot ->
            "${slot.sizeWeight.coerceIn(1, 10)}$WEIGHT_SEP${
                QuickLauncherItemCodec.encodeActionPayload(sanitizeEdgeAction(slot.action))
            }"
        }
        return "$key$FIELD_SEP${if (bar.enabled) 1 else 0}$FIELD_SEP$slots"
    }

    private fun sanitizeEdgeAction(action: GestureAction): GestureAction = when (action) {
        is GestureAction.FloatingPointer,
        is GestureAction.OpenFloatingPointerRadialMenu,
        is GestureAction.PointerGestureRecorder,
        is GestureAction.PointerRealtimeGesture,
        -> GestureAction.None
        else -> action
    }
}
