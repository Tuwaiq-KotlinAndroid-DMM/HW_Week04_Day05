package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.model.StringData

@Dao
interface StringDao {
    @Insert
    suspend fun addString(productModel: StringData)
    @Query("SELECT * FROM stringdata")
    suspend fun getString(): List<StringData>

}