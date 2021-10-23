package sa.edu.twuaiq.hw_week04_day05.database


import android.content.Context
import androidx.room.Room



class DatabaseBulid (var context: Context) {
    fun database():TextDatabase{
        return Room.databaseBuilder(
            context,
            TextDatabase::class.java,
            "text-database"
        ).build()
    }
}