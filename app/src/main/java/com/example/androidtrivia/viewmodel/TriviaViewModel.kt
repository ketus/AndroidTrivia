package com.example.androidtrivia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtrivia.data.db.AppDatabase
import com.example.androidtrivia.data.model.Question
import com.example.androidtrivia.data.model.Score
import com.example.androidtrivia.data.repository.QuestionRepository
import com.example.androidtrivia.data.repository.ScoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TriviaViewModel(application: Application) : AndroidViewModel(application) {
    private val questionDao = QuestionRepository(AppDatabase.getDatabase(application).questionDao())
    private val scoreDao = ScoreRepository(AppDatabase.getDatabase(application).scoreDao())

    val questions = questionDao.allQuestions.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val scores = scoreDao.allScores.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun insertQuestion(question: Question) {
        viewModelScope.launch(Dispatchers.IO) {
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
