package com.example.amazingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val intent = intent
        val receivedMail = intent.getStringExtra("emailAddress")
        textViewWelcome.text = "Welcome " + receivedMail
    }
}

// Login and Home Activity are the only ones updated start from there..