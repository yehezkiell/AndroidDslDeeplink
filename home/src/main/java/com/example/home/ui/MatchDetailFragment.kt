package com.example.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.abstraction.base.BaseDaggerFragment
import com.example.home.R

class MatchDetailFragment : BaseDaggerFragment() {

    override fun getLayoutRes(): Int = R.layout.fragment_match_detail

    override fun initInjector() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }
}