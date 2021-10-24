package com.kotlin.homeworkwekk4day5.database

import android.content.Context
import androidx.room.Room


class WordDao(val context: Context) {
    fun buildDB(): WordsDatabase {
        return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            "Word-database"
        ).build()
    }
}