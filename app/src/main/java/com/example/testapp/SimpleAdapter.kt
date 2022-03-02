package com.example.testapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class SimpleAdapter(
    private val click: (pos: Long?) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<Item>()

    fun setData(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
        Log.e( "tag","setdata render")
    }

    /* Within the RecyclerView.Adapter class */

    // Clean all elements of the recycler
    fun clearData() {
        this.list = listOf()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(listNew: List<Item>) {
        this.list = listNew
        notifyDataSetChanged()
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

        fun bind(item: Item) { // viewbinding
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_text)
            txt.text = item.title

            itemView.setOnClickListener {
                click.invoke(item.episode_id)

            }
        }

    }

}