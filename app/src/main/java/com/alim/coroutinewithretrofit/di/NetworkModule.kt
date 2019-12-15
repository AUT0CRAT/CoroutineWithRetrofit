package com.alim.coroutinewithretrofit.di

import com.alim.coroutinewithretrofit.network.API_GATEWAY_BASE_URL
import com.alim.coroutinewithretrofit.network.ApiGateway
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    @GlobalScope
    fun provideHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Provides
    @GlobalScope
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
    }

    @Provides
    @GlobalScope
    fun provideMoshi() : Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @GlobalScope
    fun provideApiGateway(retrofitBuilder:  Retrofit.Builder) : ApiGateway {
        return retrofitBuilder
            .baseUrl(API_GATEWAY_BASE_URL)
            .build()
            .create(ApiGateway::class.java)
    }
}