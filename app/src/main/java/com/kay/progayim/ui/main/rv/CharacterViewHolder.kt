package com.kay.progayim.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kay.progayim.data.models.CharacterEntity
import com.kay.progayim.databinding.ItemCharacterBinding

class CharacterViewHolder(
    private val binding: ItemCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterEntity) {
        with(binding){
            Glide.with(itemView.context).load(item.image).into(ivImage)
            tvName.text = item.name
        }
    }
    
    companion object {
        fun create(parent: ViewGroup, listener: CharacterAdapter.Listener): CharacterViewHolder {

            val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context))

            return CharacterViewHolder(binding).apply {
                itemView.setOnClickListener {
                    listener.onClick(adapterPosition)
                }
            }
        }
    }


}