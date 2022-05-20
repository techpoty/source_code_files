package com.tonevellah.splashscreenapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tonevellah.splashscreenapi.R

class MainActivity : AppCompatActivity() {
    //define a boolean variable
    var isAndroidReady = false
    override fun onCreate(savedInstanceState: Bundle?) {
        //handle the splash screen transitions
        installSplashScreen()

        //keep splash screen for a long time
        val content = findViewById<View>(android.R.id.content)
        //add the pre draw listener to the view tree observer
        content.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                if (isAndroidReady) {
                    content.viewTreeObserver.removeOnPreDrawListener(this)
                }
                //define a method to alter isAndroidReady boolean
                dismissSplashScreen()
                return false
            }
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun dismissSplashScreen() {
        //use an handler
        Handler().postDelayed({ //change the boolean
            isAndroidReady = true
        }, 5000)
    }
}
