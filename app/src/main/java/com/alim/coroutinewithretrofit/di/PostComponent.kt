package com.alim.coroutinewithretrofit.di

import com.alim.coroutinewithretrofit.PostActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ]
)
interface PostComponent {
    fun inject(activity: PostActivity)
}