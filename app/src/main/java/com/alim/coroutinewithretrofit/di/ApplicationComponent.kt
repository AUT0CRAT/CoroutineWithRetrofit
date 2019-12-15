package com.alim.coroutinewithretrofit.di

import com.alim.coroutinewithretrofit.MainApplication
import com.alim.coroutinewithretrofit.network.ApiGateway
import dagger.Component

@GlobalScope
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: MainApplication)

    fun getApiGateway(): ApiGateway
}