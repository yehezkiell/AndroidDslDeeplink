package com.example.home.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.abstraction.base.BaseDaggerFragment
import com.example.home.R
import kotlinx.android.synthetic.main.fragment_home.*

class MatchDetailFragment : BaseDaggerFragment() {

    override fun getLayoutRes(): Int = R.layout.fragment_match_detail

    override fun initInjector() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_match_detail.setOnClickListener {
            findNavController().navigate(R.id.action_matchDetailFragment_to_playerFragment)
        }
    }
}