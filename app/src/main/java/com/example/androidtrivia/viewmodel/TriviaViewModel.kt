package com.example.androidtrivia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtrivia.data.db.AppDatabase
import com.example.androidtrivia.data.model.Question
import com.example.androidtrivia.data.model.Score
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TriviaViewModel(database: AppDatabase) : ViewModel() {
    private val questionDao = database.questionDao()
    private val scoreDao = database.scoreDao()

    val questions = questionDao.getAllQuestions().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val scores = scoreDao.getAllScores().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun insertQuestion(question: Question) {
        viewModelScope.launch {
            questionDao.insert(question)
        }
    }

    fun deleteQuestion(question: Question) {
        viewModelScope.launch {
            questionDao.delete(question)
        }
    }

    fun saveScore(score: Int) {
        viewModelScope.launch {
            scoreDao.insert(Score(score = score))
        }
    }
}
