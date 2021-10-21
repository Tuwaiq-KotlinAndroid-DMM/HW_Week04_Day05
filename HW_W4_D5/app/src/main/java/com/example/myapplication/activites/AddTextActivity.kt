package com.example.myapplication.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.database.TextDao
import com.example.myapplication.database.TextDatabase
import com.example.myapplication.models.textModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTextActivity : AppCompatActivity() {
    private lateinit var database: TextDatabase
    private lateinit var textDao: TextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_text)

        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "text-database"
        ).build()

        textDao = database.textDao()

        ///////////////////////////////////////

        val addText :EditText = findViewById(R.id.text_add)
        val saveButton :Button = findViewById(R.id.save_button)

        saveButton.setOnClickListener(){
            GlobalScope.launch {
                textDao.addText(
                    textModel(
                        addText.text.toString()
                    )
                )
            }

            finish()

        }
    }
}