package com.slvmk.roundtableexperiments

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RTApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}