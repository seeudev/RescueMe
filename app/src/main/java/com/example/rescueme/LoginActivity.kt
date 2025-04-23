package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.rescueme.app.RescueMe
import com.example.rescueme.utils.toast
import com.example.rescueme.utils.txt

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)

        val etUsername = findViewById<EditText>(R.id.et_loginuser)
        val etPassword = findViewById<EditText>(R.id.et_loginpassword)

        // Retrieve stored credentials from the application class
        etUsername.setText((application as RescueMe).getUsername())
        etPassword.setText((application as RescueMe).getPassword())

        val btnLogin = findViewById<Button>(R.id.button_login)
        btnLogin.setOnClickListener {
            val username = etUsername.txt()
            val password = etPassword.txt()

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                this.toast("Please fill in both username and password.")
                return@setOnClickListener
            }

            // Validate credentials
            val app = application as RescueMe
            if (username == app.getUsername() && password == app.getPassword()) {
                // Set the name property before navigating
                app.setName("User") // Replace "User" with the actual name if available
                startActivity(Intent(this, LandingActivity::class.java))
            } else {
                this.toast("Invalid Username or Password")
            }
        }

        val btnRegister = findViewById<Button>(R.id.button_register)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}