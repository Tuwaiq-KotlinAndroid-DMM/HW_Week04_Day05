package com.example.hw_week4day5.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.hw_week4day5.R
import com.example.hw_week4day5.database.worddao
import com.example.hw_week4day5.database.worddatabase
import com.example.hw_week4day5.models.worddatamodel
import com.example.hw_week4day5.wordrecyclerviewadapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var wordlist= mutableListOf(worddatamodel("Hello"), worddatamodel("World"))
    private lateinit var recycle:RecyclerView
    private lateinit var floatingbutton:FloatingActionButton
    lateinit var wordadapter: wordrecyclerviewadapter
    private lateinit var thedao: worddao
    private lateinit var database: worddatabase







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle=findViewById(R.id.wordrecycleview)
        wordadapter= wordrecyclerviewadapter(this,wordlist)
        floatingbutton=findViewById(R.id.addwordbutton)
        recycle.adapter=wordadapter
        database= Room.databaseBuilder(this,worddatabase::class.java,"database").build()
        thedao=database.dao()


        floatingbutton.setOnClickListener{
            val intent = Intent(this, word_add::class.java)
           startActivity(intent)

        }

        getword()



    }

    override fun onRestart() {
        super.onRestart()
       getword()
    }

     fun getword()
     {
        GlobalScope.launch {
            wordlist.clear()
            wordlist.addAll(thedao.getwords())
        }
    wordadapter.notifyDataSetChanged()
     }
}