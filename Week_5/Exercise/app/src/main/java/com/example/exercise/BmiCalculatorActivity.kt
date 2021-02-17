package com.example.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BmiCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        val intent = intent
        val name = intent.getStringExtra("Name")

        //Display name
        val tvName = findViewById<TextView>(R.id.tvName)
        tvName.text = name

        //Calculate BMI
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val tvWeightStatus = findViewById<TextView>(R.id.tvWeightStatus)

        btnCalculate.setOnClickListener {
            //Get the value
            val weight = etWeight.text.toString().toDouble()
            val height = etHeight.text.toString().toDouble()

            val bodyStatus = calculateBMI(weight, height)

            //Display status
            tvWeightStatus.text = bodyStatus
        }
    }

    private fun calculateBMI(weight: Double, height: Double): String{
        val bmi = weight / (height * height)

        when {
            bmi < 18.5 -> {
                return "Underweight (" + String.format("%.2f", bmi) + ")"
            }
            bmi in 18.5..24.9 -> {
                return "Normal Weight (" + String.format("%.2f", bmi) + ")"
            }
            bmi in 25.0..29.9 -> {
                return "Overweight (" + String.format("%.2f", bmi) + ")"
            }
            bmi in 30.0..34.9 -> {
                return "Obesity Class I (" + String.format("%.2f", bmi) + ")"
            }
            bmi in 35.0..39.9 -> {
                return "Obesity Class II (" + String.format("%.2f", bmi) + ")"
            }
            bmi >= 40.0 -> {
                return "Obesity Class III (" + String.format("%.2f", bmi) + ")"
            }
        }

        return ""
    }
}