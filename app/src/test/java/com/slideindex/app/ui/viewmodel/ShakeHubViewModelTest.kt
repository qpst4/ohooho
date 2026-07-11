package com.slideindex.app.ui.viewmodel

import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.settings.clearTestSettings
import com.slideindex.app.settings.testSettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ShakeHubViewModelTest : ViewModelCoroutineTest() {
    private lateinit var repository: SettingsRepository
    private lateinit var viewModel: ShakeHubViewModel

    @Before
    fun setUp() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        clearTestSettings(context)
        repository = testSettingsRepository(context)
        viewModel = ShakeHubViewModel(
            settingsRepository = repository,
            userMessageBus = UserMessageBus(),
            context = context,
        )
    }

    @Test
    fun settings_initialValue_matchesAppDefaults() {
        assertEquals(
            AppSettings().shakeGestureSettings,
            viewModel.settings.value.shakeGestureSettings,
        )
    }

    @Test
    fun setEnabled_persistsToSettingsFlow() = runViewModelTest {
        primeSettingsFlow(repository)
        viewModel.setEnabled(true)

        assertTrue(awaitSettings(repository) { it.shakeGestureSettings.enabled }.shakeGestureSettings.enabled)
    }
}
