package sa.edu.twuaiq.hw_week04_day05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.models.WordsDataModel
import sa.edu.twuaiq.hw_week04_day05.database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase

class Add_Data : AppCompatActivity() {



   // declaration for the database
   private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)


        database = Room.databaseBuilder(
            this,
            WordsDatabase::class.java,
            "amazon-database"
        ).build()

        wordsDao = database.wordsDao()

        // declarations and assignments
        val add_word_EditText: EditText = findViewById(R.id.addWordEditText)
        val add_button: Button = findViewById(R.id.add_button)


       add_button.setOnClickListener{


   lifecycleScope.launch {


               wordsDao.addWord(WordsDataModel(add_word_EditText.text.toString()))

           }

           finish()
       }




    }


}