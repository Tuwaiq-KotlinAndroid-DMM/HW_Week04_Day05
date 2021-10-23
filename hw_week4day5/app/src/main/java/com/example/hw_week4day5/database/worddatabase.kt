package com.example.hw_week4day5.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_week4day5.models.worddatamodel

@Database(entities = [worddatamodel::class],version = 1)
abstract class worddatabase:RoomDatabase() {

 abstract fun dao():worddao


}