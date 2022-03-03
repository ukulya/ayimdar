package com.example.testapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SimpleAdapter(
    private val click: (pos: Long?) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<Characters>()

    fun setData(list: List<Characters>) {
        this.list = list
        notifyDataSetChanged()
        Log.e( "tag","setdata render")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (pos: Long?) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Characters) { // viewbinding
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_text)
            txt.text = item.results?.name ?: ""
//            itemView.findViewById<AppCompatTextView>(R.id.status).text = item.status
//            itemView.findViewById<AppCompatTextView>(R.id.species).text = item.species
//            itemView.findViewById<AppCompatTextView>(R.id.location).text = item.location.toString()
//            val img = itemView.findViewById<AppCompatImageView>(R.id.image)
//            Glide.with(itemView.context)
//                .load(item.image)
//                .into(img)
            itemView.setOnClickListener {
                click.invoke(item.results?.id)

            }
        }

    }

}