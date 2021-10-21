package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.database.StringDao
import sa.edu.twuaiq.hw_week04_day05.database.StringDatabase
import sa.edu.twuaiq.hw_week04_day05.model.StringData

class StringDetails : AppCompatActivity() {
    private lateinit var database: StringDatabase
    private lateinit var productDao: StringDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_details)
        database= Room.databaseBuilder(this,StringDatabase::class.java,
            "string-database").build()
        productDao=database.productDao()

        val stringEditText:EditText=findViewById(R.id.string_edit_text)
        val addButton:Button=findViewById(R.id.add_button)

        addButton.setOnClickListener {
            GlobalScope.launch { productDao.addString(StringData(
                stringEditText.text.toString()
            )) }




            finish()


        }





    }
}