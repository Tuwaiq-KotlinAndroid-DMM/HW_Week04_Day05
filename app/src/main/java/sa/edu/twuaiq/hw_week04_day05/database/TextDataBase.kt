package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextDataClass

@Database(entities = [TextDataClass::class], version = 1)
abstract class TextDataBase:RoomDatabase() {

    abstract fun TextDao(): TextDao
}