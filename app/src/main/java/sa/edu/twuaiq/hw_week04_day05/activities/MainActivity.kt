package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.adapters.WordsRecyclerViewAdapter
import sa.edu.twuaiq.hw_week04_day05.database.DatabaseBuilder
import sa.edu.twuaiq.hw_week04_day05.database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase
import sa.edu.twuaiq.hw_week04_day05.model.WordsModel

class MainActivity : AppCompatActivity() {

    val wordsList = mutableListOf<WordsModel>()

    //private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao

    private lateinit var wordstRecyclerView: RecyclerView
    private lateinit var wordsRecyclerViewAdapter: WordsRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        database = Room.databaseBuilder(
//            this,
//            WordsDatabase::class.java,
//            "words-database"
//        ).build()

        wordsDao = DatabaseBuilder(this).database().wordsDao()


        // views declaration from activity main
        val addWords: FloatingActionButton = findViewById(R.id.add_floating_button)
        wordstRecyclerView = findViewById(R.id.recyclerView)
        wordsRecyclerViewAdapter = WordsRecyclerViewAdapter(this, wordsList)

        // assign adapter to recyclerview
        wordstRecyclerView.adapter = wordsRecyclerViewAdapter

        addWords.setOnClickListener {
            // start activity for result
            //Android Intent is the message that is passed between components such as activities
            val intent = Intent(this, AddWords::class.java)

            startActivity(intent)
        }
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
            wordsList.addAll(wordsDao.getWords())
        }
        wordsRecyclerViewAdapter.notifyDataSetChanged()
    }
}