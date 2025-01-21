package com.onnetsolution.calldetect.relaunch

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

fun scheduleAppLaunch(context: Context, lifecycleOwner: LifecycleOwner) {
    val workRequest= PeriodicWorkRequestBuilder<AppLaunchWorker>(15,TimeUnit.MINUTES)
        .setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED) // Ensures network is available
                .setRequiresBatteryNotLow(false)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .build()
        )
        .build()
    val workManager = WorkManager.getInstance(context)
    workManager.enqueueUniquePeriodicWork(
        "AppLaunchWorker",
        ExistingPeriodicWorkPolicy.KEEP,
        workRequest
    )

    workManager
        .getWorkInfosForUniqueWorkLiveData("AppLaunchWorker")
        .observe(lifecycleOwner) { workInfos ->
            workInfos?.forEach { workInfo ->
                Log.d("MainActivity", "Worker State: ${workInfo.state}")
            }
        }
}
