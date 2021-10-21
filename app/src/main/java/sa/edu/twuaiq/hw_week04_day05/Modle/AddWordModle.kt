package sa.edu.twuaiq.hw_week04_day05.Modle

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AddWordModle(val addword:String,

    @PrimaryKey(autoGenerate = true)
val id:Int=0
)
