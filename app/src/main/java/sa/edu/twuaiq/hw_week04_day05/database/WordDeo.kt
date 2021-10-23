package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

@Dao

interface WordDeo {
    @Insert
    suspend fun addWord(wordModel: WordModel)

    @Query("SELECT * FROM wordmodel")
    suspend fun getWord(): List<WordModel>
}