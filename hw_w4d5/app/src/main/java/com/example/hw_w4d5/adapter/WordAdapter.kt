package com.example.hw_w4d5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_w4d5.R
import com.example.hw_w4d5.model.WordDataClass

class WordAdapter(val context: Context,
                  val list: MutableList<WordDataClass>): RecyclerView.Adapter<WordAdapter.WordVH>() {


    class WordVH(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordVH {

        val WordVH = LayoutInflater.from(parent.context).inflate(
            R.layout.items_layout,
            parent,
            false
        )
        return WordVH(WordVH)
    }

    override fun onBindViewHolder(holder: WordAdapter.WordVH, position: Int) {
        holder.textView.text = list[position].word

    }

    override fun getItemCount(): Int {
        return list.size
    }
}