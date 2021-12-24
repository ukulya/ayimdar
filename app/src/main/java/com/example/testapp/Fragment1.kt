package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {
    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<AppCompatEditText>(R.id.password)
        val edit = view.findViewById<AppCompatEditText>(R.id.email)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)

        txt.text = preferences.getString(KEY_TEXT)

        btn.setOnClickListener {
            preferences.saveString(KEY_TEXT, edit.text.toString())
        }
    }

    companion object {
        const val KEY_TEXT = "keyText"
    }
}