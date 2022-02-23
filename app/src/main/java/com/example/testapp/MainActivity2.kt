package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var btn: AppCompatButton
    private lateinit var input: AppCompatEditText
    private lateinit var text: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        input = findViewById(R.id.edit)
        text = findViewById(R.id.text)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            text.text = input.text.toString().split("\\P{L}+".toRegex())
                .filter { it.length == 3 }
                .size
                .toString()
        }
    }

}