/*
package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.testapp.databinding.FragmentDeleteBinding

class DeleteFragment : Fragment(R.layout.fragment_delete) {
    private lateinit var listener: OnFragmentClickListener
    private var fragmentDeleteBinding: FragmentDeleteBinding? = null
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDeleteBinding.bind(view)
        fragmentDeleteBinding = binding

        binding.apply {
            btnSave.setOnClickListener {
                val e = dbInstance.employeeDao().getById(1L) // ИЗ-ЗА разных hash-code не мог удалить
                // лучше удалять таким образом,чем прописывать поля и id
                dbInstance.employeeDao().delete(e)
                listener.onClick()
            }
        }
    }

    override fun onDestroyView() {
        fragmentDeleteBinding = null
        super.onDestroyView()
    }

}*/
