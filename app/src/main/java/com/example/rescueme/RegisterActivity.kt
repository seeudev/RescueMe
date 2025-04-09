package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rescueme.utils.isValidEntry
import com.example.rescueme.utils.toast
import com.example.rescueme.utils.txt

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_signup)

        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val fullname = findViewById<EditText>(R.id.et_fullname)

        val button_signup = findViewById<Button>(R.id.button_signup)
        button_signup.setOnClickListener {
//            Log.e("This is CSIT284","Signup button is clicked!")
//            Toast.makeText(this,"The signup button is clicked!", Toast.LENGTH_LONG).show()
            if(username.isValidEntry()
                || password.isValidEntry()
                || fullname.isValidEntry()){
                Toast.makeText(this,"Fill out fields completely.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                    startActivity(
                        Intent(this, LoginActivity::class.java).apply{
                            putExtra("username",username.text.toString())
                            putExtra("password", password.text.toString())
                        }
                    )
            }

        }
        val button_cancel = findViewById<Button>(R.id.button_cancel)
        button_cancel.setOnClickListener {
            Log.e("This is CSIT284","Cancel button is clicked!")
            Toast.makeText(this,"The cancel button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}