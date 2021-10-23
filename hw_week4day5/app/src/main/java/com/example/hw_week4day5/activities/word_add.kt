package com.example.hw_week4day5.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.hw_week4day5.R
import com.example.hw_week4day5.database.worddao
import com.example.hw_week4day5.database.worddatabase
import com.example.hw_week4day5.models.worddatamodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class word_add : AppCompatActivity() {
    private lateinit var wordinput:EditText
    private lateinit var wordinputbutton:Button
    private lateinit var thedao:worddao
    private lateinit var database:worddatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_add)
        wordinput=findViewById(R.id.enterword)
        wordinputbutton=findViewById(R.id.addword)
        database= Room.databaseBuilder(this,worddatabase::class.java,"database").build()
        thedao=database.dao()

        wordinputbutton.setOnClickListener {
            val intent= Intent()
            GlobalScope.launch {
              thedao.addword(worddatamodel(wordinput.text.toString()))

            }
            finish()


        }
    }



}