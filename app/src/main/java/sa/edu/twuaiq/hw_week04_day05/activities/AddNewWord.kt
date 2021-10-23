package sa.edu.twuaiq.hw_week04_day05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.WordDatabase
import sa.edu.twuaiq.hw_week04_day05.database.WordDeo
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class AddNewWord : AppCompatActivity() {
    private lateinit var database: WordDatabase
    private lateinit var wordDeo: WordDeo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)

        database = Room.databaseBuilder(
            this,WordDatabase:: class.java , "amazon-database").build()
         wordDeo = database.wordDao()

        val newWord: EditText = findViewById(R.id.word_editText)
        val saveButton: Button = findViewById(R.id.save_button)

saveButton.setOnClickListener {
    GlobalScope.launch {
        wordDeo.addWord(WordModel(newWord.text.toString()) )
    }
    finish()
}


    }
}