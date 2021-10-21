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
import sa.edu.twuaiq.hw_week04_day05.adapter.StringAdapter
import sa.edu.twuaiq.hw_week04_day05.database.StringDao
import sa.edu.twuaiq.hw_week04_day05.database.StringDatabase
import sa.edu.twuaiq.hw_week04_day05.model.StringData


class MainActivity : AppCompatActivity() {
    private lateinit var database: StringDatabase
    private lateinit var productDao: StringDao
    private lateinit var stringRecyclerView: RecyclerView
    private lateinit var StringRecyclerViewAdapter: StringAdapter
    val stringList = mutableListOf<StringData>(

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(
            this, StringDatabase::class.java,
            "string-database"
        ).build()
        productDao = database.productDao()
        val addString: FloatingActionButton = findViewById(R.id.add_string_button)


        stringRecyclerView = findViewById(R.id.string_recyclerView)
        StringRecyclerViewAdapter = StringAdapter(this, stringList)
        stringRecyclerView.adapter = StringRecyclerViewAdapter

        addString.setOnClickListener {

            val intent = Intent(this, StringDetails::class.java)
            startActivityForResult(intent, 1)

        }
        getStringFromDatabase()

    }

    override fun onRestart() {
        super.onRestart()

        getStringFromDatabase()
    }

    fun getStringFromDatabase() {
        GlobalScope.launch { // يشغل اللي داخله في الباكغراوند
            stringList.clear()
            stringList.addAll(productDao.getString())
        }
        StringRecyclerViewAdapter.notifyDataSetChanged()
    }

}
