package com.example.nbageek.deeplink

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.example.home.deeplink.HomeDeeplinkModule
import com.example.home.deeplink.HomeDeeplinkModuleLoader

@DeepLinkHandler(AppDeeplinkModule::class, HomeDeeplinkModule::class)
class AppDeeplinkActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deeplinkDelegate = DeepLinkDelegate(
            AppDeeplinkModuleLoader(), HomeDeeplinkModuleLoader()
        )

        deeplinkDelegate.dispatchFrom(this)
        finish()
    }
}