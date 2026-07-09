package com.slideindex.app.ui.feedback

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserMessageBusTest {
    @Test
    fun showError_emitsErrorMessage() = runTest {
        val bus = UserMessageBus()
        val message = async { bus.messages.first() }
        advanceUntilIdle()

        bus.showError("save failed")

        assertEquals(UserMessage.Error("save failed"), message.await())
    }

    @Test
    fun showSuccess_emitsSuccessMessage() = runTest {
        val bus = UserMessageBus()
        val message = async { bus.messages.first() }
        advanceUntilIdle()

        bus.showSuccess("granted")

        assertEquals(UserMessage.Success("granted"), message.await())
    }
}
