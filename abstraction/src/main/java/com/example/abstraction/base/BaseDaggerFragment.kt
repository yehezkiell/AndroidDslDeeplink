package com.example.abstraction.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseDaggerFragment : Fragment() {

    var isHideToolbar = false
    abstract fun getLayoutRes(): Int
    abstract fun initInjector()

    fun hideToolbars() {
        isHideToolbar = true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isHideToolbar) {
            (activity as AppCompatActivity).supportActionBar?.hide()
        }
        initInjector()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onResume() {
        super.onResume()
        if (isHideToolbar) {
            (activity as AppCompatActivity).supportActionBar?.hide()
        }
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
}