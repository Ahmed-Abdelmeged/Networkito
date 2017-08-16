package com.abdelmeged.ahmed.networkitotest

import android.app.Application
import timber.log.Timber

/**
 * Created by ahmed on 8/16/2017.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}