package sa.edu.twuaiq.hw_week04_day05.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.activities.MainActivity
import sa.edu.twuaiq.hw_week04_day05.model.TextModel

class TextRecyclerViewAdapter(
    val text: MainActivity,
    val textList: MutableList<TextModel>): RecyclerView.Adapter
    <TextRecyclerViewAdapter.TextViewHolder>(){
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNameTextView: TextView = view.findViewById(R.id.activity_save_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val words_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return TextViewHolder(words_layout)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val words = textList[position]

        holder.textNameTextView.text = text.textContent
    }

    override fun getItemCount(): Int {
        return textList.size
    }
}
