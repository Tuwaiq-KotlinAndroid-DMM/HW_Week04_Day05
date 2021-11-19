package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WordDao {

    @Insert
    suspend fun addWord(WordModel: WordModel)


    @Query("SELECT * FROM wordmodel")
    suspend fun getWord(): List<WordModel>
}