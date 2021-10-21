package sa.edu.twuaiq.hw_week04_day05.avtivity

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
//import sa.edu.twuaiq.hw_week04_day05.database.DataBuilder
//import sa.edu.twuaiq.hw_week04_day05.database.DataBuilder
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class Addword : AppCompatActivity() {

    private lateinit var database: WordDatabase
    private lateinit var wordDao: WordDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)

        database = Room.databaseBuilder(
            this,
            WordDatabase::class.java,
            "amazon-database"
        ).build()

        wordDao = database.wordDao()


        val trainingEditText: EditText = findViewById(R.id.edit_Text)
        val saveButton: Button = findViewById(R.id.save_button)



        saveButton.setOnClickListener(){
            GlobalScope.launch {
                wordDao.addword(WordModel(trainingEditText.text.toString())
                )
            }
            finish()
        }
    }


}