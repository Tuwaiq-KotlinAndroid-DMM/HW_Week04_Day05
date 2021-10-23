package sa.edu.twuaiq.hw_week04_day05.model

import android.widget.TextView
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextModel (
    val textView : String,
    @PrimaryKey(autoGenerate = true) //
    val id:Int = 0

)