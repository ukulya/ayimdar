package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var toolbar: Toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.item1 -> requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Fragment3())
                    .addToBackStack(null)
                    .commit()
            }
            true

        }
    }
}