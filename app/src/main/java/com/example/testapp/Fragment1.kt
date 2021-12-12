package com.example.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<AppCompatButton>(R.id.btn1).setOnClickListener{
            view.findViewById<AppCompatImageView>(R.id.imgview).setImageResource(R.drawable.fb)
        }
        view.findViewById<AppCompatButton>(R.id.btn2).setOnClickListener{
            view.findViewById<AppCompatImageView>(R.id.imgview).setImageResource(R.drawable.ig)
        }
        view.findViewById<AppCompatButton>(R.id.btn3).setOnClickListener{
            view.findViewById<AppCompatImageView>(R.id.imgview).setImageResource(R.drawable.wa)
        }
    }
}