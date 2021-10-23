package com.example.week4_hw5

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SampleDao {
    @Insert
    suspend fun addSample(sampleModel: SampleModel)
    @Query("SELECT * FROM SampleModel")
    suspend fun getSample(): List<SampleModel>

}