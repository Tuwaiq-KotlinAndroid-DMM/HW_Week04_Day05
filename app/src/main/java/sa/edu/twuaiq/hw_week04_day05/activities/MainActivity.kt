package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapters.WordAdapter
import sa.edu.twuaiq.hw_week04_day05.database.DatabaseBuilder
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    // Words list
    val wordsList = mutableListOf<WordModel>()

    // Database Builder
    private lateinit var wordDao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Build the DB
        wordDao = DatabaseBuilder(this).buildDB().wordDao()

        val addFloatingButton: FloatingActionButton = findViewById(R.id.add_floatingButton)
        recyclerView = findViewById(R.id.words_recyclerview)
        wordAdapter = WordAdapter(this, wordsList)

        recyclerView.adapter = wordAdapter

        addFloatingButton.setOnClickListener {
            val intent = Intent(this, AddWord::class.java)
            startActivity(intent)
        }

        getWordsFromDB()

    }

    override fun onRestart() {
        super.onRestart()
        getWordsFromDB()
    }

    fun getWordsFromDB() {
        GlobalScope.launch {
            wordsList.clear()
            wordsList.addAll(
                wordDao.getWords()

            )
        }
        wordAdapter.notifyDataSetChanged()
    }
}