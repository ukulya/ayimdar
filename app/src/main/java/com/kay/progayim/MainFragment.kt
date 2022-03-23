package com.kay.progayim

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kay.progayim.databinding.FragmentMainBinding
import com.kay.progayim.extensions.showToast

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
        Log.d("VM", vm.hashCode().toString())

        binding.button.setOnClickListener {
            vm.deleteEpisodes()
        }

    }

    private fun subscribeToLiveData(){
        vm.charactersLiveData.observe(viewLifecycleOwner, {
            binding.tvEpisodes.text =  if(it.isEmpty()) "" else it[0].episode.toString()
        })

        vm.event.observe(viewLifecycleOwner, {
            when(it){
                is Event.ShowToast -> showToast(getString(it.resId))
                is Event.ShowLoadingToast -> showToast(getString(R.string.loading))
                is Event.ShowFinishedLoadingToast -> showToast(getString(R.string.finished_loading))
            }
        })

        vm.episodesCounterViaMap.observe(viewLifecycleOwner,{
            binding.tvCounter.text = it.toString()
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        vm.clearEvents()
    }

}