package com.example.roomwordssample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity




class AddWord : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        val wordsNameEditText: EditText = findViewById(R.id.word_name_edittext)
        val wordButton: Button = findViewById(R.id.add_button)


        val wordName = intent.getStringExtra("word_name")

        wordsNameEditText.text = wordName


    }
}