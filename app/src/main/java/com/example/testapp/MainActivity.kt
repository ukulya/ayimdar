package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity(),OnFragmentClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()



    }
    override fun onClick() {
        val fragment2 = Fragment2()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .commit()
    }
}