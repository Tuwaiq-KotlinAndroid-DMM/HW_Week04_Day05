package sa.edu.twuaiq.hw_week04_day05.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.WordModel

class WordAdapter(val context: Context, val WordList: MutableList<WordModel>): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(view: View): RecyclerView.ViewHolder(view){
        val wordTextView: TextView = view.findViewById(R.id.word_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val word_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return WordViewHolder(word_layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = WordList[position]
        holder.wordTextView.text = word.wordName
    }

    override fun getItemCount(): Int { return  WordList.size }


}