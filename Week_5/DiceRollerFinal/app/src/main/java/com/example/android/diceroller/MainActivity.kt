/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

const val KEY_DICE_NUM = "dice_num_key"

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates an image view with a dice
 * vector image with a random value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    private var diceNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)

        if(savedInstanceState != null){
            diceNum = savedInstanceState.getInt(KEY_DICE_NUM, 0)
            Log.i("Testing", "Hello $diceNum")
            updateDiceRoller(diceNum)
            Log.i("Testing", "Testing 1")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Save data to Bundle
        outState.putInt(KEY_DICE_NUM, diceNum)
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        val randomInt = (1..6).random()
        this.diceNum = randomInt

        Log.i("Testing", "Dice Num $diceNum")
        Log.i("Testing", "Testing 2")

        updateDiceRoller(randomInt)
    }

    private fun updateDiceRoller(randomInt: Int){
        Log.i("Testing", "Hihi hello")

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Log.i("Testing", "Hihi hello 2")
        diceImage.setImageResource(drawableResource)
        Log.i("Testing", "Hihi hello 3")
    }
}
