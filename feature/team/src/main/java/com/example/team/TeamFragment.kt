package com.example.team

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_team_list.*
import com.example.abstraction.base.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_team.*

class TeamFragment : BaseDaggerFragment() {

    override fun initInjector() {}

    override fun getLayoutRes(): Int = R.layout.fragment_team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        team_text.setOnClickListener {
            val uri = Uri.parse("http://nbageek.com/match-detail")
            view.findNavController().navigate(uri)
        }
    }
}
