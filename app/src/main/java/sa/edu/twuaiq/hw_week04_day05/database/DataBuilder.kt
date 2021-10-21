//package sa.edu.twuaiq.hw_week04_day05.database
//
//import android.content.Context
//import androidx.room.Room
//
//class DataBuilder(val context: Context) {
//
//    fun builder(): WordDatabase{
//        return Room.databaseBuilder(
//            context,
//            WordDatabase::class.java,
//            "WordsDatabase"
//        ).build()
//    }
//}