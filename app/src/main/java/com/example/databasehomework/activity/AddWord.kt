package com.example.databasehomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.databasehomework.R
import com.example.databasehomework.database.WordsDao
import com.example.databasehomework.database.WordsDatabase
import com.example.databasehomework.entities.WordDateModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddWord : AppCompatActivity() {
    private lateinit var wordEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        wordEditText = findViewById(R.id.new_word_text_edit)
        saveButton = findViewById(R.id.save_button)
        database = Room.databaseBuilder(this, WordsDatabase::class.java, "Words Database").build()
        wordsDao = database.wordDao()
        saveButton.setOnClickListener {
            GlobalScope.launch {
                val text = wordEditText.text.toString()
                val word = WordDateModel(text)
                wordsDao.addWord(word)
            }
            finish()
        }

    }
}