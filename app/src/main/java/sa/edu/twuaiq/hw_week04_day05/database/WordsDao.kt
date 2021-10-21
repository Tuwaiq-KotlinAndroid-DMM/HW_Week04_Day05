package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.models.WordsDataModel

@Dao
interface WordsDao {

    @Insert
    suspend fun addWord (wordsDataModel: WordsDataModel)


    @Query ("SELECT * FROM wordsDataModel")

    suspend fun getWords(): List<WordsDataModel>


}