package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var _count = 0
    val count: Int
        get() = _count

    // -1 value because we will call getNextWord when initialize this view model
    private var _currentWordCount = -1
    val currentWordCount: Int
        get() = _currentWordCount

    private var _score = 0
    val score: Int
        get() = _score

    // initializer block
    init {
        Log.d("GameFragment", "GameViewModel created!")

        //To prevent first word always the same
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    /*
    * Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    private fun increaseScore(){
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean{
        if(playerWord.equals(currentWord, true)){
            increaseScore()
            return true
        }

        return false
    }
}