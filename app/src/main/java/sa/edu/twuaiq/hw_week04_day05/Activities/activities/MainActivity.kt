package sa.edu.twuaiq.hw_week04_day05.Activities.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import sa.edu.twuaiq.hw_week04_day05.R
import sa.edu.twuaiq.hw_week04_day05.Activities.Adapters.WordsAdapterClass
import sa.edu.twuaiq.hw_week04_day05.Activities.Database.WordsDao
import sa.edu.twuaiq.hw_week04_day05.Activities.Database.WordsDataBase
import sa.edu.twuaiq.hw_week04_day05.Activities.Model.WordsDataModel
import android.content.Intent
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
     val words = mutableListOf<WordsDataModel>()

    // database declaration
    private lateinit var dataBase: WordsDataBase
    private lateinit var wordsDao: WordsDao

    // activity main views declartion
    private lateinit var word_recyclerview : RecyclerView
    private lateinit var WordsAdapterClass : WordsAdapterClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        word_recyclerview  = findViewById(R.id.word_recyclerview)
        WordsAdapterClass = WordsAdapterClass(words)
        word_recyclerview.adapter = WordsAdapterClass

        dataBase = Room.databaseBuilder(
            this,
            WordsDataBase::class.java,
            "words-database" ).build()

        wordsDao = dataBase.wordsDao()


        var addButton: FloatingActionButton = findViewById(R.id.add_floatingActionButton)




        addButton.setOnClickListener{
            val intent = Intent(this, AddWords:: class.java)
            startActivity(intent)
        }
        getWordsFromDatabase ()
    }

    override fun onRestart() {

        super.onRestart()
        getWordsFromDatabase () }

 fun getWordsFromDatabase () {
        GlobalScope.launch {

            words.clear()
            words.addAll(wordsDao.getWords())

        }
        WordsAdapterClass.notifyDataSetChanged()

    }
}