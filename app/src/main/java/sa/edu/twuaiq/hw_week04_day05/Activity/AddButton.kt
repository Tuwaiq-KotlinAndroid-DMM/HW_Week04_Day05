package sa.edu.twuaiq.hw_week04_day05.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.Database.Daoo
import sa.edu.twuaiq.hw_week04_day05.Database.Databasee
import sa.edu.twuaiq.hw_week04_day05.Model.NameModel
import sa.edu.twuaiq.hw_week04_day05.R

class AddButton : AppCompatActivity() {
    private lateinit var database: Databasee
    private lateinit var daoo: Daoo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)
        database = Room.databaseBuilder(this, Databasee::class.java, "database").build()
        daoo= database.Dao()

        val NameEditText: EditText = findViewById(R.id.name_edit_text_add)
        val addButton: Button = findViewById(R.id.add_button)


        addButton.setOnClickListener {
            GlobalScope.launch {
                daoo.addName(NameModel(NameEditText.text.toString()))

            }
            finish()
        }
    }
    }
