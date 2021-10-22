package com.example.hw_week04_day05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_week04_day05.Activities.WordsData

@Database(entities = [WordsData::class], version =  1)
abstract class WordDatabase: RoomDatabase() {
    abstract fun WordsDao():WordsDao

}

