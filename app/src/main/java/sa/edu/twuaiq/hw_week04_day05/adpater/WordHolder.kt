package sa.edu.twuaiq.hw_week04_day05.adpater

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R

class WordHolder(view: View): RecyclerView.ViewHolder(view) {
    val word: TextView = view.findViewById(R.id.word_text)

}