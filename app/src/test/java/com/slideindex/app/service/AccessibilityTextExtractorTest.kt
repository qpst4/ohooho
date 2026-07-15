package com.slideindex.app.service

import org.junit.Assert.assertEquals
import org.junit.Test

class AccessibilityTextExtractorTest {
    @Test
    fun pickBetterCandidate_prefersSmallerVisibleBounds() {
        val overlay = AccessibilityTextExtractor.TextCandidate(
            text = "暂停视频，按钮",
            area = 1080 * 2400,
            isPrimaryText = false,
        )
        val comment = AccessibilityTextExtractor.TextCandidate(
            text = "这也叫挤？真正的挤是你双脚离地全自动上车下车",
            area = 869 * 132,
            isPrimaryText = true,
        )
        val picked = AccessibilityTextExtractor.pickBetterCandidate(overlay, comment)
        assertEquals(comment, picked)
    }

    @Test
    fun pickBetterCandidate_prefersPrimaryTextOnEqualArea() {
        val description = AccessibilityTextExtractor.TextCandidate(
            text = "按钮",
            area = 100,
            isPrimaryText = false,
        )
        val text = AccessibilityTextExtractor.TextCandidate(
            text = "评论正文",
            area = 100,
            isPrimaryText = true,
        )
        val picked = AccessibilityTextExtractor.pickBetterCandidate(description, text)
        assertEquals(text, picked)
    }

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
