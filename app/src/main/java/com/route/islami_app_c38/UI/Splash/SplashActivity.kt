package com.route.islami_app_c38.UI.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.islami_app_c38.R
import com.route.islami_app_c38.UI.Home.Home_Activity

class SplashActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StartHomeActivity()
    }
    private fun StartHomeActivity(){
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, Home_Activity::class.java)
                startActivity(intent)
            },2000)
    }
}