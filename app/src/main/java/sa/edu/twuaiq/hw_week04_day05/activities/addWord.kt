package sa.edu.twuaiq.hw_week04_day05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class addWord : AppCompatActivity() {

    private lateinit var database: WordsDatabase
    private lateinit var wordDao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        database = Room.databaseBuilder(
            this,
            WordsDatabase::class.java,
            "words-database"
        ).build()

        val wordDao = database.wordsDao()

        val wordEditText: EditText = findViewById(R.id.edit_text)
        val wordSaveButton: Button = findViewById(R.id.save_button)


        wordSaveButton.setOnClickListener {
            GlobalScope.launch {
                wordDao.addWord(WordsModel(
                    wordEditText.text.toString()
                ))
            }
            finish()
        }



    }
}