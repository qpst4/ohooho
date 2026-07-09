package com.slideindex.app.settings

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class SettingsRepositoryResultTest {
    @Test
    fun setServiceEnabled_returnsSuccessAndPersists() = runBlocking {
        val repository = SettingsRepository(RuntimeEnvironment.getApplication())

        val result = repository.setServiceEnabled(true)

        assertTrue(result.isSuccess)
        assertTrue(repository.readSnapshot().serviceEnabled)
    }
}
