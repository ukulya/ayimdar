package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnButtonClicked
    private lateinit var txt1: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var input: AppCompatEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt1 = view.findViewById(R.id.frg1_txt)
        btn = view.findViewById<AppCompatButton>(R.id.frg1_btn)
        input = view.findViewById<AppCompatEditText>(R.id.frg1_input)

        btn.setOnClickListener {
            listener.onButtonClicked(
                input.text.toString(),
                action = "fr1"
            )

            //view.findViewById<AppCompatTextView>(R.id.frg2_txt).text = view.findViewById<AppCompatEditText>(R.id.frg1_input).text.toString()
        }
    }
    fun setText(value: String) {
        txt1.text = value
    }
}