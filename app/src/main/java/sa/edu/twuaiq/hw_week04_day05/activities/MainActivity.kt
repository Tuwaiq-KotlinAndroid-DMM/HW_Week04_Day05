package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapter.TextAdapter
import sa.edu.twuaiq.hw_week04_day05.database.ItextDao
import sa.edu.twuaiq.hw_week04_day05.database.TextDatabase
import sa.edu.twuaiq.hw_week04_day05.model.TextModel

class MainActivity : AppCompatActivity() {

    val text  = mutableListOf<TextModel>()
    private lateinit var database: TextDatabase
    private lateinit var textDao: ItextDao
    private lateinit var textRecyclerView: RecyclerView
    private lateinit var textsRecyclerViewAdapter: TextAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add_button: FloatingActionButton = findViewById(R.id.add_button)

        database = Room.databaseBuilder(
            this,  // make build here
            TextDatabase::class.java,
            "text-database"
        ).build()
        textDao = database.textDao()

        val addText : FloatingActionButton = findViewById(R.id.add_button)
        textRecyclerView = findViewById(R.id.textrecyclerview)
        textsRecyclerViewAdapter = TextAdapter(this,text)

         textRecyclerView.adapter = textsRecyclerViewAdapter
        add_button.setOnClickListener {

            val intent = Intent(this, AddText::class.java)
            startActivity(intent)

        }
        gettexttsFromDatabase()

    }
    fun gettexttsFromDatabase(){
        GlobalScope.launch {
            text.clear()
            textDao.gettext()
            text.addAll(textDao.gettext())

        }
        textsRecyclerViewAdapter.notifyDataSetChanged()
    }
    override fun onRestart() {
        super.onRestart()
        gettexttsFromDatabase()
    }

}