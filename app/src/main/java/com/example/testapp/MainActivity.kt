package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var passInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.inputEmail)
        passInput = findViewById(R.id.inputPassword)


        findViewById<AppCompatButton>(R.id.btn).setOnClickListener {
            if (TextUtils.isEmpty(emailInput.text.toString()) || TextUtils.isEmpty(passInput.text.toString())) {
                Toast.makeText(this,
                    "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                    "Proceed..",
                    Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, Fragment1())
                    .addToBackStack(null)
                    .commit()
                findViewById<AppCompatButton>(R.id.btn).visibility = View.INVISIBLE
            }

        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("email", emailInput.text.toString())
        outState.putString("pass", passInput.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //emailInput.text = savedInstanceState.getString("email")
        //passInput.text = savedInstanceState.getString("key")
    }
}