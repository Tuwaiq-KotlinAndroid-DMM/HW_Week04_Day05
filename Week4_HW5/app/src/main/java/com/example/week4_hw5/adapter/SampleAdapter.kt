package com.example.week4_hw5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SampleAdapter (val context: Context,
                     val list: MutableList<SampleModel>):
    RecyclerView.Adapter<SampleAdapter.SampleViewHolder>(){


    class SampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.word_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val sample_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return SampleViewHolder(sample_layout)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val samples = list[position]

        holder.textView.text = samples.editText

    }

    override fun getItemCount(): Int {
        return list.size
    }
}