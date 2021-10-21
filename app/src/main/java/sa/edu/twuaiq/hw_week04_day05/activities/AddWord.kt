package sa.edu.twuaiq.hw_week04_day05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.DatabaseBuilder
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class AddWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        val wordEditText: EditText = findViewById(R.id.word_editText)
        val addWordButton: Button = findViewById(R.id.save_button)

        // Build the DB && DOA
        val database = DatabaseBuilder(this).buildDB()
        val wordDao: WordDao = database.wordDao()

        addWordButton.setOnClickListener {
            GlobalScope.launch {
                wordDao.addWord(
                    WordModel(wordEditText.text.toString())
                )
            }
            finish()
        }
    }
}