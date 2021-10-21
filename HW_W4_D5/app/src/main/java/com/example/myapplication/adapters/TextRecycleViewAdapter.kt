package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.textModel

class TextRecycleViewAdapter(val contxt: Context,
                             var listTexts:MutableList<textModel>):
    RecyclerView.Adapter<TextRecycleViewAdapter.TextViewHolder>() {

    class TextViewHolder(view: View):RecyclerView.ViewHolder(view){

        val textNameView :TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val textLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout,parent,false)
        return TextViewHolder(textLayout)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val textPosition = listTexts[position]
        holder.textNameView.text = textPosition.addText.toString()
    }

    override fun getItemCount(): Int = listTexts.size
}