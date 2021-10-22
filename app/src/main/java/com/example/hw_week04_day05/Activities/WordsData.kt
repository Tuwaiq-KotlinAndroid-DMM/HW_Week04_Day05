package com.example.hw_week04_day05.Activities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordsData(
    val roomWords:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0


)

