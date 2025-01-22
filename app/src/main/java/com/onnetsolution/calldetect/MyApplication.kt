package com.onnetsolution.calldetect

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import com.onnetsolution.calldetect.data.local.datastore.MyDatastore
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltAndroidApp
@SuppressLint("HardwareIds")
class MyApplication : Application() {

    @Inject
    private lateinit var dataStore: MyDatastore

    override fun onCreate() {
        super.onCreate()
    }
}