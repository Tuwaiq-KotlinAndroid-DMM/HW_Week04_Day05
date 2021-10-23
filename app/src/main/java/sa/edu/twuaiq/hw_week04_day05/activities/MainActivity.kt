package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapters.TextRecyclarAdapter
import sa.edu.twuaiq.hw_week04_day05.database.DatabaseBulid
import sa.edu.twuaiq.hw_week04_day05.database.TextDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


import sa.edu.twuaiq.hw_week04_day05.model.TextModel

class MainActivity : AppCompatActivity() {

    val wordsList = mutableListOf<TextModel>()

    //private lateinit var database: WordsDatabase
    private lateinit var textDao: TextDao

    private lateinit var textRecyclerView: RecyclerView
    private lateinit var textRecyclerViewAdapter: TextRecyclarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        textDao = DatabaseBulid(this).database().textDao()


        // views declaration from activity main
        val addWords: FloatingActionButton = findViewById(R.id.add_floating_button)
        textRecyclerView = findViewById(R.id.recyclerView)
        textRecyclerViewAdapter = TextRecyclarAdapter(this, wordsList)

        // assign adapter to recyclerview
        textRecyclerView.adapter = TextRecyclarAdapter

        addWords.setOnClickListener {

            val intent = Intent(this, AddText::class.java)

            startActivity(intent)
        }
        //__________
        getWordsFromDatabase()
    }

    override fun onRestart() {
        super.onRestart()
        getWordsFromDatabase()
    }

    fun getWordsFromDatabase(){

        // GlobalScope to run background thread
        GlobalScope.launch {
            wordsList.clear()
            wordsList.addAll(textDao.getWords())
        }
        textRecyclarAdapter.notifyDataSetChanged()
    }
}

