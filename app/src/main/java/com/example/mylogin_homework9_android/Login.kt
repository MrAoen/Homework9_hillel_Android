package com.example.mylogin_homework9_android

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = findViewById<TextInputLayout>(R.id.loginUserName)
        val password = findViewById<TextInputLayout>(R.id.loginUserPassword)

        password.editText?.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    if (validateMe(user, password)) {
                        val prefs = getSharedPreferences("login", MODE_PRIVATE)
                        prefs.edit()
                            .putString("Name", user.editText?.text.toString())
                            .putBoolean("isLogged", true)
                            .putString("Password", password.editText?.text.toString())
                            .apply()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    }
                    true
                }
                else -> {
                    false
                }
            }
        }

        //startActivity(Intent(this,MainActivity::class.java))
    }

    private fun validateMe(user: TextInputLayout, password: TextInputLayout): Boolean {
        var result = true
        if (user.editText?.text.toString().length < 6) {
            user.error = "User name must be at least 6 char lenght"
            result = false
        } else {
            user.error = null
        }

        if (password.editText?.text.isNullOrEmpty()) {
            password.error = "Require any password"
            result = false
        } else {
            password.error = null
        }
        return result
    }
}


