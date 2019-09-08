package com.example.nbageek.deeplink

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.example.home.deeplink.HomeDeeplinkModule
import com.example.home.deeplink.HomeDeeplinkModuleLoader
import com.example.team.deeplink.TeamDeepLinkModule
import com.example.team.deeplink.TeamDeepLinkModuleLoader


@DeepLinkHandler(AppDeeplinkModule::class, HomeDeeplinkModule::class, TeamDeepLinkModule::class)
class AppDeeplinkActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deeplinkDelegate = DeepLinkDelegate(
            AppDeeplinkModuleLoader(), HomeDeeplinkModuleLoader(),
            TeamDeepLinkModuleLoader()
        )


        deeplinkDelegate.dispatchFrom(this)
        finish()
    }


}