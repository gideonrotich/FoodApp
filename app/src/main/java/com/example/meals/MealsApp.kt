package com.example.meals

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MealsApp : Application(){
    override fun onCreate() {
        super.onCreate()
        createTimber()
    }
    private fun createTimber(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}