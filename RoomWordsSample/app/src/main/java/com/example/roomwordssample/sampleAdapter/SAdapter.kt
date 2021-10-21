package com.example.roomwordssample.sampleAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwordssample.R
import com.example.roomwordssample.model.SampleModel

class SAdapter(val context: Context,
     val sampleList: MutableList<SampleModel>) :
    RecyclerView.Adapter<SAdapter.SampleViewHolder>()
    {
        class SampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var sampleEditText: TextView = view.findViewById(R.id.textView)
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
            val sample = sampleList[position]
            holder.sampleEditText.text = sample.sampleText


        }

        override fun getItemCount(): Int {
            return sampleList.size
        }

    }