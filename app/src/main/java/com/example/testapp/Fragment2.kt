package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class Fragment2 : Fragment(R.layout.fragment_2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.frg2_btn).setOnClickListener {
            view.findViewById<AppCompatTextView>(R.id.frg1_txt).text = view.findViewById<AppCompatEditText>(R.id.frg2_input).text.toString()
        }
    }
}