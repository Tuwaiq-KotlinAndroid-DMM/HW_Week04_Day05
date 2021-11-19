package sa.edu.twuaiq.hw_week04_day05.model

import androidx.room.RoomDatabase
import androidx.room.Database
import sa.edu.twuaiq.hw_week04_day05.database.WordDao

@Database (entities = [WordDataClass::class], version = 1)
abstract class WordDataClass: RoomDatabase() {
    abstract fun WordDao(): WordDao
}