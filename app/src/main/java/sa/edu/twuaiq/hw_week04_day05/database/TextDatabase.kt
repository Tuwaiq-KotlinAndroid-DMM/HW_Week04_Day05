package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TextDatabase::class],version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao(): ItextDao

}