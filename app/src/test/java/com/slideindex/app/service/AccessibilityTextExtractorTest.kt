package com.slideindex.app.service

import org.junit.Assert.assertEquals
import org.junit.Test

class AccessibilityTextExtractorTest {
    @Test
    fun joinSortedTexts_ordersTopToBottomAndDedupes() {
        val joined = AccessibilityTextExtractor.joinSortedTexts(
            listOf(
                AccessibilityTextExtractor.TextEntry("第二行", top = 40, left = 0),
                AccessibilityTextExtractor.TextEntry("第一行", top = 10, left = 0),
                AccessibilityTextExtractor.TextEntry("第一行", top = 12, left = 0),
            ),
        )
        assertEquals("第一行\n第二行", joined)
    }
}
