package sa.edu.twuaiq.hw_week04_day05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val textlist = mutableListOf<TextModel>()

    private lateinit var database: TextDatabase
    private lateinit var textDao: TextDao

    private lateinit var textRecyclerView: RecyclerView
    private lateinit var textRecyclerViewAdapter: TextAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            this,
            TextDatabase::class.java,
            "Text-database"

        ).build()

        textDao = database.TextDao()

        val addButton: FloatingActionButton = findViewById(R.id.add_button)


        textRecyclerView = findViewById(R.id.text_Recycler)
        textRecyclerViewAdapter = TextAdapter(this,textlist)

        textRecyclerView.adapter = textRecyclerViewAdapter

        addButton.setOnClickListener{
            val intent = Intent(this, Add_Activity::class.java)
            startActivity(intent)
        }
        getTextFromDatabase()

    }


    fun getTextFromDatabase(){

        GlobalScope.launch {

            textlist.addAll(textDao.getText())
        }

        textRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {

        super.onRestart()
        textlist.clear()
        getTextFromDatabase()
    }
}