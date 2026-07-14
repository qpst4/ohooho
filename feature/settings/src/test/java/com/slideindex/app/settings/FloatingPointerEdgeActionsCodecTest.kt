package com.slideindex.app.settings

import com.slideindex.app.gesture.GestureAction
import org.junit.Assert.assertEquals
import org.junit.Test

class FloatingPointerEdgeActionsCodecTest {
    @Test
    fun encodeDecode_roundTripsDefaultTopBar() {
        val config = FloatingPointerEdgeActionsCodec.defaultConfig()
        val decoded = FloatingPointerEdgeActionsCodec.decode(FloatingPointerEdgeActionsCodec.encode(config))
        assertEquals(config, decoded)
    }

    @Test
    fun encodeDecode_preservesAddedSlots() {
        val top = FloatingPointerEdgeActionsCodec.defaultTopBar().copy(
            actions = FloatingPointerEdgeActionsCodec.defaultTopBar().actions +
                List(3) { FloatingPointerEdgeActionSlot(GestureAction.None) },
        )
        val config = FloatingPointerEdgeActionsCodec.defaultConfig().withBar(FloatingPointerEdgeSide.TOP, top)
        val decoded = FloatingPointerEdgeActionsCodec.decode(FloatingPointerEdgeActionsCodec.encode(config))
        assertEquals(5, decoded.top.layoutSlots().size)
    }

    @Test
    fun encodeDecode_preservesMaxSlots() {
        val top = FloatingPointerEdgeActionsCodec.defaultTopBar().copy(
            actions = List(FloatingPointerEdgeActionsCodec.MAX_SLOTS_PER_EDGE) { index ->
                when (index) {
                    0 -> FloatingPointerEdgeActionSlot(GestureAction.OpenNotifications)
                    1 -> FloatingPointerEdgeActionSlot(GestureAction.OpenQuickSettings)
                    else -> FloatingPointerEdgeActionSlot(GestureAction.Back)
                }
            },
        )
        val config = FloatingPointerEdgeActionsCodec.defaultConfig().withBar(FloatingPointerEdgeSide.TOP, top)
        val encoded = FloatingPointerEdgeActionsCodec.encode(config)
        val decoded = FloatingPointerEdgeActionsCodec.decode(encoded)
        assertEquals(FloatingPointerEdgeActionsCodec.MAX_SLOTS_PER_EDGE, decoded.top.layoutSlots().size)
    }

    @Test
    fun encodeDecode_preservesActionPayloadContainingPipeCharacter() {
        val top = FloatingPointerEdgeActionsCodec.defaultTopBar().copy(
            actions = listOf(
                FloatingPointerEdgeActionSlot(GestureAction.LaunchApp("com.foo|bar")),
                FloatingPointerEdgeActionSlot(GestureAction.OpenQuickSettings),
                FloatingPointerEdgeActionSlot(GestureAction.None),
            ),
        )
        val config = FloatingPointerEdgeActionsCodec.defaultConfig().withBar(FloatingPointerEdgeSide.TOP, top)
        val decoded = FloatingPointerEdgeActionsCodec.decode(FloatingPointerEdgeActionsCodec.encode(config))
        assertEquals(3, decoded.top.layoutSlots().size)
        assertEquals("com.foo|bar", decoded.top.layoutSlots()[0].action.payload)
    }
}
