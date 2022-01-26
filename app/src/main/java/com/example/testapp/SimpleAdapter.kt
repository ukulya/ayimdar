package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.database.Contact


class SimpleAdapter(
    private val click: (contact: Contact) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private val list = mutableListOf<Contact>()

    fun setData(item: Contact) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun setContactList(contactList: List<Contact>){
        list.clear()
        list.addAll(contactList)
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
        private val click: (contact: Contact) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Contact) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_text)
            val btnShow = itemView.findViewById<AppCompatButton>(R.id.btn_show)
            txt.text = item.name
            btnShow.setOnClickListener {
                click.invoke(item)

            }
        }

    }

}