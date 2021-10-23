package sa.edu.twuaiq.hw_week04_day05.Activities.activities

import sa.edu.twuaiq.hw_week04_day05.Activities.Database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.Activities.Database.WordsDataBase
import sa.edu.twuaiq.hw_week04_day05.Activities.Model.WordsDataModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R


class AddWords : AppCompatActivity() {

    private lateinit var dataBase: WordsDataBase
    private lateinit var wordsDao: WordsDao

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_add_words)

            dataBase = Room.databaseBuilder(this, WordsDataBase::class.java,
                "Words-database"
            ).build()
           wordsDao = dataBase.wordsDao()

        val word_editText: EditText = findViewById(R.id.word_editText)
        val SaveButton: Button = findViewById(R.id.save_button)


        SaveButton.setOnClickListener {
            GlobalScope.launch {
                wordsDao.addWords(WordsDataModel(word_editText.text.toString() ))
            }
            finish()
        }


    }
}