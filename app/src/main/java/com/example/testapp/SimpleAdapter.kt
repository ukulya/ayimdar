package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = list[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(title: String) {
            val txt = view.findViewById<AppCompatTextView>(R.id.item_txt)
            val img = view.findViewById<AppCompatImageView>(R.id.img)
            txt.text = title


            val url = if (adapterPosition % 2 != 0){
                "https://i.ibb.co/0V3dR3W/medal.png"
            } else{
                "https://i.ibb.co/D8S84L5/star.png"
            }
            Glide.with(view.context)
                .load(url)
                .into(img)
        }
    }
}