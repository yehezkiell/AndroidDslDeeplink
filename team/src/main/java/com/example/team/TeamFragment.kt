package com.example.team

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_team_list.*
import androidx.appcompat.app.AppCompatActivity
import com.example.abstraction.base.BaseDaggerFragment

class TeamFragment : BaseDaggerFragment() {

    override fun initInjector() {}

    override fun getLayoutRes(): Int = R.layout.fragment_team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbars()
    }
}
