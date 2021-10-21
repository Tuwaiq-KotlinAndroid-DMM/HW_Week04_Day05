package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.TextDataClass

@Dao
interface TextDao {
    @Insert
    suspend fun addText(TextDataClass: TextDataClass)

    @Query("SELECT * FROM TextDataClass")
    suspend fun getText(): List<TextDataClass>
}