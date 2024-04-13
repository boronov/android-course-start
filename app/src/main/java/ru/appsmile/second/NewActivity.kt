package ru.appsmile.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.appsmile.first.R

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
    }
}