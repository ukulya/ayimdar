package com.example.testapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {
    private lateinit var emailInput: EditText
    private lateinit var passInput: EditText
    private lateinit var btn: AppCompatButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailInput = view.findViewById(R.id.inputEmail)
        passInput = view.findViewById(R.id.inputPassword)
        btn = view.findViewById(R.id.btn)

        btn.setOnClickListener {
            if (TextUtils.isEmpty(emailInput.text.toString()) || TextUtils.isEmpty(passInput.text.toString())) {
                Toast.makeText(requireContext(),
                    "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(),
                    "Proceed..",
                    Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Fragment2())
                    .commit()
            }

        }
    }
}