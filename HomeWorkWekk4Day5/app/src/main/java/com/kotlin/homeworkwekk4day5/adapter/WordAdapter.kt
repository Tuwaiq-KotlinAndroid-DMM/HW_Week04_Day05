package com.kotlin.homeworkwekk4day5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.homeworkwekk4day5.R
import com.kotlin.homeworkwekk4day5.model.WordModel


class WordAdapter(val context: Context, val words: MutableList<WordModel>): RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val wordTextView: TextView = view.findViewById(R.id.item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return ViewHolder(inflate_layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordTextView.text = words[position].word
    }

    override fun getItemCount(): Int {
        return words.size
    }
}