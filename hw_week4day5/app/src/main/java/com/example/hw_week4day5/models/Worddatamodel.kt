package com.example.hw_week4day5.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class worddatamodel(
    var word:String,

    @PrimaryKey(autoGenerate = true)
val id:Int=0
)
