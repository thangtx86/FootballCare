package com.apps.footballcare.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.footballcare.R
import com.apps.footballcare.view.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            delay(3000)
            MainActivity.start(this@SplashActivity)
            finish()
        }
    }
}