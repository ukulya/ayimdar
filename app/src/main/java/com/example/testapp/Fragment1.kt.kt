package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment_1) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.frg1_btn).setOnClickListener {
            view.findViewById<AppCompatTextView>(R.id.frg2_txt).text = view.findViewById<AppCompatEditText>(R.id.frg1_input).text.toString()
        }
    }

}