package com.example.nbageek

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.content.Intent
import android.util.Log
import com.example.abstraction.di.MainApplication
import com.example.home.HomeActivity
import com.example.nbageek.di.DaggerMainActivityComponent
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initInjector()

        Log.e("called","${retrofit.baseUrl()}")

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        content_main.setOnClickListener {
            val detailsIntent = Intent(this, HomeActivity::class.java)
            startActivity(detailsIntent)
        }

    }

    private fun initInjector() {
        DaggerMainActivityComponent.builder()
            .baseAppComponent(MainApplication.get(this).getRandomUserApplicationComponent())
            .build()
            .inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
