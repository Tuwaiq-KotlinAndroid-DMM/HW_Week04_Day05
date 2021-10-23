package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Table(
    val productName: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
