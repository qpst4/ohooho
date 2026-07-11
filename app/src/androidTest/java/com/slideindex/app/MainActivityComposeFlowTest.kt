package com.slideindex.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityComposeFlowTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun launchesHomeBottomNavigation() {
        composeRule.waitForIdle()
        composeRule.onNodeWithText("首页").assertIsDisplayed()
        composeRule.onNodeWithText("晃动").assertIsDisplayed()
        composeRule.onNodeWithText("通知").assertIsDisplayed()
        composeRule.onNodeWithText("扩展").assertIsDisplayed()
    }

    @Test
    fun navigatesToShakeTab() {
        composeRule.waitForIdle()
        composeRule.onNodeWithText("晃动").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("晃动").assertIsDisplayed()
    }
}
