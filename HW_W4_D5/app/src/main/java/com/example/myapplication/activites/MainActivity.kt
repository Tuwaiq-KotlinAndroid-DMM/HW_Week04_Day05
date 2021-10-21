package com.example.myapplication.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.*
import com.example.myapplication.adapters.TextRecycleViewAdapter
import com.example.myapplication.database.TextDao
import com.example.myapplication.database.TextDatabase
import com.example.myapplication.models.textModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val textList = mutableListOf<textModel>()
    private lateinit var textRecycleView : RecyclerView
    private lateinit var textRecycleViewAdapter : TextRecycleViewAdapter
    private lateinit var database: TextDatabase
    private lateinit var productDao: TextDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "text-database"
        ).build()

        productDao = database.textDao()

        ///////////////////////////////////////

        val addText : FloatingActionButton = findViewById(R.id.add_text_floatingbutton)
        addText.setOnClickListener(){
            val intent = Intent(this, AddTextActivity::class.java)

            startActivity(intent)

        }

        textRecycleView = findViewById(R.id.recyle_textmain)
        textRecycleViewAdapter = TextRecycleViewAdapter(this,textList)
        textRecycleView.adapter = textRecycleViewAdapter

        getTextFromDatabase()
    }

    override fun onRestart() {
        super.onRestart()
        getTextFromDatabase()
    }
    fun getTextFromDatabase(){
        GlobalScope.launch {
            textList.clear()
            textList.addAll(productDao.getText())
        }
        textRecycleViewAdapter.notifyDataSetChanged()
    }
}