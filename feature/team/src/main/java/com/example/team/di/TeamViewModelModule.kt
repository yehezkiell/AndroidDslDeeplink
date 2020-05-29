package com.example.team.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abstraction.viewmodel.ViewModelFactory
import com.example.abstraction.viewmodel.ViewModelKey
import com.example.team.ui.TeamViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Yehezkiel on 2020-01-23
 */

@Module
abstract class TeamViewModelModule {

    @TeamScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @TeamScope
    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: TeamViewModel): ViewModel

}