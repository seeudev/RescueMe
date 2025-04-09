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
import com.example.rescueme.app.RescueMe
import com.example.rescueme.utils.toast
import com.example.rescueme.utils.isValidEntry
import com.example.rescueme.utils.txt

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)


        val et_username = findViewById<EditText>(R.id.et_loginuser)
        val et_password = findViewById<EditText>(R.id.et_loginpassword)


        val button_login = findViewById<Button>(R.id.button_login)
//        val username=""
//        val password=""

        //Intent pass
//        intent?.let{
//            it.getStringExtra("username")?.let { username->
//                et_username.setText(username)
//            }
//            it.getStringExtra("password")?.let { password ->
//                et_password.setText(password)
//            }
//        }
        et_username.setText(((application as RescueMe).getUsername()))
        et_password.setText((application as RescueMe).getPassword())

        val button_register = findViewById<Button>(R.id.button_register)
        button_register.setOnClickListener {
            Log.e("This is CSIT284","Register button is clicked!")
            Toast.makeText(this,"The register button is clicked!",Toast.LENGTH_LONG).show()
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        button_login.setOnClickListener {
            if(et_username.isValidEntry()||et_password.isValidEntry()){
                this.toast("Username and password is empty")
                return@setOnClickListener
            }else{
                if(et_username.txt()==(application as RescueMe).getUsername()
                            && et_password.txt()==(application as RescueMe).getPassword()){
                    startActivity(
                        Intent(this, LandingActivity::class.java).apply {
                            putExtra("username",et_username.txt())
                            putExtra("password",et_password.txt())
                        })
                }else{
                    this.toast("Invalid Username or Password")
                    return@setOnClickListener
                }

            }


        }

//        button_login.setOnClickListener {
//            Log.e("This is CSIT284","Login button is clicked!")
//            Toast.makeText(this,"The login button is clicked!",Toast.LENGTH_LONG).show()
//            val intent = Intent(this,LandingActivity::class.java)
//            startActivity(intent)
//        }

    }
}