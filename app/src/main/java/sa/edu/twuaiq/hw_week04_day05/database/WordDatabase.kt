package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordModel


@Database(entities = [WordModel::class], version = 1)
abstract class WordDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

}