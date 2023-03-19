package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    /*
    initialize the variables
     */
    private lateinit var calculateBtn: Button
    private lateinit var costOfService: EditText
    private lateinit var tipOptions: RadioGroup
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var roundSwitch: Switch
    private lateinit var tipAmount: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the views
        calculateBtn = findViewById(R.id.calculate_button)
        costOfService = findViewById(R.id.cost_of_service)
        tipOptions = findViewById(R.id.tip_options)
        roundSwitch = findViewById(R.id.round_up_switch)
        tipAmount = findViewById(R.id.tip_result)

        // set the click listener on calculate button
        calculateBtn.setOnClickListener {
            val text = costOfService.text.toString()
            var tipPercent = 0f
            var totalTip = 0f

            // check which radio button is checked and assign the tip rate
            when (tipOptions.checkedRadioButtonId) {
                R.id.option_twenty_percent -> tipPercent = 0.2f
                R.id.option_eighteen_percent -> tipPercent = 0.18f
                R.id.option_fifteen_percent -> tipPercent = 0.15f
                else -> tipPercent = 0.2f
            }

            // calculate total tip
            totalTip = text.toFloat() * tipPercent

            // round up the tip if the switch is checked
            if (roundSwitch.isChecked) {
                totalTip = totalTip.roundToInt().toFloat()
            }

            // display the tip amount
            tipAmount.text = "Tip amount: ${totalTip.toString()}"
        }
    }
}