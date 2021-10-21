package sa.edu.twuaiq.hw_week04_day05.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.twuaiq.hw_week04_day05.Model.NameModel


    @Database(entities = [NameModel::class],version = 1)
    abstract class Databasee: RoomDatabase(){
        abstract fun Dao(): Daoo
}