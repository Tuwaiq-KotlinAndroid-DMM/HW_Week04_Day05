package com.kotlin.homeworkwekk4day5.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import com.kotlin.homeworkwekk4day5.model.WordModel
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase


@Dao
interface WordDao {
    @Insert
    suspend fun addWord(word: WordModel)

    @Query("SELECT * FROM wordmodel")
    suspend fun getWords(): List<WordModel>
}