package com.kotlin.homeworkwekk4day5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kotlin.homeworkwekk4day5.R
import com.kotlin.homeworkwekk4day5.adapter.WordAdapter
import com.kotlin.homeworkwekk4day5.database.WordDao
import com.kotlin.homeworkwekk4day5.model.WordModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.database.DatabaseBuilder

class MainActivity : AppCompatActivity() {

        private lateinit var recyclerView: RecyclerView
        private lateinit var wordAdapter: WordAdapter

        // Words list
        val wordsList = mutableListOf<WordModel>()

        // Database Builder
        private lateinit var wordDao: WordDao

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Build the DB
            wordDao = DatabaseBuilder(this).buildDB().wordDao()

            val addFloatingButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
            recyclerView = findViewById(R.id.add_recycler_view)
            wordAdapter = WordAdapter(this, wordsList)

            recyclerView.adapter = wordAdapter

            addFloatingButton.setOnClickListener {
                val intent = Intent(this, AddWord::class.java)
                startActivity(intent)
            }

            getWordsFromDB()

        }

        override fun onRestart() {
            super.onRestart()
            getWordsFromDB()
        }

        fun getWordsFromDB() {
            GlobalScope.launch {
                wordsList.clear()
                wordsList.addAll(
                    wordDao.getWords()

                )
            }
            wordAdapter.notifyDataSetChanged()
        }
    }

