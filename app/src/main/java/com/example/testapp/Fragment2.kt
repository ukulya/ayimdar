package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var listener: OnButtonClicked
    private lateinit var txt2: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var input: AppCompatEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt2 = view.findViewById(R.id.frg2_txt)
        input = view.findViewById<AppCompatEditText>(R.id.frg2_input)
        btn = view.findViewById<AppCompatButton>(R.id.frg2_btn)
        btn.setOnClickListener {
            listener.onButtonClicked(
                input.text.toString(),
                action = "fr2"
            )
            //view.findViewById<AppCompatTextView>(R.id.frg1_txt).text = view.findViewById<AppCompatEditText>(R.id.frg2_input).text.toString()
        }
    }

    fun setText(value: String) {
        txt2.text = value
    }
}