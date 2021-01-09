package com.example.amazingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        //val myTv = findViewById<TextView>(R.id.my_tv)

        // Write a message to the database
       // val database = Firebase.database
       // val myRef = database.getReference("message")

       // myRef.setValue("Hello, World!")
    }

}