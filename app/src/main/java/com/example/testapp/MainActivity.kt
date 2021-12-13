package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity(),OnButtonClicked {
    private lateinit var txt1: AppCompatTextView
    private lateinit var txt2: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //txt1 = findViewById(R.id.frg1_txt)
        //txt2 = findViewById(R.id.frg2_txt)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_1, Fragment1())
            .add(R.id.fragment_container_2, Fragment2())
            .commit()

    }
    override fun onButtonClicked(enteredText: String,action: String) {
        if (action === "fr1"){
            val fr2 = supportFragmentManager.findFragmentById(R.id.fragment_container_2) as Fragment2
            fr2.setText(enteredText)
        } else {
            val fr1 = supportFragmentManager.findFragmentById(R.id.fragment_container_1) as Fragment1
            fr1.setText(enteredText)
        }

    }
}