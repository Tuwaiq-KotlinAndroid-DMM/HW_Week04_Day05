package sa.edu.twuaiq.hw_week04_day05

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TextModel::class],version = 1)
abstract class TextDatabase : RoomDatabase()  {

    abstract fun TextDao(): TextDao

}