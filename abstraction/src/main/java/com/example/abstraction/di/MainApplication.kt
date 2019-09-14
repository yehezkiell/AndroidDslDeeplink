package com.example.abstraction.di

import android.app.Application
import android.app.Activity

class MainApplication : Application() {

    private lateinit var baseAppComponent: BaseAppComponent

    companion object {
        fun get(activity: Activity): MainApplication {
            return activity.application as MainApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        baseAppComponent = DaggerBaseAppComponent.builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getRandomUserApplicationComponent(): BaseAppComponent {
        return baseAppComponent
    }

}