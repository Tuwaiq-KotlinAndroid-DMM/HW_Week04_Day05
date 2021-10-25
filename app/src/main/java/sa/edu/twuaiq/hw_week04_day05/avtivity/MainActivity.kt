package sa.edu.twuaiq.hw_week04_day05.avtivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapter.WordAdapter
//import sa.edu.twuaiq.hw_week04_day05.database.DataBuilder
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    private lateinit var database: WordDatabase
    private lateinit var wordDao: WordDao

    val words = mutableListOf<WordModel>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            this,
            WordDatabase::class.java,
            "word-database"
        ).build()

        wordDao = database.wordDao()



        val floatingButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        recyclerView = findViewById(R.id.recyclerView)
        wordAdapter = WordAdapter(this,words)

        recyclerView.adapter = wordAdapter

        floatingButton.setOnClickListener {
            val intent = Intent(this, Addword::class.java)

            startActivity(intent)

        }
        getWordFromDatabase()

    }

    override fun onRestart() {
        super.onRestart()
        getWordFromDatabase()

    }

    fun getWordFromDatabase(){
        GlobalScope.launch {
            words.clear()
            words.addAll(wordDao.getwords())


        }
        wordAdapter.notifyDataSetChanged()

    }

}