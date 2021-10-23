package sa.edu.twuaiq.hw_week04_day05.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sa.edu.twuaiq.hw_week04_day05.R

class TextModel(toString: String) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}