package sa.edu.twuaiq.hw_week04_day05.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.hw_week04_day05.Adapter.NameRecyclerViewAdapter
import sa.edu.twuaiq.hw_week04_day05.Database.Daoo
import sa.edu.twuaiq.hw_week04_day05.Database.Databasee
import sa.edu.twuaiq.hw_week04_day05.Model.NameModel
import sa.edu.twuaiq.hw_week04_day05.R

class MainActivity : AppCompatActivity() {val products = mutableListOf<NameModel>()
    private lateinit var database: Databasee
    private lateinit var productDao: Daoo
    val name = mutableListOf<NameModel>()
    private lateinit var nameRecyclerView: RecyclerView
    private lateinit var nameRecyclerViewAdapter: NameRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(this,Databasee::class.java,"database").build()
        productDao = database.Dao()

        // views declaration from activity main
        val floating: FloatingActionButton = findViewById(R.id.floatingActionButton)
        nameRecyclerView = findViewById(R.id.b_recyclerview)
        nameRecyclerViewAdapter = NameRecyclerViewAdapter(this,name)

        // assign adapter to recyclerview
        nameRecyclerView.adapter = nameRecyclerViewAdapter

        floating.setOnClickListener {
            // start activity for result
            //Android Intent is the message that is passed between components such as activities
            val intent = Intent(this, AddButton::class.java)

            /*  Starting another activity,
                whether one within your app or from another app,
                doesn't need to be a one-way operation.
                You can also start another activity and receive a result back. For example,
                your app can start a camera app and receive the captured photo as a result. Or,
                you might start the Contacts app in order for the user to select a contact and you'll receive the contact details as a result.*/
            startActivity(intent)
        }
        getNameFromDatabase()
    }



    override fun onRestart() {
        super.onRestart()
        getNameFromDatabase()
    }
    fun getNameFromDatabase() {
        GlobalScope.launch {
            name.clear()
            name.addAll(productDao.getName())
        }
        nameRecyclerViewAdapter.notifyDataSetChanged()
    }
}