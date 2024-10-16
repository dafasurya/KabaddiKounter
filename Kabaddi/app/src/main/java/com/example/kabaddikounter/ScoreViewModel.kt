package com.example.kabaddikounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _teamAScore = MutableLiveData(0)
    val teamAScore: LiveData<Int> get() = _teamAScore

    private val _teamBScore = MutableLiveData(0)
    val teamBScore: LiveData<Int> get() = _teamBScore

    fun addPoints(team: Int, points: Int) {
        when (team) {
            1 -> _teamAScore.value = _teamAScore.value?.plus(points)
            2 -> _teamBScore.value = _teamBScore.value?.plus(points)
        }
    }

    fun resetScores() {
        _teamAScore.value = 0
        _teamBScore.value = 0
    }
}
