package sa.edu.twuaiq.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

// abstract -> because we don't want to implement methods

@Database (entities = [WordsModel::class],version = 1)
abstract class WordsDatabase :RoomDatabase(){

    abstract fun wordsDao(): WordsDao
}