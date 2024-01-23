package com.example.trackapp

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {
}