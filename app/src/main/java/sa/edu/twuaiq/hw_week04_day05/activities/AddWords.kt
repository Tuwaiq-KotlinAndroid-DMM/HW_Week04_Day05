package sa.edu.twuaiq.hw_week04_day05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class AddWords : AppCompatActivity() {

    private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_words)

        database = Room.databaseBuilder(
            this,
            WordsDatabase::class.java,
            "words-database"
        ).build()

        wordsDao = database.wordsDao()

        val wordNameEditText: EditText = findViewById(R.id.word_name_edittext)
        val addButton :Button = findViewById(R.id.add_button)

        addButton.setOnClickListener {

            GlobalScope.launch {
                wordsDao.addWords(
                    WordsModel(
                        wordNameEditText.text.toString()
                    )
                )
            }
            finish()
        }
    }
}