package com.saugat.finalassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.saugat.finalassignment.R
import com.saugat.finalassignment.database.CustomerDB
import com.saugat.finalassignment.entity.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupActivity : AppCompatActivity() {

    private lateinit var tvLogin: TextView
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPass: EditText
    private lateinit var etAddress: EditText
    private lateinit var etPhone: EditText
    private lateinit var etMail: EditText
    private lateinit var btnSignup: Button
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        tvLogin = findViewById(R.id.tvLogin)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPass = findViewById(R.id.etConfirmPass)
        etAddress = findViewById(R.id.etAddress)
        etPhone = findViewById(R.id.etPhone)
        etMail = findViewById(R.id.etMail)
        btnSignup = findViewById(R.id.btnSignup)
        rootLayout = findViewById(R.id.rootLayout)

        btnSignup.setOnClickListener{
            val fname = etFirstName.text.toString()
            val lname = etLastName.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPass.text.toString()
            val address = etAddress.text.toString()
            val phone = etPhone.text.toString()
            val mail = etMail.text.toString()

            if (password != confirmPassword) {
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            } else {
                val customer = Customer(fname, lname, password, address, phone, mail)
                CoroutineScope(Dispatchers.IO).launch {
                    CustomerDB
                        .getInstance(this@SignupActivity)
                        .getCustomerDAO()
                        .registerCustomer(customer)
                    // Switch to Main thread
                    withContext(Dispatchers.Main) {
                        val snackbar = Snackbar.make(rootLayout, "Welcome to RB family", Snackbar.LENGTH_INDEFINITE)
                        snackbar.setAction("Close") {
                            snackbar.dismiss()
                        }
                        snackbar.show()

                        emptyForm()

                    }
                }
            }
        }

        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun emptyForm() {
        etFirstName.setText("")
        etLastName.setText("")
        etPassword.setText("")
        etConfirmPass.setText("")
        etAddress.setText("")
        etPhone.setText("")
        etMail.setText("")
        etFirstName.requestFocus()
    }
}