package com.onnetsolution.calldetect.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow


//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun DashBoard() {
//    val context= LocalContext.current
//    val sharedPref=context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
//
//    //Observe shared preferences or state updates
//    var shouldRefreshFlow = remember { MutableStateFlow(sharedPref.getBoolean("shouldRefresh", false)) }
//
//    DisposableEffect(Unit) {
//        val listener = SharedPreferences.OnSharedPreferenceChangeListener{_,key->
//            if(key == "shouldRefresh"){
//                shouldRefreshFlow.value = sharedPref.getBoolean("shouldRefresh", false)
//                Log.d("DashBoard", "shouldRefresh updated to $shouldRefreshFlow")
//
////                //Reset the refresh flag
////                if(shouldRefresh){
////                    sharedPref.edit().putBoolean("shouldRefresh", false).apply()
////                }
//            }
//        }
//        sharedPref.registerOnSharedPreferenceChangeListener(listener)
//        onDispose{
//            sharedPref.unregisterOnSharedPreferenceChangeListener(listener)
//        }
//    }
//    val shouldRefresh by shouldRefreshFlow.collectAsState()
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(text = "Welcome to Dashboard")
//        if (shouldRefresh) {
//            // Simulate an update (e.g., refresh data)
//             Log.d("DashBoard", "Refreshing Dashboard at ${System.currentTimeMillis()}")
//            Text(text = "Refreshing Dashboard at ${System.currentTimeMillis()}")
//            UserPhnNumber()
//        }
//        UserPhnNumber()
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoard() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Welcome to Dashboard")
        UserPhnNumber()
    }
}