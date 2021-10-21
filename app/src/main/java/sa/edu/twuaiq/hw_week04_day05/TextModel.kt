package sa.edu.twuaiq.hw_week04_day05

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextModel(
    val txt: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 )