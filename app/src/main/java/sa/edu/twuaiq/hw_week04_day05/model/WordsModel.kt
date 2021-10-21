package sa.edu.twuaiq.hw_week04_day05.model

import androidx.room.Entity
import androidx.room.PrimaryKey


// @Entity -> make the model table (entity)
@Entity
data class WordsModel(
    val wordsName: String,
    @PrimaryKey(autoGenerate = true) // will generate id
    val id:Int = 0 // 0 default value
)

