package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.models.textModel

@Dao
interface TextDao {
    @Insert
    suspend fun addText(textModel: textModel)
    @Query("SELECT * FROM textModel")
    suspend fun getText():List<textModel>
}