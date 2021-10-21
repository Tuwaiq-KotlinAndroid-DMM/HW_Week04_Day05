package com.example.myapplication.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class TextDetilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_detils)


        val textNameView :TextView = findViewById(R.id.text_deteiles)

        val textName = intent.getStringExtra("text_name")

        textNameView.text = textName

    }
}