package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private lateinit var listener: OnFragmentClickListener
    private var resultFragmentBinding: FragmentResultBinding? = null
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentResultBinding.bind(view)
        resultFragmentBinding = binding
        binding.apply {

            recycler.layoutManager = LinearLayoutManager(requireContext())

            val adapter = SimpleAdapter{
                listener.onClick(it.id!!)
            }

            recycler.adapter = adapter

            adapter.setContactList(dbInstance.contactDao().getAll())

            btnAdd.setOnClickListener {
                listener.onClickOpenFormFragment()
            }
        }
    }
    override fun onDestroyView() {
        resultFragmentBinding = null
        super.onDestroyView()
    }
}