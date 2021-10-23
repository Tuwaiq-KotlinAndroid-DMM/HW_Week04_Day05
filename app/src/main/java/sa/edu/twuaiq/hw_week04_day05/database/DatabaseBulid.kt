package sa.edu.twuaiq.hw_week04_day05.database


import androidx.room.Room
import org.w3c.dom.Text


class DatabaseBulid (var text: Text) {
    fun database():TextDatabase{
        return Room.databasebulid(
            text,
            TextDatabase::class.java,
            "text-database"
        ).bulid()
    }
}