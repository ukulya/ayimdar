package com.kay.progayim.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kay.progayim.databinding.FragmentMainBinding
import com.kay.progayim.extensions.showToast
import com.kay.progayim.ui.details.DetailsFragment
import com.kay.progayim.ui.Event
import com.kay.progayim.ui.FragmentListener
import com.kay.progayim.ui.main.rv.CharacterAdapter
import java.lang.Exception

class MainFragment: Fragment(), CharacterAdapter.Listener {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
    get() = _binding!!

    private lateinit var fragmentListener: FragmentListener

    private lateinit var vm: MainViewModel
    private val characterAdapter: CharacterAdapter = CharacterAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentListener = context as FragmentListener
        } catch (e: Exception){ print("Activity must implement FragmentListener")}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        subscribeToLiveData()
        Log.d("VM", vm.hashCode().toString())

       /* binding.button.setOnClickListener {
            vm.deleteEpisodes()
        }*/

    }

    private fun setupViews() {
        with(binding){
            rvCharacters.adapter = characterAdapter
            swipeRefresh.setOnRefreshListener {
                vm.loadCharacters()
            }
        }
    }

    private fun subscribeToLiveData(){
        vm.charactersLiveData.observe(viewLifecycleOwner, {
            characterAdapter.setNewItems(it)
        })

        vm.event.observe(viewLifecycleOwner, {
            when(it){
                is Event.ShowToast -> showToast(getString(it.resId))
                is Event.ShowLoading -> binding.swipeRefresh.isRefreshing = true
                is Event.StopLoading -> binding.swipeRefresh.isRefreshing = false
            }
        })

       /* vm.episodesCounterViaMap.observe(viewLifecycleOwner,{
            binding.tvCounter.text = it.toString()
        })*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        vm.clearEvents()
        _binding = null
    }

    override fun onClick(index: Int) {
        vm.getCharacterByIndex(index)?.let {
            fragmentListener.openFragment(DetailsFragment.newInstance(it.char_id))
        }
    }
}