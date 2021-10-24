package com.kotlin.homeworkwekk4day5.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotlin.homeworkwekk4day5.model.WordModel


@Database(entities = [WordModel::class], version = 1)
abstract class WordsDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao
}