package com.example.week4_hw5.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.week4_hw5.R
import com.example.week4_hw5.SampleDao
import com.example.week4_hw5.SampleDatabase
import com.example.week4_hw5.SampleModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SampleRoom : AppCompatActivity() {
    private lateinit var database: SampleDatabase
    private lateinit var sampleDao: SampleDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        database= Room.databaseBuilder(this, SampleDatabase::class.java,
            "sample-database").build()
        sampleDao=database.sampleDao()

        val sampleEditText: EditText =findViewById(R.id.sample_edit_text)
        val addButton: Button =findViewById(R.id.save_button)

        addButton.setOnClickListener {
            GlobalScope.launch { sampleDao.addSample(
                SampleModel(
                    sampleEditText.text.toString()
                )
            ) }

            finish()
        }


    }
}