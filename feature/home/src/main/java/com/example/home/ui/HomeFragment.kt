package com.example.home.ui

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.abstraction.base.BaseDaggerFragment
import com.example.abstraction.di.MainApplication
import com.example.home.R
import com.example.home.di.DaggerHomeComponent
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseDaggerFragment() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_home
    override fun initInjector() {
        context?.let {
            DaggerHomeComponent.builder()
                .baseAppComponent((it.applicationContext as MainApplication).getBaseAppComponent())
                .build().inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProductCoroutineScope()

        Toast.makeText(context!!, viewModel.getInfo(), Toast.LENGTH_LONG).show()

        sumByOne.setOnClickListener {
            viewModel.addNumberOne()
            val uri = Uri.parse("http://nbageek.com/team")
            findNavController(view).navigate(uri)
        }

        sumByTwo.setOnClickListener {
            viewModel.addNumberTwo()
//            val uri = Uri.parse("http://nbageek.com/games")
//            findNavController(view).navigate(uri)
            findNavController(view).navigate(R.id.action_goto_match_detail)

        }

        viewModel.sumData.observe(this, Observer {
            Log.e("sumnya", it)
        })

        viewModel.sumData2.observe(this, Observer {
            Log.e("sumnya", it)
        })


        txt_home.setOnClickListener {
            val uri: Uri = Uri.parse("http://www.nbageek.com/team").buildUpon()
                .appendQueryParameter("id", "123")
                .build()
            startActivity(Intent(ACTION_VIEW, uri))
        }

        txt_match_detail.setOnClickListener {
            view.findNavController().navigate(R.id.actionHome_To_Matchdetail)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.sumResult.observe(this, Observer {
            sumResult.text = "Sum Result: $it"
        })
    }
}
