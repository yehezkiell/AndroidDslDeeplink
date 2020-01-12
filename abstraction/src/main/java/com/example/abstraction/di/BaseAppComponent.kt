package com.example.abstraction.di

import android.content.Context
import com.example.abstraction.network.NbaApi
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [NetworkModule::class, ApplicationContextModule::class])
interface BaseAppComponent {

    @ApplicationContext
    fun getContext(): Context
    fun getRetrofit(): Retrofit
    fun gson(): Gson
    fun getNbaApi(): NbaApi

}