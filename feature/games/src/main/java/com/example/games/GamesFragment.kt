package com.example.games

import android.os.Bundle
import com.example.abstraction.base.BaseDaggerFragment

class GamesFragment : BaseDaggerFragment() {

    override fun getLayoutRes(): Int = R.layout.games_fragment

    override fun initInjector() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }
}