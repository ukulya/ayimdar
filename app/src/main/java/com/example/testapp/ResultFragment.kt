package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.testapp.databinding.FragmentFormBinding
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
            val e = dbInstance.employeeDao().getById(1L)
            txtName.text = e.name
            txtCompany.text = e.company
            txtSalary.text = e.salary
        }
    }
    override fun onDestroyView() {
        resultFragmentBinding = null
        super.onDestroyView()
    }
}