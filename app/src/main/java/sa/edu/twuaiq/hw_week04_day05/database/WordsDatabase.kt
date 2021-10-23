package sa.edu.twuaiq.hw_week04_day05.database

import android.provider.UserDictionary
import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel


@Database(entities = [WordsModel::class],version = 1)
abstract class WordsDatabase:RoomDatabase(){

    abstract fun wordsDao():WordDao
}
