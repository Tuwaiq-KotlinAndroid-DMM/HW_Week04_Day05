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
import sa.edu.twuaiq.hw_week04_day05.adapter.TextAdapter
import sa.edu.twuaiq.hw_week04_day05.database.TextDao
import sa.edu.twuaiq.hw_week04_day05.database.TextDataBase
import sa.edu.twuaiq.hw_week04_day05.model.TextDataClass

class MainActivity : AppCompatActivity() {
    val texts = mutableListOf<TextDataClass>()

    private lateinit var database: TextDataBase
    private lateinit var textDao: TextDao


    private lateinit var textRecyclerView: RecyclerView
    private lateinit var textRecyclerViewAdapter: TextAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            this,
            TextDataBase::class.java,
            "Text Database"
        ).build()
        textDao = database.TextDao()

        val addProduct: FloatingActionButton = findViewById(R.id.floatingActionButton)
        textRecyclerView = findViewById(R.id.textRecyclerView)
        textRecyclerViewAdapter = TextAdapter(this,texts)

        textRecyclerView.adapter = textRecyclerViewAdapter

        addProduct.setOnClickListener {

            val intent = Intent(this, AddText::class.java)
            startActivity(intent)
        }
        getProductsFromDatabase()
    }
    override fun onRestart() {
        super.onRestart()
        getProductsFromDatabase()
    }
    fun getProductsFromDatabase(){
        GlobalScope.launch {
            texts.clear()
            texts.addAll(textDao.getText())
        }
        textRecyclerViewAdapter.notifyDataSetChanged()
    }
}

