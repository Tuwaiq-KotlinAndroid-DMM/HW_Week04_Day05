package sa.edu.twuaiq.hw_week04_day05.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class WordsDataModel (

    val  wordText: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    )