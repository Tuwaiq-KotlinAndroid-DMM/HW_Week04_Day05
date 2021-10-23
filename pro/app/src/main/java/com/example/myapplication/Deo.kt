package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Deo {
    @Insert
    suspend fun addProduct(Table: Table)
    @Query("SELECT* FROM `Table`")
    suspend fun getProducts():List<Table>
}