package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.rescueme.app.RescueMe
import com.example.rescueme.utils.toast
import com.example.rescueme.utils.txt

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_signup)

        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val fullname = findViewById<EditText>(R.id.et_fullname)
        val confirmPassword = findViewById<EditText>(R.id.et_confirmpassword)

        val buttonSignup = findViewById<Button>(R.id.button_signup)
        buttonSignup.setOnClickListener {
            val usernameText = username.txt()
            val passwordText = password.txt()
            val fullnameText = fullname.txt()
            val confirmPasswordText = confirmPassword.txt()

            // Check if all fields are filled
            if (usernameText.isEmpty() || passwordText.isEmpty() || fullnameText.isEmpty() || confirmPasswordText.isEmpty()) {
                this.toast("Please fill out all fields.")
                return@setOnClickListener
            }

            // Check if passwords match
            if (passwordText != confirmPasswordText) {
                this.toast("Passwords do not match.")
                return@setOnClickListener
            }

            // Store data in the application class
            (application as RescueMe).setUsername(usernameText)
            (application as RescueMe).setPassword(passwordText)
            (application as RescueMe).setName(fullnameText)


            // Navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val buttonCancel = findViewById<Button>(R.id.button_cancel)
        buttonCancel.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}