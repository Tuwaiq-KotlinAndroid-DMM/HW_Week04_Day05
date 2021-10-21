package sa.edu.twuaiq.hw_week04_day05.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.model.TextDataClass

class TextAdapter (

    val context: Context,
    val TextList: MutableList<TextDataClass>):

    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

        class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textNameTextView: TextView = view.findViewById(R.id.textViewEdit)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
            val product_layout = LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
            return TextViewHolder(product_layout)
        }
        override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
            val product = TextList[position]

            holder.textNameTextView.text = product.textview

        }
        override fun getItemCount(): Int {
            return TextList.size
        }
    }
