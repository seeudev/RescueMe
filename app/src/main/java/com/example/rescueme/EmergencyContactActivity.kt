package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rescueme.app.RescueMe
import com.example.rescueme.data.EmergencyContact
import com.example.rescueme.helper.EmergencyContactsCustomListViewAdapter
import com.example.rescueme.helper.EmergencyContactsRecyclerViewAdapter

class EmergencyContactActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_recyclerviewemergencycontact)
        //Recycler View Implementation
        val app = application as RescueMe
        val emergencyContactList = app.getEmergencyContacts()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=EmergencyContactsRecyclerViewAdapter(emergencyContactList, onClick = {
            emergencyContact ->
                startActivity(
                    Intent(this, ContactDetailsActivity::class.java).apply{
                        putExtra("photo",emergencyContact.photoRes)
                        putExtra("name",emergencyContact.emergencycontactname)
                        putExtra("number",emergencyContact.emergencycontactnumber)
                    }
                )
        }, onLongClick = {
            emergencyContact ->
                Toast.makeText(this,"${emergencyContact.emergencycontactname} is long clicked!",Toast.LENGTH_LONG).show()
        })
//        //Custom List View Implementation
//        val listView = findViewById<ListView>(R.id.listview)
//        val emergencyContactList = listOf(
//            EmergencyContact("Cebu Fire Dept.","911",R.drawable.emergency),
//            EmergencyContact("Cebu Fire Dept.","911",R.drawable.emergency),
//            EmergencyContact("Cebu Fire Dept.","911",R.drawable.emergency)
//        )
//        val adapter = EmergencyContactsCustomListViewAdapter(this,emergencyContactList)
//        listView.adapter=adapter
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