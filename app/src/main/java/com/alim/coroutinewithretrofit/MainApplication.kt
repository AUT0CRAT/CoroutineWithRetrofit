package com.alim.coroutinewithretrofit

import android.app.Application
import com.alim.coroutinewithretrofit.di.DaggerApplicationComponent
import com.alim.coroutinewithretrofit.di.Injector

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.baseComponent = DaggerApplicationComponent.create()
            .apply {
                inject(this@MainApplication)
            }
    }
}