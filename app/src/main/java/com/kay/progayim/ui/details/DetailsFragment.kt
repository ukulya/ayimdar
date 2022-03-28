package com.kay.progayim.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kay.progayim.databinding.FragmentDetailsBinding
import com.kay.progayim.extensions.showToast
import com.kay.progayim.ui.Event

class DetailsFragment: Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding!!

    private lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        Log.d("DETAIL_VM", viewModel.toString())
        viewModel.setId(arguments?.getLong(Long::class.java.canonicalName))

        viewModel.fetchCharacter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner,{
            when(it){
                is Event.FetchedCharacter -> binding.textView.text = it.character.toString()
            }
        })
    }

    companion object{
        fun newInstance(id: Long): DetailsFragment {
            val args = Bundle().apply { putLong(Long::class.java.canonicalName, id) }
            return DetailsFragment().apply { arguments = args }
        }
    }

}