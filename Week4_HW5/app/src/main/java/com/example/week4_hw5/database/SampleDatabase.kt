package com.example.week4_hw5

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [SampleModel::class],version = 1)
abstract class SampleDatabase :RoomDatabase() {
    abstract fun sampleDao():SampleDao
}