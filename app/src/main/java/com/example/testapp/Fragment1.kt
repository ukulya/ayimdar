package com.example.testapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {
    private lateinit var listener: OnButtonClicked
    private lateinit var btn1: AppCompatButton
    private lateinit var btn2: AppCompatButton
    private lateinit var btn3: AppCompatButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1 = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)
        btn3 = view.findViewById(R.id.btn3)

        btn1.setOnClickListener {
           listener.onButtonClicked(R.drawable.ig)
        }
        btn2.setOnClickListener {
            listener.onButtonClicked(R.drawable.fb)
        }
        btn3.setOnClickListener {
            listener.onButtonClicked(R.drawable.wa)
        }

    }

}