package com.example.hw_week4day5.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw_week4day5.models.worddatamodel

@Dao
interface worddao {
    @Insert
    suspend fun addword(product: worddatamodel)


    @Query("SELECT * From worddatamodel")

    suspend fun getwords():List<worddatamodel>
}