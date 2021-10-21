package sa.edu.twuaiq.hw_week04_day05.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class WordAdapter(val context: Context, val words: MutableList<WordModel>): RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val wordTextView: TextView = view.findViewById(R.id.word_textView)
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