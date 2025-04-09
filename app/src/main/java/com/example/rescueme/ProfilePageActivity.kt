package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfilePageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_profilepage)
        val button_save = findViewById<Button>(R.id.saveButton)
        button_save.setOnClickListener {
            Log.e("This is CSIT284","save button is clicked!")
            Toast.makeText(this,"The save button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,LandingActivity::class.java)
            startActivity(intent)
        }

    }
}