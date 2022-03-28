package com.kay.progayim.ui.main.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.data.models.CharacterEntity

class CharacterAdapter(private val listener: Listener): RecyclerView.Adapter<CharacterViewHolder>() {

    private val items = arrayListOf<CharacterEntity>()


    fun setNewItems(list: List<CharacterEntity>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent,listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
       return items.count()
    }

    interface Listener{
        fun onClick(index: Int)
    }

}