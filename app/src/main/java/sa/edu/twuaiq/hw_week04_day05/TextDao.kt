package sa.edu.twuaiq.hw_week04_day05

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TextDao {

    @Insert
    suspend fun addText(TextModel: TextModel)

    @Query("SELECT * FROM TextModel")
    suspend fun getText(): List<TextModel>
}