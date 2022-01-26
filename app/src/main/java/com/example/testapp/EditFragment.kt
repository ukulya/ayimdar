/*
package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.testapp.database.Contact
import com.example.testapp.databinding.FragmentEditBinding

class EditFragment : Fragment(R.layout.fragment_edit) {
    private lateinit var listener: OnFragmentClickListener
    private var fragmentEditBinding: FragmentEditBinding? = null
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEditBinding.bind(view)
        fragmentEditBinding = binding

        binding.apply {
            val e = dbInstance.employeeDao().getById(1L)
            txtName.setText(e.name)
            txtCompany.setText(e.company)
            txtSalary.setText(e.salary)

            btnSave.setOnClickListener {
                val e = Contact(
                    id = 1L,
                    name = txtName.text.toString(),
                    company = txtCompany.text.toString(),
                    salary = txtSalary.text.toString()
                )
                dbInstance.employeeDao().update(e)
                listener.onClick()
            }
        }
    }

    override fun onDestroyView() {
        fragmentEditBinding = null
        super.onDestroyView()
    }

}
*/
