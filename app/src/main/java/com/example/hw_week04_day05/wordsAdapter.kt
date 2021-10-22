package com.example.hw_week04_day05

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_week04_day05.Activities.WordsData

class wordsAdapter(val context: Context, val wordsList: MutableList<WordsData>):
    RecyclerView.Adapter<wordsAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val WordextView: TextView = view.findViewById(R.id.word_text_view)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val product_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.items_layout,
            parent,
            false
        )
        return ProductViewHolder(product_layout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = wordsList[position].roomWords
        holder.WordextView.text = product


    }

    override fun getItemCount(): Int {
        return wordsList.size
    }


}