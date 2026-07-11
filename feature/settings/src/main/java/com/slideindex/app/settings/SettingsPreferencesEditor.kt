package com.slideindex.app.settings



import android.content.Context

import androidx.datastore.core.DataStore

import androidx.datastore.preferences.core.MutablePreferences

import androidx.datastore.preferences.core.Preferences

import androidx.datastore.preferences.core.edit

import androidx.datastore.preferences.preferencesDataStore

import dagger.hilt.android.qualifiers.ApplicationContext

import javax.inject.Inject

import javax.inject.Singleton

import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.map



private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "slide_index_settings")



@Singleton

class SettingsPreferencesEditor @Inject constructor(

    @ApplicationContext private val context: Context,

) {

    val settings: Flow<AppSettings> = context.dataStore.data.map { prefs ->

        SettingsSnapshotReader.read(prefs)

    }



    suspend fun edit(block: (MutablePreferences) -> Unit): Result<Unit> = runCatching {

        context.dataStore.edit { prefs ->

            block(prefs)

        }

    }

}


