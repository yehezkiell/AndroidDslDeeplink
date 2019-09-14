package com.example.abstraction.di

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ApplicationContextModule(private val context: Context) {

    @ApplicationContext
    @ApplicationScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}