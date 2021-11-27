package com.apps.footballcare.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.footballcare.R
import com.apps.footballcare.view.MainActivity
import com.apps.footballcare.view.start.GetStartedActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            delay(3000)
            GetStartedActivity.start(this@SplashActivity)
            finish()
        }
    }
}