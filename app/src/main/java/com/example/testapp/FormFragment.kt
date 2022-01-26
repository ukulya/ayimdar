package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.testapp.database.Contact
import com.example.testapp.databinding.FragmentFormBinding

class FormFragment : Fragment(R.layout.fragment_form) {
    private lateinit var listener: OnFragmentClickListener
    private var fragmentFormBinding: FragmentFormBinding? = null
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFormBinding.bind(view)
        fragmentFormBinding = binding

        binding.apply {
            btnSave.setOnClickListener {
                val e = Contact(
                    name = txtName.text.toString(),
                    phone = txtCompany.text.toString(),
                )
                dbInstance.contactDao().insert(e)
                listener.onClickOpenDetailsFragment()
            }
        }
    }

    override fun onDestroyView() {
        fragmentFormBinding = null
        super.onDestroyView()
    }

}