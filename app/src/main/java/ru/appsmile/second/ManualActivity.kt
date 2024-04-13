package ru.appsmile.second

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.appsmile.first.R

class ManualActivity : AppCompatActivity() {

    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual)

        textView = findViewById(R.id.text_view)
        textView?.text = intent.getFloatExtra("size", -1.0f).toString()
      //  intent.getBooleanExtra()
      //  intent.getFloatExtra()

    }
}