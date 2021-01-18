package com.saugat.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvForgotPass: TextView
    private lateinit var tvSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPass = findViewById(R.id.tvForgotPass)
        tvSignup = findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {

            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }

        tvSignup.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }

//    private fun validate(): Boolean {
//        if(etUsername.text.toString().isEmpty()){
//            etUsername.error = "Blank Username"
//            return false
//        }
//        else if(etPassword.text.toString().isEmpty()){
//            etPassword.error = "Blank Password"
//            return false
//        }
//        return true
//    }
}