package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.database.Contact
import com.example.testapp.databinding.FragmentResultBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResultFragment : Fragment(R.layout.fragment_result) {
    private lateinit var listener: OnFragmentClickListener
    private var resultFragmentBinding: FragmentResultBinding? = null
    private val dbInstance get() = Injector.database

    private lateinit var adapter: SimpleAdapter

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

            adapter = SimpleAdapter(
                click = {
                    listener.onClick(it.id!!)
                },
                clickRemove = { id: Long, pos: Int ->
                    onClickItemRemove(id,pos)
                }
            )

            recycler.adapter = adapter
            dbInstance.contactDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {adapter.setContactList(it) }
                .subscribe()

            btnAdd.setOnClickListener {
                listener.onClickOpenFormFragment()
            }

        }
    }

    private fun onClickItemRemove(id: Long,position: Int) {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Are you sure you wanna delete?")
        builder.setMessage("We have a message")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(
                requireContext(),
                android.R.string.yes, Toast.LENGTH_SHORT
            ).show()

            dbInstance.contactDao().getById(id)
                .subscribeOn(Schedulers.io())
                .flatMapCompletable {
                    dbInstance.contactDao().delete(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnComplete {}
                .subscribe()

            adapter.removeAt(position)

        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(
                requireContext(),
                android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }

        builder.show()
    }

    override fun onDestroyView() {
        resultFragmentBinding = null
        super.onDestroyView()
    }
}