package com.example.abstraction.di

import android.app.Application
import android.app.Activity
import android.content.Context

class MainApplication : Application() {

    private lateinit var baseAppComponent: BaseAppComponent

    override fun onCreate() {
        super.onCreate()
        baseAppComponent = DaggerBaseAppComponent.builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getBaseAppComponent(): BaseAppComponent {
        return baseAppComponent
    }

}