package com.slideindex.app.ui.viewmodel

import android.content.Context
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
@Config(sdk = [30])
class ShakeHubViewModelTest {
    private lateinit var viewModel: ShakeHubViewModel

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        val repository = SettingsRepository(context)
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
}
