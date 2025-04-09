package com.example.rescueme.app

import android.app.Application

class RescueMe: Application() {
    private var name: String=""
    private var username: String=""
    private var password: String=""
    private var age: Int=0
    private var email: String=""
    fun getName(): String{
        return name
    }
    fun getUsername(): String{
        return username
    }
    fun getPassword(): String{
        return password
    }
    fun getAge(): Int{
        return age
    }
    fun getEmail(): String{
        return email
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
    fun setAge(value: Int){
        this.age=value
    }
    fun setEmail(value: String){
        this.email=value
    }
}