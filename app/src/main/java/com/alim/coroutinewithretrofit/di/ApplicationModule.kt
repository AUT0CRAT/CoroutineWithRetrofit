package com.alim.coroutinewithretrofit.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val applicationContext : Context) {

    @Provides
    @GlobalScope
    fun provideApplicationComponent() = applicationContext

}
