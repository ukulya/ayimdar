package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            getPreferences(MODE_PRIVATE)
            val prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)

            email.text = prefs.getString(KEY_TEXT, "defValue")
            password.text = prefs.getString(KEY_TEXT_2, "defValue")

            btn.setOnClickListener {
                val editor = prefs.edit()
                editor.putString(KEY_TEXT, email.text.toString())
                editor.apply()
            }

            btn.setOnClickListener {
                val editor = prefs.edit()
                editor.putString(KEY_TEXT_2, password.text.toString())
                editor.apply()
            }
        }
    }

    companion object {
        private const val KEY_TEXT = "keyText"
        private const val KEY_TEXT_2 = "keyText2"
    }
}