package com.example.roomwordssample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsRecyclerViewAdapter(val context: Context, val wordsList: MutableList<WordsModel>): RecyclerView.Adapter<WordsRecyclerViewAdapter.WordsViewHolder> () {



    class WordsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val wordsNameText: TextView = view.findViewById(R.id.words_name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val word_layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return WordsViewHolder(word_layout)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
       val word = wordsList[position]
        holder.wordsNameText.text = word.wordsNameText

        holder.itemView.setOnClickListener{val intent = Intent(context, AddWord::class.java)
        intent.putExtra("word_name", word.wordsNameText)
            context.startActivity(intent)
        }


     }

    override fun getItemCount(): Int {
return wordsList.size
    }
}

