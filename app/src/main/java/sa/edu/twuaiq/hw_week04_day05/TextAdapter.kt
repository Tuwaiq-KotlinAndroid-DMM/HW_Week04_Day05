package sa.edu.twuaiq.hw_week04_day05

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter (val context: Context,
val texttList: MutableList<TextModel>)
    :RecyclerView.Adapter<TextAdapter.TextViewHolder>(){

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mainTextView: TextView = view.findViewById(R.id.main_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val text_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return TextViewHolder(text_layout)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val textt = texttList[position]
        holder.mainTextView.text = textt.txt
    }

    override fun getItemCount(): Int {
        return texttList.size
    }

}


