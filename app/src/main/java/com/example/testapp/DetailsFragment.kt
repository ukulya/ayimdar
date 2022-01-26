package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.database.Contact
import com.example.testapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details){
    private lateinit var listener: OnFragmentClickListener
    private var fragmentDetailsBinding: FragmentDetailsBinding? = null
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailsBinding.bind(view)
        fragmentDetailsBinding = binding

        binding.apply {
            val userID = arguments?.getLong("id",-1L) ?: -1L // Elvis Operator
            val e = dbInstance.contactDao().getById(userID)
            txtName.setText(e.name)
            txtPhone.setText(e.phone)

            btnSave.setOnClickListener {
                val e = Contact(
                    id = userID,
                    name = txtName.text.toString(),
                    phone = txtPhone.text.toString(),
                )
                dbInstance.contactDao().update(e)
            }
        }
    }

    override fun onDestroyView() {
        fragmentDetailsBinding = null
        super.onDestroyView()
    }
}