package com.saugat.finalassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.saugat.finalassignment.R
import com.saugat.finalassignment.database.CustomerDB
import com.saugat.finalassignment.entity.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvForgotPass: TextView
    private lateinit var tvSignup: TextView
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPass = findViewById(R.id.tvForgotPass)
        tvSignup = findViewById(R.id.tvSignup)
        rootLayout = findViewById(R.id.rootLayout)

        btnLogin.setOnClickListener {
            validate()
            login()
        }

        tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        var customer: Customer?
        CoroutineScope(Dispatchers.IO).launch {
            customer = CustomerDB
                    .getInstance(this@MainActivity)
                    .getCustomerDAO()
                    .checkCustomer(email,password)
            if (customer == null) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Invalid Email or Password!!", Toast.LENGTH_SHORT)
                            .show()
                }
            } else {
//                val snackbar = Snackbar.make(rootLayout, "Login Successful", Snackbar.LENGTH_LONG)
//                snackbar.setAction("Close") {
//                    snackbar.dismiss()
//                }
//                snackbar.show()
                startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
            }
        }
    }

    private fun validate(): Boolean {
        if(etEmail.text.toString().isEmpty()){
            etEmail.error = "Blank Email"
            return false
        }
        else if(etPassword.text.toString().isEmpty()){
            etPassword.error = "Blank Password"
            return false
        }
        return true
    }
}