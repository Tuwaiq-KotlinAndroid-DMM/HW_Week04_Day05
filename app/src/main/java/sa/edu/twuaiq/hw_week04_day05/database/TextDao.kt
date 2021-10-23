package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.TextModel


@Dao
interface TextDao {

    // suspend -> to work in background thread`
    @Insert
    suspend fun textWords(productModel: TextModel)

    @Query("SELECT * FROM TextModel" +
            "")
    suspend fun getWords():List<TextModel>
}


