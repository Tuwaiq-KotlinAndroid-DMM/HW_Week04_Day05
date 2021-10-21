package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel


@Dao
interface WordsDao {

    // suspend -> to work in background thread`
    @Insert
    suspend fun addWords(productModel: WordsModel)

    @Query("SELECT * FROM WordsModel")
    suspend fun getWords():List<WordsModel>
}