package sa.edu.twuaiq.hw_week04_day05.database

import android.content.Context
import androidx.room.Room

class DatabaseBuilder(val context: Context) {
    fun buildDB(): WordsDatabase {
        return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            "Word-database"
        ).build()
    }
}

