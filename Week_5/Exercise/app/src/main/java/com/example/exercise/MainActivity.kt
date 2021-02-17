package com.example.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = this.findViewById<Button>(R.id.btnEnter)
        val etName = this.findViewById<EditText>(R.id.etName)

        btnEnter.setOnClickListener{

            val name = etName.text.toString()

            val intent = Intent(this, BmiCalculatorActivity::class.java)

            intent.putExtra("Name", name)
            startActivity(intent)
        }
    }
}