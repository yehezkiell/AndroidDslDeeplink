package com.example.team.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.abstraction.base.BaseDaggerFragment
import com.example.abstraction.di.MainApplication
import com.example.team.R
import com.example.team.adapter.TeamAdapter
import com.example.team.di.DaggerTeamComponent
import kotlinx.android.synthetic.main.fragment_team.*
import javax.inject.Inject

class TeamFragment : BaseDaggerFragment(), TeamAdapter.TeamInterface {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val rvAdapter by lazy {
        TeamAdapter(this)
    }

    private val viewModel: TeamViewModel by viewModels(factoryProducer = { viewModelFactory })

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onItemTeamClicked(id: Int) {
        viewModel.setDeleteAction(id)
    }

    override fun initInjector() {
        context?.let {
            DaggerTeamComponent.builder()
                .baseAppComponent((it.applicationContext as MainApplication).getBaseAppComponent())
                .build().inject(this)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_team

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeData()
    }

    private fun initRecyclerView() {
        teamRecyclerView.adapter = rvAdapter
    }

    private fun observeData() {
        viewModel.teamsEdited.observe(viewLifecycleOwner, Observer {
            rvAdapter.submitList(it.toMutableList())
        })
    }
}
