package com.example.testapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val btn3 = binding.btn3

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.text = "new btn bind"

        // мы внутри этого объекта
        binding.apply {
            btn2.text = "new btn bind 2"
            btn4.setOnClickListener{
            startActivity(
                    Intent(this@MainActivity,MainActivity2::class.java)
                )
            }
        }
    }
}