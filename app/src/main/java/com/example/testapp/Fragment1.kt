package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {
    private val preferences get() = Injector.preferences
    private lateinit var listener: OnFragmentClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val password = view.findViewById<AppCompatEditText>(R.id.password)
        val email = view.findViewById<AppCompatEditText>(R.id.email)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            preferences.saveString(KEY_TEXT, email.text.toString())
            listener.onClick(preferences.getString(KEY_TEXT))
        }
    }

    companion object {
        const val KEY_TEXT = "keyText"
        const val KEY_TEXT_2 = "keyText2"
    }
}