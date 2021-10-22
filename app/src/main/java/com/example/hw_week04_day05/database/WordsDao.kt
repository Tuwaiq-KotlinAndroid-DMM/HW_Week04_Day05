package com.example.hw_week04_day05.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw_week04_day05.Activities.WordsData

@Dao
interface WordsDao {
    // to make background thread we use suspend
    @Insert
    suspend fun addWords(wordsData: WordsData)
    //we select data from the list
    @Query("SELECT * FROM wordsdata")
    suspend fun getwords():List<WordsData>

}