package com.example.home.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.abstraction.base.BaseDaggerFragment
import com.example.home.R
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment: BaseDaggerFragment() {

    override fun getLayoutRes(): Int = R.layout.fragment_player

    override fun initInjector() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_player.setOnClickListener {
            findNavController().navigate(R.id.popUp_To_Home)
        }
    }
}