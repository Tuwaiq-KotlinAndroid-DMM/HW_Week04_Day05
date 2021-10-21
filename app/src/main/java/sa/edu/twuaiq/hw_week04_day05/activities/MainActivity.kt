package sa.edu.twuaiq.hw_week04_day05.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.models.WordsDataModel
import sa.edu.twuaiq.hw_week04_day05.adapters.WordsRecyclerViewAdapter
import sa.edu.twuaiq.hw_week04_day05.database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.database.WordsDatabase

class MainActivity : AppCompatActivity() {

    // Model List

    val words = mutableListOf<WordsDataModel>()

    //declaration for the database
    private lateinit var database: WordsDatabase
    private lateinit var wordsDao: WordsDao

    //declaration for the recyclerview + adapter

    private lateinit var wordsRecyclerView: RecyclerView
    private lateinit var wordsRecyclerViewAdapter: WordsRecyclerViewAdapter


    // declaration and assignments
    val text: TextView = findViewById(R.id.WordtextView)






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaration+assignment
        val add_floatingbutton: FloatingActionButton = findViewById(R.id.add_floatingButton)

        // assigment of database
    database = Room.databaseBuilder(this, WordsDatabase::class.java
        , "words-database").build()

        wordsDao = database.wordsDao()

        add_floatingbutton.setOnClickListener {

            val intent = Intent(this, Add_Data::class.java)
            startActivity(intent)

        }

        // assignment of recyclerview +adapter

        wordsRecyclerViewAdapter = WordsRecyclerViewAdapter(this, words)
        wordsRecyclerView = findViewById(R.id.word_recyclerView)

        //assigning the recycler view to its adapter
        wordsRecyclerView.adapter = wordsRecyclerViewAdapter

        // calling the getWordsFromDatabase function
        getWordsFromDatabase()



        }

    override fun onRestart() {
        super.onRestart()
        getWordsFromDatabase()
    }

    fun getWordsFromDatabase() {



        lifecycleScope.launch {

            // clear the data
            words.clear()
// get the function in the database class and adding it to the list

            words.addAll(wordsDao.getWords())
            wordsRecyclerViewAdapter.notifyDataSetChanged()
        }


    }
}