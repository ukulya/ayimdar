package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.database.Contact
import java.text.FieldPosition

class SimpleAdapter(
    private val click: (contact: Contact) -> Unit,
    private val clickRemove: (id: Long,position: Int) -> Unit,
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
    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click,clickRemove)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (contact: Contact) -> Unit,
        private val clickRemove: (id: Long,adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Contact,adapterPosition: Int) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_text)
            val btnShow = itemView.findViewById<AppCompatButton>(R.id.btn_show)
            val btnRemove = itemView.findViewById<AppCompatButton>(R.id.btnRemove)
            txt.text = item.name
            btnShow.setOnClickListener {
                click.invoke(item)
            }
            btnRemove.setOnClickListener {
                clickRemove.invoke(item.id ?: -1,adapterPosition) // elvis operator
            }
        }

    }

}