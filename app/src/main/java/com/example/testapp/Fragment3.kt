package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar

class Fragment3 : Fragment(R.layout.fragment3) {
    private lateinit var toolbar: Toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu3)

        /*toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }*/
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.item2 -> requireActivity().supportFragmentManager.beginTransaction() // -> onBackPressed()
                    .replace(R.id.fragment_container, Fragment2())
                    .addToBackStack(null)
                    .commit()
            }
            true

        }
    }

}
