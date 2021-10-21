package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

@Dao
interface WordDao {
    @Insert
    suspend fun addWord(word: WordModel)

    @Query("SELECT * FROM wordmodel")
    suspend fun getWords(): List<WordModel>
}