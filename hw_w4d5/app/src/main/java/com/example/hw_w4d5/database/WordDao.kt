package com.example.hw_w4d5.database

import android.widget.TextView
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw_w4d5.model.WordDataClass


@Dao
interface WordDao {

    @Insert
    suspend fun addword(textView: WordDataClass)

    @Query("SELECT *FROM WordDataClass")
    suspend fun getword():List<WordDataClass>
}