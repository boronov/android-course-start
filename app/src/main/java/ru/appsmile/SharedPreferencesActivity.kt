package ru.appsmile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.appsmile.first.R

class SharedPreferencesActivity : AppCompatActivity() {

    private var sharedPreferencesFirst: SharedPreferences? = null
    private var sharedPreferencesSecond: SharedPreferences? = null

    private var textViewCounter: TextView? = null
    private var buttonPlus: Button? = null
    private var buttonMinus: Button? = null

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        // use the shared preferences and editor as you normally would

        // use the shared preferences and editor as you normally would
        sharedPreferencesFirst = getSharedPreferences("my_first_storage", Context.MODE_PRIVATE)

        sharedPreferencesSecond = getSharedPreferences("second_storage", Context.MODE_PRIVATE)

        sharedPreferencesSecond?.edit()?.putString("name", "Anton")?.apply()

        counter = sharedPreferencesFirst?.getInt("counter", 0) ?: 0

        sharedPreferencesFirst?.edit()?.putInt("counter_2", 1)?.apply()

        Log.d("TAG_TEST", "counter: ${sharedPreferencesFirst?.contains("counter")}")
        Log.d("TAG_TEST", "counter_1: ${sharedPreferencesFirst?.contains("counter_1")}")
        Log.d("TAG_TEST", "counter_2: ${sharedPreferencesFirst?.contains("counter_2")}")
        Log.d("TAG_TEST", "name: ${sharedPreferencesSecond?.contains("name")}")

        sharedPreferencesFirst?.edit()?.remove("counter_2")?.apply()

        Log.d("TAG_TEST", "counter: ${sharedPreferencesFirst?.contains("counter")}")
        Log.d("TAG_TEST", "counter_1: ${sharedPreferencesFirst?.contains("counter_1")}")
        Log.d("TAG_TEST", "counter_2: ${sharedPreferencesFirst?.contains("counter_2")}")
        Log.d("TAG_TEST", "name: ${sharedPreferencesSecond?.contains("name")}")

        sharedPreferencesFirst?.edit()?.clear()?.apply()

        Log.d("TAG_TEST", "counter: ${sharedPreferencesFirst?.contains("counter")}")
        Log.d("TAG_TEST", "counter_1: ${sharedPreferencesFirst?.contains("counter_1")}")
        Log.d("TAG_TEST", "counter_2: ${sharedPreferencesFirst?.contains("counter_2")}")
        Log.d("TAG_TEST", "name: ${sharedPreferencesSecond?.contains("name")}")

        sharedPreferencesSecond?.edit()?.clear()?.apply()

        Log.d("TAG_TEST", "counter: ${sharedPreferencesFirst?.contains("counter")}")
        Log.d("TAG_TEST", "counter_1: ${sharedPreferencesFirst?.contains("counter_1")}")
        Log.d("TAG_TEST", "counter_2: ${sharedPreferencesFirst?.contains("counter_2")}")
        Log.d("TAG_TEST", "name: ${sharedPreferencesSecond?.contains("name")}")


        textViewCounter = findViewById(R.id.text_view_counter)
        buttonMinus = findViewById(R.id.button_minus)
        buttonPlus = findViewById(R.id.button_plus)

        textViewCounter?.text = counter.toString()

        buttonPlus?.setOnClickListener {
            counter++
            textViewCounter?.text = counter.toString()

            sharedPreferencesFirst?.edit()?.putInt("counter_1", counter)?.apply()
        }

        buttonMinus?.setOnClickListener {
            if (counter != 0)
                counter--

            textViewCounter?.text = counter.toString()
            sharedPreferencesFirst?.edit()?.putInt("counter_1", counter)?.apply()
        }

    }
}