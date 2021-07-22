package com.example.mylogin_homework9_android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userDetail = getSharedPreferences("login", MODE_PRIVATE)

        val userName = findViewById<TextView>(R.id.userName)
        userName.text = userDetail.getString("Name", "Unknown")

        val userPassword = findViewById<TextView>(R.id.userPassword)
        userPassword.text = userDetail.getString("Password", "No password set")

        val btn = findViewById<Button>(R.id.buttonInvalidate)
        btn.setOnClickListener {
            userDetail.edit()
                .putBoolean("isLogged", false)
                .apply()
        }
    }
}