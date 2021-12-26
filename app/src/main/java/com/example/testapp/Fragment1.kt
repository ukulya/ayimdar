package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        password.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(email.text.toString().trim().isNotEmpty()){
                    btn.isEnabled = true
                }

            }
        })

        email.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(password.text.toString().trim().isNotEmpty()){
                    btn.isEnabled = true
                }
            }
        })

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