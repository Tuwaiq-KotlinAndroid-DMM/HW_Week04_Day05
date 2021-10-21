package com.example.roomwordssample.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.roomwordssample.model.SampleModel

@Database ( entities = [SampleModel::class],version = 1)
abstract class SampleDatabase : RoomDatabase ()
{
     abstract fun sampleDao() : SampleDao
}