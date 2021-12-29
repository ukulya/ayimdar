package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var btn: AppCompatButton
    private lateinit var input: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        input = findViewById(R.id.edit)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("editText", input.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}