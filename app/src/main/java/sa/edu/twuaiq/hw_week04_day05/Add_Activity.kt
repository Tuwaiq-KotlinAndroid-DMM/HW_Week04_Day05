package sa.edu.twuaiq.hw_week04_day05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Add_Activity : AppCompatActivity() {


    private lateinit var database: TextDatabase
    private lateinit var textDao: TextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        //build database
        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "Text-database"

        ).build()

        textDao = database.TextDao()


        var textedit: EditText = findViewById(R.id.text_EditText)
        var add2_Button: Button = findViewById(R.id.add2_button)


        add2_Button.setOnClickListener{
            GlobalScope.launch {
                textDao.addText(
                    TextModel(
                        textedit.text.toString()

                    ))
            }

            finish()
        }


    }
}