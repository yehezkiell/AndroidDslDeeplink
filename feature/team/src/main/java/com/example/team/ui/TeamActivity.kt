package com.example.team.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.team.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_team_list.*
import kotlinx.android.synthetic.main.content_team_list.*

class TeamActivity : AppCompatActivity() {

    companion object {
        const val ID_PARAM = "id"
    }

    private var teamId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        intent.data?.let {
            teamId = it.getQueryParameter(ID_PARAM) ?: return@let

        }

        Log.e("datanya", teamId)

        txt_id.text = teamId

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
