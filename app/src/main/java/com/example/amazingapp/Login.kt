package com.example.amazingapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        setContentView(R.layout.activity_login)
        textViewSignUpLink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val onClickListener = login_btn.setOnClickListener {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (editTextEmail.text, toString().isNullOrEmpty() || editTextPassword.text.toString().isNullOrEmpty())
            textViewResponse.text = "Email Address or Password is not Provided"

            else {
            auth.signInWithEmailAndPassword(
                editTextEmail.text.toString(),
                editTextPassword.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        textViewResponse.text = "Signin Successfull."
                        val user = auth.currentUser
                        updateUI(user, editTextEmail.text.toString())
                    } else
                        textViewResponse.text = "Invalid Email or Password"
                }
        }
        }

/*
        val createAccount = findViewById<TextView>(R.id.new_user)
        createAccount.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
            finish()
        }
        val loginButton = findViewById<Button>(R.id.login_btn)
        loginButton.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin() {
        val tv_username = findViewById<TextView>(R.id.email)
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
        val tv_password = findViewById<TextView>(R.id.password)
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

 */
            }
    }


/*
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

 */

    private fun updateUI(currentUser: FirebaseUser?, emailAdd: String) {

        if (currentUser != null) {

            if (currentUser.isEmailVerified) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
                // startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(
                    this, "Email is not verified. Please verify your email address.",
                    Toast.LENGTH_LONG
                ).show()

                // Toast.makeText(
                //  baseContext, "Please verify your email address.",
                //  Toast.LENGTH_SHORT
            }
        }
        /*
        } else {
            Toast.makeText(
                baseContext, "Login failed.",
                Toast.LENGTH_SHORT
            ).show()
        }

         */
        // Add onstart auto sign in next time app starts
        public override fun onStart(){
            super.onStart()
            val currentUser = auth.currentUser
            updateUI(currentUser, currentUser?.email.toString())
        }
    }
