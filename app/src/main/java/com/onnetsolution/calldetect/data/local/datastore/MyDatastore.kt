package com.onnetsolution.calldetect.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MyDatastore @Inject constructor(
    @ApplicationContext private val context: Context
){
    companion object{
        const val USER_PREFERENCES_NAME = "preference"
        val DEVICE_ID = stringPreferencesKey("deviceId")
    }
    private val Context.dataStore by preferencesDataStore(
        name = USER_PREFERENCES_NAME
    )
    suspend fun updateDeviceId(devId: String) {
        context.dataStore.edit { preferences ->
            preferences[DEVICE_ID] = devId
        }
    }
    val userPreferencesFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[DEVICE_ID] ?: ""
    }
}