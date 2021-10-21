package com.example.roomwordssample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleModel(
    val sampleText : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
