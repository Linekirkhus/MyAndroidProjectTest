package com.example.amazingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()
       // val intent = intent
     //   val receivedMail = intent.getStringExtra("emailAddress")
   //     textViewWelcome.text = "Welcome " + receivedMail
    }
}

// Login and Home Activity are the only ones updated start from there..