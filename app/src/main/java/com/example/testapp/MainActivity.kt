package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
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

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        //menu?.add("menu 1")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        toolbar.title = item.title
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment2())
            .addToBackStack(null)
            .commit()
        findViewById<AppCompatButton>(R.id.btn).visibility = View.INVISIBLE
        return super.onOptionsItemSelected(item)
    }
}