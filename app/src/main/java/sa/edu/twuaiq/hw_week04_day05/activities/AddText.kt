package sa.edu.twuaiq.hw_week04_day05.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.TextDao
import sa.edu.twuaiq.hw_week04_day05.database.TextDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextModel
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class AddText : AppCompatActivity() {

    private lateinit var database: TextDatabase
    private lateinit var textDao: TextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_text)

        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "words-database"
        ).build()

        textDao = database.textDao()

        val wordNameEditText: EditText = findViewById(R.id.activity_save_text)
        val addButton :Button = findViewById(R.id.save_button)

        addButton.setOnClickListener {

            GlobalScope.launch {
                textDao.textWords(
                    TextModel(
                        wordNameEditText.text.toString()
                    )
                )
            }
            finish()
        }
    }
}