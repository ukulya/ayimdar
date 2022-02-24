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
        var charA: Int
        var maxWord = ""
        btn.setOnClickListener {

            /*text.text = input.text.toString().split("\\P{L}+".toRegex())
                .filter { it.count { it == 'o'} == 1 }
                .size
                .toString()*/

            val str = input.text.toString().split("\\P{L}+".toRegex())
            str.forEach {
                if(it.contains("a")){
                    charA = it.count { char -> char == 'a' }
                    if(frequency < charA){
                        frequency = charA
                        maxWord = it
                    }
                }
            }
            text.text = maxWord + " has - $frequency a char "
        }
    }


}