package com.example.nbageek.di

import com.example.nbageek.MainActivity
import dagger.Component

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [com.example.abstraction.di.BaseAppComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}