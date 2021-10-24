package com.example.hw_w4d5.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class WordDataClass(
    val word: String,

    @PrimaryKey ( autoGenerate = true)
    val id :Int= 0



)
