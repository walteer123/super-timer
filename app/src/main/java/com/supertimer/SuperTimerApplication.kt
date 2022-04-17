package com.supertimer

import android.app.Application
import com.supertimer.di.injectModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuperTimerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@SuperTimerApplication)
            injectModules()
        }
    }
}
