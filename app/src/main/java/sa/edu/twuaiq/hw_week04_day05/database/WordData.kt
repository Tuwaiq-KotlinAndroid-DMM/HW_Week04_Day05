package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

@Dao
interface WordDao {
    @Insert
    suspend fun addWord(wordsModel: WordsModel)

    @Query("SELECT * FROM wordsmodel")
    suspend fun getWords():List<WordsModel>

    }
