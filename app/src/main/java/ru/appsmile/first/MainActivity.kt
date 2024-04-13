package ru.appsmile.first

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.math.log
import ru.appsmile.first.R
import ru.appsmile.second.ManualActivity
import ru.appsmile.second.SeconActivity

class MainActivity : AppCompatActivity() {
    private var editTextView: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
    private var buttonNewActivity: Button? = null
    private var checkBox: CheckBox? = null
    private var switcher: SwitchMaterial? = null
    private var maleRadioButton: RadioButton? = null
    private var colorRadioGroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_screen)

        editTextView = findViewById<EditText>(R.id.edit_text)
        textView = findViewById<TextView>(R.id.text_view)
        button = findViewById<Button>(R.id.button)
        buttonNewActivity = findViewById<Button>(R.id.button_new_activity)
        checkBox = findViewById<CheckBox>(R.id.checkbox)
        switcher = findViewById<SwitchMaterial>(R.id.switch_material)
        maleRadioButton = findViewById<RadioButton>(R.id.male)
        colorRadioGroup = findViewById<RadioGroup>(R.id.color_radio_group)

        Log.d("TAG_TEST", "onCreate: ${switcher?.isChecked}")
        Log.d("TAG_TEST", "onCreate: ${checkBox?.isChecked}")

        editTextView?.doAfterTextChanged { text ->
            textView?.text = text.toString()
            button?.isEnabled = text.toString().isNotEmpty()
            checkBox?.isEnabled = text.toString().isNotEmpty()
        }

        button?.setOnClickListener {
            editTextView?.text?.clear()
        }

        button?.setOnLongClickListener {
            checkBox?.isChecked = true
            true
        }

        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                if (editTextView?.text?.isNotEmpty() == true) {
                    Toast.makeText(this, "Is checked", Toast.LENGTH_SHORT).show()
                } else {
                    buttonView.isChecked = false
                    Toast.makeText(this, "Fill edit text", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Is not checked", Toast.LENGTH_SHORT).show()
            }
        }


        switcher?.setOnCheckedChangeListener { buttonView, isChecked ->
            Snackbar.make(buttonView, isChecked.toString(), Snackbar.LENGTH_SHORT).show()
        }

        maleRadioButton?.isChecked

        maleRadioButton?.setOnCheckedChangeListener { buttonView, isChecked ->
            Snackbar.make(buttonView, "Male is checked: ${isChecked} ", Snackbar.LENGTH_SHORT)
                .show()
        }

        editTextView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }
        })

        colorRadioGroup?.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.red -> {
                    Snackbar.make(group, "is checked: red ", Snackbar.LENGTH_SHORT)
                        .show()
                }
                R.id.green -> {
                    Snackbar.make(group, "is checked: green ", Snackbar.LENGTH_SHORT)
                        .show()
                }
                R.id.blue -> {
                    Snackbar.make(group, "is checked: blue ", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }

        buttonNewActivity?.setOnClickListener {
            val intent = Intent(this, ManualActivity::class.java)
            val age = 18L
            val size = 1.6f

            intent.putExtra("data", "Я пришел с экрана MainActivity")
            intent.putExtra("age", age)
            intent.putExtra("size", size)

            startActivity(intent)
        }
    }
}