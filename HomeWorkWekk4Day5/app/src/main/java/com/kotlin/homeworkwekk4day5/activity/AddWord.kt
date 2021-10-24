package com.kotlin.homeworkwekk4day5.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.homeworkwekk4day5.R
import com.kotlin.homeworkwekk4day5.adapter.DatabaseBuilder
import com.kotlin.homeworkwekk4day5.database.WordDao
import com.kotlin.homeworkwekk4day5.model.WordModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout)

        val wordEditText: EditText = findViewById(R.id.add_word_edittext)
        val addWordButton: Button = findViewById(R.id.save_button)

        // Build the DB && DOA
        val database = DatabaseBuilder(this).buildDB()
        val wordDao: WordDao = database.wordDao()

        addWordButton.setOnClickListener {
            GlobalScope.launch {
                wordDao.AddWord(
                    WordModel(wordEditText.text.toString())
                )
            }
            finish()
        }
    }
}