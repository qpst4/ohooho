package com.slideindex.app.ui.viewmodel

import com.slideindex.app.SlideIndexApp
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30], application = SlideIndexApp::class)
class ShakeHubViewModelTest {
    private lateinit var viewModel: ShakeHubViewModel

    @Before
    fun setUp() {
        val app = RuntimeEnvironment.getApplication() as SlideIndexApp
        val repository = SettingsRepository(app)
        viewModel = ShakeHubViewModel(
            settingsRepository = repository,
            userMessageBus = UserMessageBus(),
            app = app,
        )
    }

    @Test
    fun settings_initialValue_matchesAppDefaults() {
        assertEquals(
            AppSettings().shakeGestureSettings,
            viewModel.settings.value.shakeGestureSettings,
        )
    }
}
