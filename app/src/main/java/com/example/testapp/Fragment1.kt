package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {

    private lateinit var emailInput: AppCompatEditText
    private lateinit var passInput: AppCompatEditText
    private lateinit var listener: OnFragmentClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailInput = view.findViewById(R.id.inputEmail)
        passInput = view.findViewById(R.id.inputPassword)


        view.findViewById<AppCompatButton>(R.id.btn).setOnClickListener {
            if (TextUtils.isEmpty(emailInput.text.toString()) || TextUtils.isEmpty(passInput.text.toString())) {
                Toast.makeText(requireContext(),
                    "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(),
                    "Proceed..",
                    Toast.LENGTH_SHORT).show()
                listener.onClick()
            }
        }

    }
}
