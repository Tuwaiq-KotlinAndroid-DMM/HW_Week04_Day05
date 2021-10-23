package sa.edu.twuaiq.hw_week04_day05.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class WordRecyclerViewAdapter(
    val context: Context,
    val wordList: MutableList<WordsModel>):
    RecyclerView.Adapter<WordRecyclerViewAdapter.WordViewHolder>() {

        class WordViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.text_words)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val word_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return WordViewHolder(word_layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            val words = wordList[position]

        holder.textView.text = words.textViewWords.toString()
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}