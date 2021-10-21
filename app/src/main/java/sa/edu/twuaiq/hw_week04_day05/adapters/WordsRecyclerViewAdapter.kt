package  sa.edu.twuaiq.hw_week04_day05.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class WordsRecyclerViewAdapter(
    val context: Context,
    val wordsList: MutableList<WordsModel>):
    RecyclerView.Adapter<WordsRecyclerViewAdapter.WordsViewHolder>() {



    class WordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wordsNameTextView: TextView = view.findViewById(R.id.words_textview_item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val words_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return WordsViewHolder(words_layout)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val words = wordsList[position]

        holder.wordsNameTextView.text = words.wordsName
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }
}

