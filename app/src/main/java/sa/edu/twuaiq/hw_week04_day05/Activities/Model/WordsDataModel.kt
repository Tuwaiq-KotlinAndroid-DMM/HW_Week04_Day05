package sa.edu.twuaiq.hw_week04_day05.Activities.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordsDataModel(

    var Word_textView: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
