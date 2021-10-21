package sa.edu.twuaiq.hw_week04_day05.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextDataClass(
    val textview: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
