package com.example.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abstraction.viewmodel.ViewModelFactory
import com.example.abstraction.viewmodel.ViewModelKey
import com.example.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class HomeViewModelModule {

    @HomeScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @HomeScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: HomeViewModel): ViewModel

}