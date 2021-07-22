package com.example.mylogin_homework9_android

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val loginDetail = getSharedPreferences("login", MODE_PRIVATE)
        var actvClazz: Class<*>
        if (loginDetail.getBoolean("isLogged", false)) {
            actvClazz = MainActivity::class.java
        } else {
            actvClazz = Login::class.java
        }
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, actvClazz))
        }, 2000)
    }
}