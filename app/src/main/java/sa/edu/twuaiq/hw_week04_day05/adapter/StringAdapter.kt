package sa.edu.twuaiq.hw_week04_day05.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.StringData

class StringAdapter (val context: Context,
                     val stringList: MutableList<StringData>):
RecyclerView.Adapter<StringAdapter.StringViewHolder>() {


    class StringViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstTextView: TextView = view.findViewById(R.id.first_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val string_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return StringViewHolder(string_layout)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val strings = stringList[position]

        holder.firstTextView.text = strings.firstText




    }

    override fun getItemCount(): Int {
        return stringList.size
    }
}