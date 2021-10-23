package sa.edu.twuaiq.hw_week04_day05.database


import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextModel



@Database (entities = [TextModel::class],version = 1)
abstract class TextDatabase : RoomDatabase(){

    abstract fun textDao(): TextDao
}



