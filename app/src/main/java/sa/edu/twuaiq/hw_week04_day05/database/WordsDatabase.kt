package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.models.WordsDataModel

@Database(entities = [WordsDataModel:: class], version = 1)

abstract class WordsDatabase: RoomDatabase() {

    abstract fun wordsDao(): WordsDao

}