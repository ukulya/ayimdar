package com.example.testapp


import android.annotation.SuppressLint
import android.content.ClipDescription
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import java.lang.Exception

// краш на старте

class MainActivity : AppCompatActivity() {

    val email = findViewById<AppCompatEditText>(R.id.email)
    val subject = findViewById<AppCompatEditText>(R.id.subject)
    val text = findViewById<AppCompatEditText>(R.id.text)
    val btn = findViewById<AppCompatButton>(R.id.btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val recipient = email.text.toString().trim()
            val subj = subject.text.toString().trim()
            val message = text.text.toString().trim()
            sendEmail(recipient,subj,message)
        }

    }

    private fun sendEmail(recipient: String,subj: String,message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        intent.putExtra(Intent.EXTRA_SUBJECT, subj)
        intent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(intent,"Choose email client"))
        } catch (e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }


    }



}
