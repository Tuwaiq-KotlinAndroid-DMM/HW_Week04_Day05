package com.example.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class textModel(
val addText :String,
@PrimaryKey(autoGenerate = true)
val id:Int = 0

)
