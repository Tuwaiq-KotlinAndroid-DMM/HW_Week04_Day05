package com.example.databasehomework.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.databasehomework.entities.WordDateModel

@Database(entities = [WordDateModel::class], version = 1)
abstract class WordsDatabase: RoomDatabase() {
    abstract fun wordDao():WordsDao

}