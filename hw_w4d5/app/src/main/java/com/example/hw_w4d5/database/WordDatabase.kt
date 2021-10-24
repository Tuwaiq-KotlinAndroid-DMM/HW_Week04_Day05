package com.example.hw_w4d5.database

import androidx.room.Database
import com.example.hw_w4d5.model.WordDataClass

@Database(entities = [WordDataClass::class], version = 1)
abstract class WordDatabase {
}