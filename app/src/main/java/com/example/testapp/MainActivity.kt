package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var text: AppCompatTextView
    private lateinit var input: AppCompatEditText
    private lateinit var btn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.edit)
        text = findViewById(R.id.text)
        btn = findViewById(R.id.btn)
        var frequency = 0
        val punctuationChars = setOf('!', ',', ';', ':', '?', '.')
        btn.setOnClickListener {
            frequency = input.text.toString().count { char -> char in punctuationChars }

            val custom = input.text.toString()
                .replace("[^A-Za-z0-9 ]".toRegex(), "*")
            text.text = custom + " - there are $frequency of punctuation Chars"


        }
    }


}