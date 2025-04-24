package com.example.rescueme

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_emergencycontactdetails)

        val imageViewPhoto = findViewById<ImageView>(R.id.imageview_photo)
        val textviewName = findViewById<TextView>(R.id.tv_screen_name)
        val textviewNumber = findViewById<TextView>(R.id.tv_screen_number)

        intent?.let{
            it?.getIntExtra("photo",R.drawable.emergency)?.let{photoId ->
                imageViewPhoto.setImageResource(photoId)
            }
            it?.getStringExtra("name")?.let{name ->
                textviewName.setText(name)
            }
            it?.getStringExtra("number")?.let{number ->
                textviewNumber.setText(number)
            }

        }

        val btnBack = findViewById<ImageButton>(R.id.back_button)
        btnBack.setOnClickListener {
            startActivity(
                Intent(this, EmergencyContactActivity::class.java)
            )
        }
    }
}