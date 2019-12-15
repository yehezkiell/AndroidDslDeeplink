package com.example.team

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_team_list.*
import kotlinx.android.synthetic.main.content_team_list.*

@DeepLink("nba://www.nbageek.com/team/{id}")
class TeamListActivity : AppCompatActivity() {

    companion object {
        const val ID_PARAM = "id"
    }

    private var teamId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        intent?.let {
            if (it.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
                teamId = it.extras?.getString(ID_PARAM) ?: ""
            }
        }

        Log.e("datanya", teamId)

        txt_id.text = teamId

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
