package com.example.roomwordssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var wordsRecyclerView: RecyclerView
    private lateinit var wordsRecyclerViewAdapter: WordsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordsRecyclerView = findViewById(R.id.word_name_edittext)
        wordsRecyclerViewAdapter = WordsRecyclerViewAdapter(this, wordsList = MutableList(WordsModel))
        wordsRecyclerView.adapter = wordsRecyclerViewAdapter
        AddWord
    }
}