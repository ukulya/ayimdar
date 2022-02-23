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
    private lateinit var adapter: SimpleAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(requireContext())

        adapter = SimpleAdapter(
            click = {
                listener.onClick("ITEM $it")
            },
            deleteClick = {
                listener.onLongClick(it)
            }
        )
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        val list = ArrayList<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)
        //adapter.removeItem(Int)
    }

}