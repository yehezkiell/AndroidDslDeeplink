package com.example.team

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_team_list.*
import com.example.abstraction.base.BaseDaggerFragment

class TeamFragment : BaseDaggerFragment() {

    override fun initInjector() {}

    override fun getLayoutRes(): Int = R.layout.fragment_team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }
}
