package sa.edu.twuaiq.hw_week04_day05.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.Modle.AddWordModle


@Database(entities = [AddWordModle::class],version = 1)
abstract class AddWordDatabase: RoomDatabase() {
abstract fun addtextview():AddTextView
}