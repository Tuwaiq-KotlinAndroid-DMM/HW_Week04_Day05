package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Addadapter(val context: Context,
                 val addList: MutableList<Table>):
    RecyclerView.Adapter<Addadapter.hViewHolder>() {

    class hViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val NameTextView: TextView = view.findViewById(R.id.tvtext)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hViewHolder {
        val product_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return hViewHolder(product_layout)
    }

    override fun onBindViewHolder(holder: hViewHolder, position: Int) {
        holder.NameTextView.text = addList[position].productName
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Table::class.java)
            intent.putExtra("name",addList[position].productName)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return addList.size
    }




}