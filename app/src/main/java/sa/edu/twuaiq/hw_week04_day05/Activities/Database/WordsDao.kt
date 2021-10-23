package sa.edu.twuaiq.hw_week04_day05.Activities.Database

import sa.edu.twuaiq.hw_week04_day05.Activities.Model.WordsDataModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WordsDao {

        @Insert
        suspend fun addWords(wordsModel: WordsDataModel)

        @Query("SELECT * FROM WordsDataModel")
        suspend fun getWords(): List<WordsDataModel>

    }