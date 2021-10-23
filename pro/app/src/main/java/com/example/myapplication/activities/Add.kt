package com.example.myapplication.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.Database
import com.example.myapplication.Deo
import com.example.myapplication.R
import com.example.myapplication.Table
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Add:   AppCompatActivity() {
    private lateinit var data: Database
    private lateinit var tDao: Deo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout)
        data = Room.databaseBuilder(
            this,
            Database::class.java,
            "database"
        ).build()
        tDao = data.hdeo()
        val NameEditText: EditText = findViewById(R.id.tvtext1)
        val addButton: Button = findViewById(R.id.tvadd)
        addButton.setOnClickListener {
            GlobalScope.launch {
                tDao.addProduct(
                    Table(
                        NameEditText.text.toString()

                    )
                )
            }
            finish()
        }
    }


}