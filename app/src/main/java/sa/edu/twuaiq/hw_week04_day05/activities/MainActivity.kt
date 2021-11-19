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
import sa.edu.twuaiq.hw_week04_day05.adapter.WordAdapter
import sa.edu.twuaiq.hw_week04_day05.database.WordDao
import sa.edu.twuaiq.hw_week04_day05.database.WordModel
import sa.edu.twuaiq.hw_week04_day05.model.WordDataClass

class MainActivity : AppCompatActivity() {

    val words = mutableListOf<WordModel>()
    private lateinit var database: WordDataClass
    private lateinit var wordDao: WordDao


    private lateinit var wordRecyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this, WordDataClass::class.java, "Word Database").build()
        wordDao = database.WordDao()



        val addWord: FloatingActionButton = findViewById(R.id.floatingActionButton)
        wordRecyclerView = findViewById(R.id.word_recyclerview)
        wordAdapter = WordAdapter(this, words)


        addWord.setOnClickListener{
            val intent: Intent(this, AddActivity::class.java)
                         startActivity(intent)
        }

        getWordsFromDatabase()
    }

    override fun onRestart() {
        super.onRestart()
        getWordsFromDatabase()
    }
    fun getWordsFromDatabase(){
        GlobalScope.launch {
            words.clear()
            words.addAll(wordDao.getWord())
        }
        wordAdapter.notifyDataSetChanged()
    }

}