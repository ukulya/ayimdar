package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class SimpleAdapter(
    private val click: (pos: Int) -> Unit,
    private val deleteClick: (pos: Int) -> Unit,
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = ArrayList<String>()

    fun setData(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click,deleteClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ViewHolder(
        itemView: View,
        private val click: (pos: Int) -> Unit,
        private val deleteClick: (pos: Int) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) { // viewbinding
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_text)
            txt.text = item
            itemView.setOnClickListener {
                click.invoke(adapterPosition)
            }
            itemView.setOnLongClickListener{
                deleteClick.invoke(adapterPosition)
                true
            }
        }

    }

}