package com.example.myapplication

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Table::class],version = 1)
abstract class Database : RoomDatabase() {
    abstract fun hdeo(): Deo
}
