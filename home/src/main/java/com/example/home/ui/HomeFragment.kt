package com.example.home.ui

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.abstraction.base.BaseDaggerFragment
import com.example.home.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseDaggerFragment() {
    override fun getLayoutRes(): Int = R.layout.fragment_home
    override fun initInjector() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_home.setOnClickListener {
            val uri: Uri = Uri.parse("nba://www.nbageek.com").buildUpon()
                .appendPath("home")
                .build()
            startActivity(Intent(ACTION_VIEW, uri))
        }

        txt_match_detail.setOnClickListener {
            view.findNavController().navigate(R.id.actionHome_To_Matchdetail)
        }
    }
}
