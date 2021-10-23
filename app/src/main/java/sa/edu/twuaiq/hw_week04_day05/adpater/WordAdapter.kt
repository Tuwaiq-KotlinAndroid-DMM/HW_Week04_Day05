package sa.edu.twuaiq.hw_week04_day05.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class WordAdapter(val context: Context, val wordList: MutableList<WordModel> ): RecyclerView.Adapter<WordHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val word_layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return WordHolder(word_layout)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.word.text = wordList[position].words



    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}