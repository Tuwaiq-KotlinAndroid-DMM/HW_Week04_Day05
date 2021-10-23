package com.example.week4_hw5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleModel(val editText:String
                       , @PrimaryKey(autoGenerate = true)
                      val id:Int=0)