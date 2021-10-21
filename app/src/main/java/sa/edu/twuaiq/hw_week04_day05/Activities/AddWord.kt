package sa.edu.twuaiq.hw_week04_day05.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.Database.AddTextView
import sa.edu.twuaiq.hw_week04_day05.Database.AddWordDatabase
import sa.edu.twuaiq.hw_week04_day05.Modle.AddWordModle
import sa.edu.twuaiq.hw_week04_day05.R

class AddWord : AppCompatActivity() {

    private lateinit var database:AddWordDatabase
    private lateinit var addtextviewdao:AddTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        database= Room.databaseBuilder(
this,
AddWordDatabase::class.java,
"addword_database").build()
        addtextviewdao=database.addtextview()
        val addEditText: EditText = findViewById(R.id.editTextTextPersonName)
        val addwordButton: Button = findViewById(R.id.savebutton)

        addwordButton.setOnClickListener{
            GlobalScope.launch {
addtextviewdao.addTextView(AddWordModle(
    addEditText.text.toString()))

            }
finish()
        }

    }
}