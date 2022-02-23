package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // viewbinding
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = SimpleAdapter {
            Toast.makeText(requireContext(), "ITEM -$it", Toast.LENGTH_SHORT).show()
            listener.onClick("ITEM $it")
        }
        // интент неявный
            // кнопка - открыть неявный интент - и передать в активити тот же текст

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)

    }
}