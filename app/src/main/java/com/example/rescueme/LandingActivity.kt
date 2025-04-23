package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rescueme.app.RescueMe

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_landingpage)

        // Set greeting text with the user's name
        val greetingTextView = findViewById<TextView>(R.id.tv_greeting)
        val app = application as RescueMe
        val userName = app.getName().ifEmpty { "User" } // Fallback to "User" if name is empty
        greetingTextView.text = "Hello $userName"

        // Settings button click listener
        val settingsButton = findViewById<ImageButton>(R.id.button_settings)
        settingsButton.setOnClickListener {
            Toast.makeText(this, "Settings button clicked!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        // SOS button click listener
        val sosButton = findViewById<Button>(R.id.button_sos)
        sosButton.setOnClickListener {
            Toast.makeText(this, "SOS button clicked!", Toast.LENGTH_SHORT).show()
            // Implement SOS functionality here
        }

        // Quick Assistance buttons
        findViewById<Button>(R.id.card_injury).setOnClickListener {
            Toast.makeText(this, "Navigating to Injury Assistance", Toast.LENGTH_SHORT).show()
            // Navigate to Injury Assistance screen (to be implemented)
        }

        findViewById<Button>(R.id.card_accident).setOnClickListener {
            Toast.makeText(this, "Navigating to Accident Assistance", Toast.LENGTH_SHORT).show()
            // Navigate to Accident Assistance screen (to be implemented)
        }

        findViewById<Button>(R.id.card_general_help).setOnClickListener {
            Toast.makeText(this, "Navigating to General Help", Toast.LENGTH_SHORT).show()
            // Navigate to General Help screen (to be implemented)
        }

        // Notifications card click listener
        findViewById<Button>(R.id.card_notifications).setOnClickListener {
            Toast.makeText(this, "Navigating to Notifications", Toast.LENGTH_SHORT).show()
            // Navigate to Notifications screen (to be implemented)
        }

        // Bottom navigation bar buttons
        findViewById<ImageButton>(R.id.nav_home).setOnClickListener {
            Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageButton>(R.id.nav_contacts).setOnClickListener {
            Toast.makeText(this, "Contacts selected", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, EmergencyContactActivity::class.java))
        }

        findViewById<ImageButton>(R.id.nav_emergency).setOnClickListener {
            Toast.makeText(this, "Emergency selected", Toast.LENGTH_SHORT).show()
            // Navigate to Emergency screen (to be implemented)
        }

        findViewById<ImageButton>(R.id.nav_notifications).setOnClickListener {
            Toast.makeText(this, "Notifications selected", Toast.LENGTH_SHORT).show()
            // Navigate to Notifications screen (to be implemented)
        }

        findViewById<ImageButton>(R.id.nav_profile).setOnClickListener {
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProfilePageActivity::class.java))
        }
    }
}