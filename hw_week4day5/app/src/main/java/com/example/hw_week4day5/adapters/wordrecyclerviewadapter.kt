package com.example.hw_week4day5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_week4day5.models.worddatamodel

class wordrecyclerviewadapter(val context: Context,val alist:MutableList<worddatamodel>):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layout=LayoutInflater.from(parent.context).inflate(R.layout.activity_word,parent,false)
    return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.wordtext.text=alist[position].word


    }

    override fun getItemCount(): Int {
        return alist.size
    }
}


class ViewHolder(view: View): RecyclerView.ViewHolder(view)
{
   var wordtext: TextView =view.findViewById(R.id.wordtext)
}