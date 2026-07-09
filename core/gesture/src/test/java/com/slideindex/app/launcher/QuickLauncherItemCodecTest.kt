package com.slideindex.app.launcher

import com.slideindex.app.gesture.GestureAction
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class QuickLauncherItemCodecTest {

    @Test
    fun encodeDecode_roundTrip_preservesItem() {
        val original = QuickLauncherItem.app("com.example.app", "示例")

        val decoded = QuickLauncherItemCodec.decode(QuickLauncherItemCodec.encode(original))

        assertEquals(original, decoded)
    }

    @Test
    fun encodeAll_decodeAll_roundTrip_preservesList() {
        val items = listOf(
            QuickLauncherItem.app("com.one", "One"),
            QuickLauncherItem.dynamicShortcut("com.two", "shortcut-id", "Two"),
            QuickLauncherItem.action(GestureAction.Back, "返回"),
        )

        val decoded = QuickLauncherItemCodec.decodeAll(QuickLauncherItemCodec.encodeAll(items))

        assertEquals(items, decoded)
    }

    @Test
    fun parseActionPayload_roundTrip() {
        val action = GestureAction.LaunchApp("com.example.app")

        val payload = QuickLauncherItemCodec.encodeActionPayload(action)
        val parsed = QuickLauncherItemCodec.parseActionPayload(payload)

        assertEquals(action, parsed)
    }

    @Test
    fun parseIntentPayload_extractsUri() {
        val item = QuickLauncherItem.intentShortcut("#Intent;action=android.intent.action.VIEW;end", "打开")

        val uri = QuickLauncherItemCodec.parseIntentPayload(item.payload)

        assertEquals("#Intent;action=android.intent.action.VIEW;end", uri)
    }

    @Test
    fun parseIntentListPayload_extractsAllUris() {
        val item = QuickLauncherItem.intentShortcuts(
            listOf(
                "#Intent;action=one;end",
                "#Intent;action=two;end",
            ),
            "多意图",
        )

        val uris = QuickLauncherItemCodec.parseIntentListPayload(item.payload)

        assertEquals(
            listOf("#Intent;action=one;end", "#Intent;action=two;end"),
            uris,
        )
    }

    @Test
    fun shortcutItemKey_distinguishesShortcutKinds() {
        val dynamic = QuickLauncherItem.dynamicShortcut("com.app", "id-1")
        val intent = QuickLauncherItem.intentShortcut("#Intent;action=view;end")

        assertTrue(QuickLauncherItemCodec.shortcutItemKey(dynamic)!!.contains("com.app"))
        assertEquals("intent:#Intent;action=view;end", QuickLauncherItemCodec.shortcutItemKey(intent))
    }

    @Test
    fun decode_skipsLegacyFolderType() {
        assertNull(QuickLauncherItemCodec.decode("3\u001Efolder\u001E旧版"))
    }
}
