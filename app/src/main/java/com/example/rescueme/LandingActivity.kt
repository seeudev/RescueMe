package com.example.rescueme


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog;

class LandingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_landingpage)

        val textview_welcome_message = findViewById<TextView>(R.id.tv_welcome)

        intent?.let {
            it.getStringExtra("username")?.let { username->
                textview_welcome_message.setText("Hello $username!")
            }
        }

        val button_settings = findViewById<ImageButton>(R.id.button_settings)
        button_settings.setOnClickListener {
            Log.e("This is CSIT284","Settings button is clicked!")
            Toast.makeText(this,"The Setting button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }

        val button_home = findViewById<ImageButton>(R.id.button_home)
        button_home.setOnClickListener {
            Log.e("This is CSIT284","Home button is clicked!")
            Toast.makeText(this,"The home button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,LandingActivity::class.java)
            startActivity(intent)
        }

        val button_profile = findViewById<ImageButton>(R.id.button_profile)
        button_profile.setOnClickListener {
            Log.e("This is CSIT284","Settings button is clicked!")
            Toast.makeText(this,"The Setting button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,ProfilePageActivity::class.java)
            startActivity(intent)
        }

        val button_logout = findViewById<ImageButton>(R.id.button_logout)
        button_logout.setOnClickListener {
            Log.e("This is CSIT284","Logout button is clicked!")
            Toast.makeText(this,"The logout button is clicked!", Toast.LENGTH_LONG).show()

//            val builder = AlertDialog.Builder(this@LandingActivity)
//            builder.setMessage("Are you sure you want to Logout?")
//                .setCancelable(false)
//                .setPositiveButton("Yes") { dialog, id ->
//                    val intent = Intent(this,LoginActivity::class.java)
//                    startActivity(intent)
//                }
//                .setNegativeButton("No") { dialog, id ->
//                    // Dismiss the dialog
//                    dialog.dismiss()
//                }
//            val alert = builder.create()
//            alert.show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}