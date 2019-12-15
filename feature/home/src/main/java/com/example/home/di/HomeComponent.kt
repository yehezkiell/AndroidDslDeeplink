package com.example.home.di

import com.example.abstraction.di.BaseAppComponent
import com.example.home.ui.HomeActivity
import com.example.home.ui.HomeFragment
import dagger.Component

@HomeScope
@Component(modules = [HomeModule::class], dependencies = [BaseAppComponent::class])
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)
    fun inject(homeFragment: HomeFragment)
}