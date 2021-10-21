package com.example.databasehomework.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.databasehomework.Adapter.TextAdapter
import com.example.databasehomework.R
import com.example.databasehomework.database.WordsDao
import com.example.databasehomework.database.WordsDatabase
import com.example.databasehomework.entities.WordDateModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TextAdapter
    private lateinit var floatingButton: FloatingActionButton
    private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao
    val list = mutableListOf<WordDateModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        floatingButton = findViewById(R.id.floatingActionButton)

        adapter = TextAdapter(this, list)
        database = Room.databaseBuilder(this, WordsDatabase::class.java, "Words Database").build()
        wordsDao = database.wordDao()
        recyclerView.adapter = adapter

        floatingButton.setOnClickListener {
            val intent = Intent(this, AddWord::class.java)
            startActivity(intent)
        }
        retrieveData()


    }

    fun retrieveData() {
        GlobalScope.launch {
            val sample = listOf<WordDateModel>(
                WordDateModel("Hello"),
                WordDateModel("World"),
                WordDateModel("The Developer")
            )
            list.clear()
            list.addAll(sample)
            list.addAll(wordsDao.getWords())
        }
        adapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        retrieveData()
    }
}