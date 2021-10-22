package com.example.hw_week04_day05.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.hw_week04_day05.R
import com.example.hw_week04_day05.database.WordDatabase
import com.example.hw_week04_day05.database.WordsDao
import com.example.hw_week04_day05.wordsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var Database: WordDatabase
    private lateinit var wordDao: WordsDao
    private lateinit var imageRecyclerView: RecyclerView
    private lateinit var WorsRecyclerViewAdapter: wordsAdapter
    val wordList = mutableListOf<WordsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Database = Room.databaseBuilder(
            this, WordDatabase::class.java,
            "words-database"
        ).build()
        wordDao = Database.WordsDao()

        val addWord: FloatingActionButton = findViewById(R.id.floatingActionButton2)
        imageRecyclerView = findViewById(R.id.word_items_layout)
        WorsRecyclerViewAdapter= wordsAdapter(this,wordList)
        imageRecyclerView.adapter = WorsRecyclerViewAdapter

        addWord.setOnClickListener(){

            val intent = Intent(this,AddWord::class.java)
            startActivity(intent)

        }
        getMeMyData()
    }
    fun getMeMyData(){
        lifecycleScope.launch {
            wordList.clear()
            wordList.addAll(wordDao.getwords())

            WorsRecyclerViewAdapter.notifyDataSetChanged()

        }



    }

    override fun onRestart() {
        super.onRestart()
        getMeMyData()
    }






    // assign adapter to recyclerview
}