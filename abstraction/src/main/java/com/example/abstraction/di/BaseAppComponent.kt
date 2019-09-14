package com.example.abstraction.di

import android.content.Context
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [NetworkModule::class, ApplicationContextModule::class])
interface BaseAppComponent {

    @ApplicationContext
    fun getContext(): Context

    fun getRetrofit(): Retrofit
}