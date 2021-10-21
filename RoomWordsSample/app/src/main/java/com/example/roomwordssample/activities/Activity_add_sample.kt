package com.example.roomwordssample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.roomwordssample.R
import com.example.roomwordssample.database.SampleDao
import com.example.roomwordssample.database.SampleDatabase
import com.example.roomwordssample.model.SampleModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class activity_add_sample : AppCompatActivity() {
    private lateinit var database: SampleDatabase
    private lateinit var sampleDao: SampleDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sample)

        database = Room.databaseBuilder(this,
        SampleDatabase::class.java,"Sample-database").build()

        sampleDao = database.sampleDao()

        val sampletext : EditText = findViewById(R.id.add_sampleedittext)
        val addSampleButton : Button = findViewById(R.id.sample_button)


        addSampleButton.setOnClickListener{
            GlobalScope.launch {
                sampleDao.addSample(SampleModel(
                    sampletext.text.toString()
                ))
            }
            finish()
        }
    }
}