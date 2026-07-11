package com.slideindex.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.slideindex.app.util.PermissionHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityComposeFlowTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        ComposeTestSupport.markOnboardingCompleted(context)
        composeRule.activityRule.scenario.onActivity { activity ->
            activity.recreate()
        }
        composeRule.waitForIdle()
    }

    @Test
    fun launchesHomeBottomNavigation() {
        composeRule.onNodeWithText("首页").assertIsDisplayed()
        composeRule.onNodeWithText("晃动").assertIsDisplayed()
        composeRule.onNodeWithText("通知").assertIsDisplayed()
        composeRule.onNodeWithText("扩展").assertIsDisplayed()
    }

    @Test
    fun navigatesAcrossAllRootTabs() {
        composeRule.onNodeWithText("晃动").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("晃动手势").assertIsDisplayed()

        composeRule.onNodeWithText("通知").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("通知").assertIsDisplayed()

        composeRule.onNodeWithText("扩展").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("设置备份").assertIsDisplayed()

        composeRule.onNodeWithText("首页").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("边缘手势与侧边面板").assertIsDisplayed()
    }

    @Test
    fun opensSettingsBackupScreen() {
        composeRule.onNodeWithText("扩展").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("设置备份").performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText("导出设置").assertIsDisplayed()
        composeRule.onNodeWithText("导入设置").assertIsDisplayed()
    }

    @Test
    fun homeTab_matchesGoldenScreenshot() {
        ScreenshotGolden.assertMatchesGolden(composeRule, "home_tab")
    }
}
