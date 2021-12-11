package com.example.testapp

import android.content.ClipDescription
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.btn).setOnClickListener {
            val recipient = findViewById<AppCompatEditText>(R.id.email).text.toString().trim()
            val subj = findViewById<AppCompatEditText>(R.id.subject).text.toString().trim()
            val message = findViewById<AppCompatEditText>(R.id.text).text.toString().trim()
            /*val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            intent.putExtra(Intent.EXTRA_SUBJECT, subj)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, ""))*/

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = ClipDescription.MIMETYPE_TEXT_PLAIN
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            intent.putExtra(Intent.EXTRA_SUBJECT,subj)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            //startActivity(Intent.createChooser(intent,"Send Email"))

            /*val intent = Intent(Intent.ACTION_SEND)
            val data = Uri.parse(
                "mailto:" + recipient + "?subject=" + Uri.encode(subj) + "&body=" + Uri.encode(
                    message
                )
            )
            intent.data = data*/
            //startActivity(intent)


            try {
                startActivity(Intent.createChooser(intent,"Choose email client"))
                //startActivity(intent)
            } catch (e: Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
            }
        }


    }





}