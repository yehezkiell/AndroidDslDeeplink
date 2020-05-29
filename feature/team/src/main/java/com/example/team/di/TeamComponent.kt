package com.example.team.di

import com.example.abstraction.di.BaseAppComponent
import com.example.team.ui.TeamFragment
import dagger.Component

/**
 * Created by Yehezkiel on 2020-01-23
 */
@TeamScope
@Component(
    modules = [TeamModule::class, TeamViewModelModule::class],
    dependencies = [BaseAppComponent::class]
)
interface TeamComponent {
    fun inject(teamFragment: TeamFragment)
}