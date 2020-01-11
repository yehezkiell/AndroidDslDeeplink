package com.example.nbageek

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.abstraction.di.MainApplication
import com.example.nbageek.di.DaggerMainActivityComponent
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject


class MainParentActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(setOf(R.id.homeFragment, R.id.teamFragment)).build()
    }
    private val navController: NavController by lazy { findNavController(R.id.nav_host_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initInjector()
        if (savedInstanceState == null) {
            setUpNavigation()
        }
        Log.e("called", "${retrofit.baseUrl()}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment, R.id.teamFragment, R.id.gamesFragment -> bottomNavigationView.visibility =
                    View.VISIBLE
                else -> bottomNavigationView.visibility = View.GONE
            }
        }
    }

    private fun initInjector() {
        DaggerMainActivityComponent.builder()
            .baseAppComponent((application as MainApplication).getBaseAppComponent())
            .build()
            .inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
