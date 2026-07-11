package com.slideindex.app.ui.viewmodel

import android.os.Looper
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessage
import com.slideindex.app.ui.feedback.UserMessageBus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withTimeout
import org.robolectric.Shadows

@OptIn(ExperimentalCoroutinesApi::class)
internal fun runViewModelTest(block: suspend CoroutineScope.() -> Unit) = runBlocking {
    Dispatchers.setMain(UnconfinedTestDispatcher())
    try {
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        block()
    } finally {
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        Dispatchers.resetMain()
    }
}

internal suspend fun primeSettingsFlow(repository: SettingsRepository) {
    repository.settings.first()
}

internal suspend fun awaitSettings(
    repository: SettingsRepository,
    predicate: (AppSettings) -> Boolean = { true },
): AppSettings =
    withTimeout(5_000) {
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        repository.settings.first(predicate)
    }

abstract class ViewModelCoroutineTest

internal suspend fun awaitUserError(bus: UserMessageBus): UserMessage.Error {
    val message = bus.messages.first()
    require(message is UserMessage.Error) { "Expected error message but got $message" }
    return message
}
