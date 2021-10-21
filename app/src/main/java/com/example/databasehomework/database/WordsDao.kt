package com.example.databasehomework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.databasehomework.entities.WordDateModel

@Dao
interface WordsDao {
    @Insert
    fun addWord(word: WordDateModel)

    @Query("SELECT * FROM worddatemodel")
    fun getWords(): List<WordDateModel>

    @Insert
    fun addWords(list: List<WordDateModel>)
}