package ru.appsmile.first

import android.os.Bundle
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
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.math.log
import ru.appsmile.first.R

class MainActivity : AppCompatActivity() {
    private var editTextView: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
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
    }
}