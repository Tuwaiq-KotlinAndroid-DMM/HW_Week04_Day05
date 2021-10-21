package sa.edu.twuaiq.hw_week04_day05.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.TextDao
import sa.edu.twuaiq.hw_week04_day05.database.TextDataBase
import sa.edu.twuaiq.hw_week04_day05.model.TextDataClass

class AddText : AppCompatActivity() {

    private lateinit var database: TextDataBase
    private lateinit var productDao: TextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_text)

        database = Room.databaseBuilder(
            this,
            TextDataBase::class.java,
            "Text Database"
        ).build()

        productDao = database.TextDao()

        val textNameEditText: EditText = findViewById(R.id.editTextText)
        val addProductButton: Button = findViewById(R.id.add_text_button)

        addProductButton.setOnClickListener {

            GlobalScope.launch {
                productDao.addText(
                    TextDataClass(
                        textNameEditText.text.toString()
                    )
                )
            }
            finish()
        }
    }
}
