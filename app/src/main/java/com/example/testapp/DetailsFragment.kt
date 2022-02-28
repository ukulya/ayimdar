package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val episodesApi get() = Injector.episodesApi
    private lateinit var listener: OnItemClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong("id") ?: 1L

        episodesApi.getEpisodeById(id)
            .subscribeOn(Schedulers.io())
            .map { it.first() }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                view.findViewById<AppCompatTextView>(R.id.episode_id).text = "Episode ID - ${it.episode_id}"
                view.findViewById<AppCompatTextView>(R.id.title).text = "Title - ${it.title}"
                view.findViewById<AppCompatTextView>(R.id.season).text = "Season - ${it.season}"
                view.findViewById<AppCompatTextView>(R.id.air_date).text = "Air date - ${it.air_date}"
                view.findViewById<AppCompatTextView>(R.id.characters).text = "Characters - ${it.characters.toString()}"
                view.findViewById<AppCompatTextView>(R.id.episode).text = "Episode - ${it.episode}"
                view.findViewById<AppCompatTextView>(R.id.series).text = "Series - ${it.series}"
            }
            .subscribe()
    }
}