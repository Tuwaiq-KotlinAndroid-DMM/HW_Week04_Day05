package com.example.week4_hw5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.week4_hw5.activities.SampleRoom
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var database: SampleDatabase
    private lateinit var sampleDao: SampleDao
    private lateinit var sampleRecyclerView: RecyclerView
    private lateinit var SampleRecyclerViewAdapter: SampleAdapter
    val list = mutableListOf<SampleModel>(

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(
            this, SampleDatabase::class.java,
            "sample-database"
        ).build()
        sampleDao = database.sampleDao()
        val addSample: FloatingActionButton = findViewById(R.id.add_sample_button)

        sampleRecyclerView = findViewById(R.id.sample_recyclerView)
        SampleRecyclerViewAdapter = SampleAdapter(this, list)
        sampleRecyclerView.adapter = SampleRecyclerViewAdapter

        addSample.setOnClickListener {

            val intent = Intent(this, SampleRoom::class.java)
            startActivityForResult(intent, 1)

        }
        getSampleFromDatabase()

    }

    override fun onRestart() {
        super.onRestart()

        getSampleFromDatabase()
    }

    fun getSampleFromDatabase() {
        GlobalScope.launch {
            list.clear()
            list.addAll(sampleDao.getSample())
        }
        SampleRecyclerViewAdapter.notifyDataSetChanged()
    }

}