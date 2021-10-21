package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.models.textModel

@Database(entities = [textModel::class],version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao
}