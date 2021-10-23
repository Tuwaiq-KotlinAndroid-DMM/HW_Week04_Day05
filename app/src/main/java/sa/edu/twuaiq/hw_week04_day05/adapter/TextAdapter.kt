package sa.edu.twuaiq.hw_week04_day05.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.TextModel

class TextAdapter (
    val context: Context,
    val textlist : MutableList<TextModel>
        ): RecyclerView.Adapter<TextAdapter.TextViewHolder>(){

            class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val textview : TextView = view.findViewById(R.id.textview)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val item_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.itemlayout, parent, false)
        return TextViewHolder(item_layout)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {

        holder.textview.text = textlist[position].textView
    }

    override fun getItemCount(): Int {
        return textlist.size
    }
}