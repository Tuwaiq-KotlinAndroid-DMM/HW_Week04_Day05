package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapter.WordRecyclerViewAdapter
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class MainActivity : AppCompatActivity() {
    val words = mutableListOf<WordsModel>()

    private lateinit var database: WordsDatabase
    private lateinit var wordDao: WordDao
    private lateinit var wordRecyclerView: RecyclerView
    private lateinit var wordRecyclerViewAdapter: WordRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(
            this,
            WordsDatabase::class.java,
            "words-database"
        ).build()

        wordDao = database.wordsDao()

        val addFloatButton: FloatingActionButton = findViewById(R.id.add_float_button)
        wordRecyclerView = findViewById(R.id.recycler_view)
        wordRecyclerViewAdapter = WordRecyclerViewAdapter(this,words)
        wordRecyclerView.adapter = wordRecyclerViewAdapter



        addFloatButton.setOnClickListener {
            val intent = Intent(this,addWord::class.java)

            startActivity(intent)
        }





    }

    fun getWordsFromDatabase(){
        GlobalScope.launch {
            words.clear()
            words.addAll(wordDao.getWords())
        }
        wordRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        getWordsFromDatabase()
    }
}