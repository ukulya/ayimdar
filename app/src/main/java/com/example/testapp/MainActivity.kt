package com.example.testapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat.setBackground
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var txtView: TextView
    private lateinit var rootLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtView = findViewById(R.id.text)
        rootLayout = findViewById(R.id.root_layout)

        val btn1 = findViewById<AppCompatButton>(R.id.btn1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn2)
        val btn3 = findViewById<AppCompatButton>(R.id.btn3)

        btn1.setOnClickListener {
            txtView.text = "RED"
            rootLayout.setBackgroundColor(Color.RED)
        }

        btn2.setOnClickListener {
            txtView.text = "YELLOW"
            rootLayout.setBackgroundColor(Color.YELLOW)
        }

        btn3.setOnClickListener {
            txtView.text = "GREEN"
            rootLayout.setBackgroundColor(Color.GREEN)
        }

    }
}