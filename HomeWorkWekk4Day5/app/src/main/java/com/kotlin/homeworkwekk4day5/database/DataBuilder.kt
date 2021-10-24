package com.kotlin.homeworkwekk4day5.adapter

import android.content.Context
import androidx.room.Room
import com.kotlin.homeworkwekk4day5.database.WordsDatabase


class DatabaseBuilder(val context: Context) {
    fun buildDB(): WordsDatabase {
        return Room.databaseBuilder(
            context, WordsDatabase::class.java,
            "Word-database"
        ).build()
    }
}