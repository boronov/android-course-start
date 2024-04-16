package ru.appsmile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ru.appsmile.adapter.NumberAdapter
import ru.appsmile.first.R

class NewsActivity : AppCompatActivity() {

    private var numberPanel: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        numberPanel = findViewById(R.id.recycler_view)
        numberPanel?.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        numberPanel?.adapter = NumberAdapter((1..100).toList())
    }
}