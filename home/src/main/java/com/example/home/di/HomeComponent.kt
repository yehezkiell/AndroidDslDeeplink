package com.example.home.di

import com.example.abstraction.di.BaseAppComponent
import com.example.home.HomeActivity
import dagger.Component

@HomeScope
@Component(modules = [HomeModule::class], dependencies = [BaseAppComponent::class])
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)
}