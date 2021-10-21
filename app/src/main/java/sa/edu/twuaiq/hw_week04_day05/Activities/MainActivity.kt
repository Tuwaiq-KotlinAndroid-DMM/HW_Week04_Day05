package sa.edu.twuaiq.hw_week04_day05.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.Adapter.AddTextRecyclerViewAdapter
import sa.edu.twuaiq.hw_week04_day05.Database.AddTextView
import sa.edu.twuaiq.hw_week04_day05.Database.AddWordDatabase
import sa.edu.twuaiq.hw_week04_day05.Modle.AddWordModle
import sa.edu.twuaiq.hw_week04_day05.R

class MainActivity : AppCompatActivity() {
val texts= mutableListOf<AddWordModle>()
    private lateinit var database: AddWordDatabase
    private lateinit var addtextviewdao:AddTextView

    private lateinit var addtextrecyclerview:RecyclerView
    private lateinit var addTextRecyclerViewAdapter: AddTextRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


database=Room.databaseBuilder(
this,
AddWordDatabase::class.java,
"addword_database").build()
        addtextviewdao=database.addtextview()
val addtext: FloatingActionButton = findViewById(R.id.add_floating_button)
        addtextrecyclerview = findViewById(R.id.add_recyclerview)
        addTextRecyclerViewAdapter = AddTextRecyclerViewAdapter(this,texts)

addtextrecyclerview.adapter=addTextRecyclerViewAdapter

        addtext.setOnClickListener{
                    val intent=Intent(this,AddWord::class.java)
startActivity(intent)

        }


        gettextFromDatabase()
    }



    fun gettextFromDatabase(){
        GlobalScope.launch {
            texts.clear()
            texts.addAll(addtextviewdao.getProducts())
        }
        addTextRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        gettextFromDatabase()
    }
}