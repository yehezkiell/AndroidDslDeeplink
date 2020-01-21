package com.example.abstraction.di

import com.example.abstraction.BuildConfig
import com.example.abstraction.network.NbaApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpModule::class])
class NetworkModule {

    @ApplicationScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.API_KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @ApplicationScope
    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @ApplicationScope
    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @ApplicationScope
    @Provides
    fun provideGmCommonApi(retrofit: Retrofit): NbaApi {
        return retrofit.create(NbaApi::class.java)
    }

}