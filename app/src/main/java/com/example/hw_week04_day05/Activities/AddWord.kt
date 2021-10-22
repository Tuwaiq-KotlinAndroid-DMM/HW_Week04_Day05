package com.example.hw_week04_day05.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.hw_week04_day05.R

import com.example.hw_week04_day05.database.WordsDao
import com.example.hw_week04_day05.database.WordDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddWord : AppCompatActivity() {
    private lateinit var Database: WordDatabase
    private lateinit var wordDao: WordsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_word)


        Database = Room.databaseBuilder(
            this, WordDatabase::class.java,
            "words-database"
        ).build()
        wordDao = Database.WordsDao()

        val wordsToAdd: EditText = findViewById(R.id.textToBeAdd_editext)
        val save_button: Button = findViewById(R.id.save_button_edittext)

        save_button.setOnClickListener() {
            GlobalScope.launch {
                wordDao.addWords(WordsData(wordsToAdd.text.toString()))
            }

            finish()


        }
    }
}