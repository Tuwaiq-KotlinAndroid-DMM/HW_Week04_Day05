package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.StringData

@Database(entities = [StringData::class],version = 1)
abstract class StringDatabase :RoomDatabase() {
    abstract fun productDao():StringDao
}