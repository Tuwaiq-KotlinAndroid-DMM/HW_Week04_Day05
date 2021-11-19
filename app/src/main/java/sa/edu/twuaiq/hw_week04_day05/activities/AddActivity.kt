package sa.edu.twuaiq.hw_week04_day05.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordModel
import sa.edu.twuaiq.hw_week04_day05.model.WordDataClass


class AddActivity: AppCompatActivity() {

    private lateinit var database: WordDataClass
    private lateinit var wordDao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)


        database = Room.databaseBuilder(
            this,
            WordDataClass::class.java,
            "Word Database"
        ).build()

        wordDao = database.WordDao()

        val wordEditText: EditText = findViewById(R.id.word_edittext)
        val addWordButton: Button = findViewById(R.id.add_button)


        addWordButton.setOnClickListener {

            GlobalScope.launch {
                wordDao.addWord(
                    WordModel(
                        wordEditText.text.toString()
                    )
                )
            }
            finish()
        }
    }

}