package com.example.roomwordssample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomwordssample.model.SampleModel

@Dao
interface SampleDao {
    @Insert
    suspend fun addSample(sampleModel: SampleModel)

    @Query ("SELECT * FROM SampleModel")
    suspend fun getSample(): List<SampleModel>
}