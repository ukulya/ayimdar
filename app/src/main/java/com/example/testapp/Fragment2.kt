package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val password = view.findViewById<AppCompatEditText>(R.id.password)
        val email = view.findViewById<AppCompatEditText>(R.id.email)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)

        //email.text = preferences.getString(KEY_TEXT)

        btn.setOnClickListener {
            preferences.saveString(KEY_TEXT, email.text.toString())
        }
    }

    companion object {
        const val KEY_TEXT = "keyText"
    }
}