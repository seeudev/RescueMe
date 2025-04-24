package com.example.rescueme.app

import android.app.Application
import com.example.rescueme.R
import com.example.rescueme.data.EmergencyContact

class RescueMe: Application() {
    private var name: String=""
    private var username: String=""
    private var password: String=""
    fun getName(): String{
        return name
    }
    fun getUsername(): String{
        return username
    }
    fun getPassword(): String{
        return password
    }
    fun setName(value: String){
        this.name=value
    }
    fun setUsername(value: String){
        this.username=value
    }
    fun setPassword(value: String){
        this.password=value
    }
    //Recycler View Data
    //Default Data
    private val emergencyContacts = mutableListOf(
        EmergencyContact("Cebu Fire Dept.", "911", R.drawable.emergency),
        EmergencyContact("Cebu Police Dept.", "921", R.drawable.emergency),
        EmergencyContact("Cebu Medical Dept.", "931", R.drawable.emergency)
    )
    fun getEmergencyContacts(): List<EmergencyContact> = emergencyContacts
    fun addEmergencyContact(contact: EmergencyContact) {
        emergencyContacts.add(contact)
    }
    fun removeEmergencyContact(contact: EmergencyContact) {
        emergencyContacts.remove(contact)
    }
}