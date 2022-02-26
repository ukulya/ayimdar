package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.database.Contact
import com.example.testapp.databinding.FragmentDetailsBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
            dbInstance.contactDao().getById(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { // для single
                    txtName.setText(it.name)
                    txtPhone.setText(it.phone)
                }
                .subscribe()


            btnSave.setOnClickListener {
                val e = Contact(
                    id = userID,
                    name = txtName.text.toString(),
                    phone = txtPhone.text.toString(),
                )
                dbInstance.contactDao().update(e)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete { listener.onClickOpenDetailsFragment() }
                    .subscribe()
            }
        }
    }

    override fun onDestroyView() {
        fragmentDetailsBinding = null
        super.onDestroyView()
    }
}