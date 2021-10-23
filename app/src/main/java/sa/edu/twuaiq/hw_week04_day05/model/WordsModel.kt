package sa.edu.twuaiq.hw_week04_day05.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text
@Entity
data class WordsModel(
    val textViewWords: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0

)
