package com.example.testapp


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Fragment : Fragment(R.layout.fragment) {
    private val episodesApi get() = Injector.episodesApi
    private lateinit var listener: OnItemClickListener
    private lateinit var adapter: SimpleAdapter
    private lateinit var swipeContainer: SwipeRefreshLayout
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClickListener
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeContainer = view.findViewById(R.id.swipeContainer)
        adapter = SimpleAdapter(
            click = {
                listener.onClick(it!!)
            }

        )

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(requireContext())


        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        fetchCharacters()
        swipeContainer.setOnRefreshListener {

            fetchCharacters()
        }
        swipeContainer.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(requireContext(), R.color.black))
        swipeContainer.setColorSchemeColors(R.color.teal_200)

    }
    private fun fetchCharacters(){
        episodesApi.getEpisodes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext{
                adapter.setData(it)
                swipeContainer.setRefreshing(false)
            }
            .subscribe()
    }
}