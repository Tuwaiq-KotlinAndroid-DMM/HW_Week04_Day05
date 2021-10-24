package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextModel

@Entity
@Database(entities = [TextModel::class],version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao(): ItextDao

}