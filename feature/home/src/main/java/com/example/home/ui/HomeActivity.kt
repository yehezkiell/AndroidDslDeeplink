package com.example.home.ui

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abstraction.di.MainApplication
import com.example.home.R
import com.example.home.di.DaggerHomeComponent
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import retrofit2.Retrofit
import javax.inject.Inject


class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initInjector()

        txt_home.setOnClickListener {
            val uri: Uri = Uri.parse("http://www.nbageek.com/team/{id}").buildUpon()
                .appendQueryParameter("id", "123")
                .build()
            startActivity(Intent(ACTION_VIEW, uri))
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initInjector() {
        DaggerHomeComponent.builder()
            .baseAppComponent((applicationContext as MainApplication).getBaseAppComponent())
            .build().inject(this)
    }
}
