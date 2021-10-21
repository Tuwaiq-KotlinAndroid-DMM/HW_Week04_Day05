package com.example.roomwordssample.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomwordssample.R
import com.example.roomwordssample.database.SampleDao
import com.example.roomwordssample.database.SampleDatabase
import com.example.roomwordssample.model.SampleModel
import com.example.roomwordssample.sampleAdapter.SAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val sample = mutableListOf<SampleModel>()
    private lateinit var database: SampleDatabase
    private lateinit var sampleDao: SampleDao
    private lateinit var sample_recyclerview : RecyclerView
    private lateinit var sadapter : SAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        database = Room.databaseBuilder(
            this,
            SampleDatabase ::class.java, "Sample-database"
        ).build()

        sampleDao = database.sampleDao()

        val addButton : FloatingActionButton = findViewById(R.id.add_button)
        sample_recyclerview = findViewById(R.id.sample_recyclerview)
        sadapter = SAdapter(this,sample)

        sample_recyclerview.adapter = sadapter

        addButton.setOnClickListener{
            val intent = Intent (this, activity_add_sample::class.java)
        startActivity(intent)



        }
        getSampleFromDatabase()
    }

    override fun onRestart() {
        super.onRestart()
        getSampleFromDatabase()
    }

    fun getSampleFromDatabase(){
        GlobalScope.launch {
            sample.clear()
            sample.addAll(sampleDao.getSample())

        }
        sadapter.notifyDataSetChanged()

    }
}