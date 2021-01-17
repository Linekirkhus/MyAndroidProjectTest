package com.example.amazingapp


import android.content.Intent
import android.os.Bundle
import android.util.Patterns

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var tv_username: TextView
    private lateinit var tv_password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        val registerBtn = findViewById<TextView>(R.id.new_user)
        registerBtn.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
            finish()
        }


        val loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        tv_username = findViewById<TextView>(R.id.email)
        if (tv_username.text.toString().isEmpty()) {
            tv_username.error = "Please enter Email"
            tv_username.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(tv_username.text.toString()).matches()) {
            tv_username.error = "Please enter valid email"
            tv_username.requestFocus()
            return
        }

        tv_password = findViewById<TextView>(R.id.password)
        if (tv_password.text.toString().isEmpty()) {
            tv_password.error = "Please enter password"
            tv_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(tv_username.text.toString(), tv_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }
    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {

            if (currentUser.isEmailVerified) {

                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {

                Toast.makeText(
                    baseContext, "Please verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                baseContext, "Login failed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
