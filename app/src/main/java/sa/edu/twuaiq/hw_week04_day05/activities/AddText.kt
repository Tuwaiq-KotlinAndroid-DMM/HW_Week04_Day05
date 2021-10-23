package sa.edu.twuaiq.hw_week04_day05.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.TextDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextModel


class AddText : AppCompatActivity() {
    private lateinit var database: TextDatabase
    private lateinit var textDao: ItextDao

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_text_layout)


        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "amazon-database"
        ).build()

       textDao = database.textDao()
        val addText : EditText = findViewById(R.id.add_text)
        val saveButton : Button = findViewById(R.id.save_button)
    saveButton.setOnClickListener{
        GlobalScope.launch {
            textDao.addtext (TextModel(
                addText.text.toString()
            ))

        }
        finish()
    }

} }
