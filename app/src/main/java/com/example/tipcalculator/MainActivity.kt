package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /*
    initialize the variables
     */
    private lateinit var convertBtn: Button
    private lateinit var tipOptions: RadioGroup
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var roundSwitch: Switch
    private lateinit var conversionResult: TextView
    private lateinit var weightToConvert: EditText
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the views
        convertBtn = findViewById(R.id.convert_button)
        tipOptions = findViewById(R.id.tip_options)
        roundSwitch = findViewById(R.id.round_up_switch)
        conversionResult = findViewById(R.id.converted_weight)
        weightToConvert = findViewById(R.id.weight_to_convert)

        // add clickListener for convert button
        convertBtn.setOnClickListener {
            val text = weightToConvert.text.toString()
            var conversionRate = 0.0
            var result = 0.0

            // check which radio button is selected and assign value
            conversionRate = when (tipOptions.checkedRadioButtonId) {
                R.id.option_gm_to_cups -> 0.004
                R.id.option_cups_to_gm -> 250.0
                R.id.option_ml_to_oz -> 0.033814
                R.id.option_oz_to_ml -> 29.5735
                else -> 0.004
            }

            // get the conversion result
            result = text.toFloat() * conversionRate

            //check if rounding is needed
            if (roundSwitch.isChecked) {
                result = result.toInt().toDouble()
            }

            // display the result
            conversionResult.text = "Result: ${result.toString()}"
        }
    }
}