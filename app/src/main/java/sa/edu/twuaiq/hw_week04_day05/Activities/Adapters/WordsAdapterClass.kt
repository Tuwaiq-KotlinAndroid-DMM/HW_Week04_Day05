package sa.edu.twuaiq.hw_week04_day05.Activities.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.Activities.Model.WordsDataModel

class WordsAdapterClass (val Wordslist: MutableList<WordsDataModel>):
   RecyclerView.Adapter<WordsAdapterClass.WordsViewHolder>() {

    class WordsViewHolder (view : View) : RecyclerView.ViewHolder(view){

        val WordTextView: TextView = view.findViewById(R.id.word_textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val item_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,parent,false)

        return WordsViewHolder(item_layout)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val Words = Wordslist [position]

        holder.WordTextView.text = Words.Word_textView
    }
    override fun getItemCount(): Int {
        return Wordslist.size
    }
}