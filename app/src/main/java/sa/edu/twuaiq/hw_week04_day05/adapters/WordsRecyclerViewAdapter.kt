package sa.edu.twuaiq.hw_week04_day05.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.models.WordsDataModel

class WordsRecyclerViewAdapter(val context: Context, val wordsList: MutableList<WordsDataModel>):
  RecyclerView.Adapter<WordsRecyclerViewAdapter.WordsViewHolder>() {



    class WordsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val wordTextView: TextView = view.findViewById(R.id.WordtextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val item_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false)
        return WordsViewHolder(item_layout)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {

        holder.wordTextView.text = wordsList[position].wordText

    }

    override fun getItemCount(): Int {
        return wordsList.size
    }


}