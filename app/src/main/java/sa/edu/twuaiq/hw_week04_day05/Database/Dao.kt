package sa.edu.twuaiq.hw_week04_day05.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.Model.NameModel

@Dao
interface Daoo {

    @Insert
    suspend fun addName(NameModel: NameModel)
    @Query("SELECT * FROM namemodel")
    suspend fun getName():List<NameModel>
}