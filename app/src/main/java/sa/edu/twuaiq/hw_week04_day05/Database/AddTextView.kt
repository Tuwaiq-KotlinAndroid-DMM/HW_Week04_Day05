package sa.edu.twuaiq.hw_week04_day05.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sa.edu.twuaiq.hw_week04_day05.Modle.AddWordModle


@Dao
interface AddTextView {

    @Insert
    suspend fun addTextView(productModel: AddWordModle)

    @Query("SELECT * FROM addwordmodle")
    suspend fun getProducts():List<AddWordModle>


}