package sa.edu.twuaiq.hw_week04_day05.database

import android.content.Context
import androidx.room.Room

 class DatabaseBuilder(var context:Context){


    fun database(): WordsDatabase{

       return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            "words-database"
        ).build()
    }


}