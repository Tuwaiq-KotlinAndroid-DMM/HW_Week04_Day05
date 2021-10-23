package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val list = mutableListOf<Table>()
    private lateinit var data: Database
    private lateinit var tdao: Deo
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Addadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = Room.databaseBuilder(
            this,
            Database::class.java,
            "database"
        ).build()
        tdao = data.hdeo()
        val add: FloatingActionButton = findViewById(R.id.add_floating_button)
        recyclerView = findViewById(R.id.products_recyclerview)
        adapter = Addadapter(this,list)
        recyclerView.adapter = adapter
        add.setOnClickListener{
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        }
        getProductsFromDatabase()
    }
    override fun onRestart() {
        super.onRestart()
        list.clear()
        getProductsFromDatabase()
    }
    fun getProductsFromDatabase() {
        GlobalScope.launch {
            list.addAll( tdao.getProducts())}
        adapter.notifyDataSetChanged()



    }
}