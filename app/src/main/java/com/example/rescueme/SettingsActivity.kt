package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_listviewsettings)
        //List View Implementation
        val listView=findViewById<ListView>(R.id.listview)
        val settingList = listOf("Dark Mode","About the Devs","Send Feedback","Reminders")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,settingList)
        listView.adapter=arrayAdapter

        //Back
        val buttonBack = findViewById<ImageButton>(R.id.back_button)
        buttonBack.setOnClickListener {
            Log.e("This is CSIT284","Back button is clicked!")
            Toast.makeText(this,"The Back button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this,LandingActivity::class.java)
            startActivity(intent)
        }
    }
}