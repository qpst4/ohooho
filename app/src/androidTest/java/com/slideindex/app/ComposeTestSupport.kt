package com.slideindex.app

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.runBlocking

private val Context.testSettingsDataStore by preferencesDataStore(name = "slide_index_settings")

object ComposeTestSupport {
    fun markOnboardingCompleted(context: Context) = runBlocking {
        context.testSettingsDataStore.edit { prefs ->
            prefs[booleanPreferencesKey("onboarding_completed")] = true
        }
    }
}
