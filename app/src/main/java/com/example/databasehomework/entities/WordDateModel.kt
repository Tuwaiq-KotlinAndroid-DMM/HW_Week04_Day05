package com.example.databasehomework.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordDateModel(
    val word: String,

    @PrimaryKey(autoGenerate = true)
    val index: Int = 0
)