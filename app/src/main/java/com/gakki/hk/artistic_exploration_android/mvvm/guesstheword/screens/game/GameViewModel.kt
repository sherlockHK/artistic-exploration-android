package com.gakki.hk.artistic_exploration_android.mvvm.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    // The current score
    private val _score = MutableLiveData<Int>()
    //使用backing property，封装LiveData，只有viewmodel内部能修改livedata，外部（activity/fragment）只能读取livedata
    val score: LiveData<Int>
        get() = _score

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish

    // The list of words - the front of the list is the next word to guess
    lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        _score.value = 0
        _word.value = ""
        _eventGameFinish.value = false
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        }else{
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }


    /** Methods for buttons presses **/
    fun onSkip() {
        _score.value = _score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = _score.value?.plus(1)
        nextWord()
    }

    fun onGameFinish(){
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }
}