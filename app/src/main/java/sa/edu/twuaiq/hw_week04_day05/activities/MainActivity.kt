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
import sa.edu.twuaiq.hw_week04_day05.adpater.WordAdapter
import sa.edu.twuaiq.hw_week04_day05.database.WordDatabase
import sa.edu.twuaiq.hw_week04_day05.database.WordDeo
import sa.edu.twuaiq.hw_week04_day05.model.WordModel

class MainActivity : AppCompatActivity() {
    private lateinit var database: WordDatabase
    private lateinit var wordDeo: WordDeo

    private lateinit var wordRecyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    val words = mutableListOf<WordModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            this,WordDatabase:: class.java , "amazon-database").build()
        wordDeo = database.wordDao()

        wordRecyclerView =findViewById(R.id.word_recycler)
        wordAdapter = WordAdapter(this, words)

        wordRecyclerView.adapter = wordAdapter


        val addButton: FloatingActionButton = findViewById(R.id.add_floating)


        addButton.setOnClickListener {

            val intent = Intent(this, AddNewWord::class.java)
            startActivity(intent)
        }
    getWords()
    }

    fun getWords(){
        GlobalScope.launch {
            words.clear()
            words.addAll(wordDeo.getWord())
        }
        wordAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        getWords()
    }
}