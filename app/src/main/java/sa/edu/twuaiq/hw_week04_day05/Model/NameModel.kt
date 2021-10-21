package sa.edu.twuaiq.hw_week04_day05.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NameModel(val name: String, @PrimaryKey (autoGenerate = true) val id:Int = 0)
