package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment3: Fragment(R.layout.fragment3) {
    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<AppCompatTextView>(R.id.txt)

        txt.text = preferences.getString(KEY_TEXT)
        //requireActivity().onBackPressed(finish())

    }

    companion object {
        const val KEY_TEXT = "keyText"
    }

}