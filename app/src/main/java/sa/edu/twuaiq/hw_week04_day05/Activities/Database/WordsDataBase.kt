package sa.edu.twuaiq.hw_week04_day05.Activities.Database

import sa.edu.twuaiq.hw_week04_day05.Activities.Model.WordsDataModel
import androidx.room.Database
import androidx.room.RoomDatabase
@Database (entities = [WordsDataModel::class], version = 1)

abstract class WordsDataBase: RoomDatabase() {

     abstract fun wordsDao (): WordsDao

    }
