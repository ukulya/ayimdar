package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
                view.findViewById<AppCompatTextView>(R.id.id).text = "Character ID - ${it.id}"
                view.findViewById<AppCompatTextView>(R.id.name).text = "Name - ${it.name}"
                view.findViewById<AppCompatTextView>(R.id.status).text = "Status - ${it.status}"
                view.findViewById<AppCompatTextView>(R.id.species).text = "Species - ${it.species}"
                //view.findViewById<AppCompatTextView>(R.id.type).text = "Type - ${it.type}"
                view.findViewById<AppCompatTextView>(R.id.gender).text = "Gender - ${it.gender}"
                view.findViewById<AppCompatTextView>(R.id.origin).text = "Origin - ${it.origin.toString()}"
                view.findViewById<AppCompatTextView>(R.id.location).text = "Location - ${it.location.toString()}"

                val img = view.findViewById<AppCompatImageView>(R.id.image)
                Glide.with(view.context)
                    .load(it.image)
                    .into(img)
                view.findViewById<AppCompatTextView>(R.id.url).text = "Url - ${it.url}"
                view.findViewById<AppCompatTextView>(R.id.created).text = "Created - ${it.created}"
            }
            .subscribe()
    }
}