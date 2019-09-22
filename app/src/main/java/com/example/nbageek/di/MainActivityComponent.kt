package com.example.nbageek.di

import com.example.nbageek.MainParentActivity
import dagger.Component

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [com.example.abstraction.di.BaseAppComponent::class])
interface MainActivityComponent {

    fun inject(mainParentActivity: MainParentActivity)
}