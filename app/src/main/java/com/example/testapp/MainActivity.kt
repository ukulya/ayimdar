package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var text: AppCompatTextView
    private lateinit var btn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerLauncher()

        text = findViewById(R.id.text)

        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            launcher.launch(Intent(this, MainActivity2::class.java))
        }
    }
    private fun registerLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                text.text = it.data?.getStringExtra("editText") ?: "default"
            }
        }
    }

}