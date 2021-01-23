package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip(){
        // Get the text in edit text
        val stringInTextField = binding.costOfService.text.toString()
        // Convert the text into double value
        val cost = stringInTextField.toDoubleOrNull()

        if(cost == null){
            binding.tipResult.text = ""
            return
        }

        // Check which option is selected
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        /* Set the tip with var is
        to round up the cost later on if the switch is checked*/
        var tip = cost * tipPercentage

        // Round up the cost if user check the switch
        if(binding.roundUpSwitch.isChecked){
            tip = ceil(tip)
        }

        // Display the formatted tip on the screen
        displayTip(tip)
    }

    private fun displayTip(tip: Double){
        // Format the cost with different currency
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        // Insert the formattedTp into tip amount
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}