package com.example.testapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var txt: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var listener: OnFragmentClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.txt)

        val text = arguments?.getString("key") ?: "defaultText"
        txt.text = text

        btn = view.findViewById(R.id.btnOpen)

        btn.setOnClickListener {
            //listener.onClick(text)

            val intent = Intent("myAction")
            intent.putExtra("key", text)
            startActivity(intent)

        }

    }

    companion object {
        const val TAG = "Fragment2"
    }
}