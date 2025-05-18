package com.example.androidtrivia.data.repository

import com.example.androidtrivia.data.dao.QuestionDao
import com.example.androidtrivia.data.model.Question
import kotlinx.coroutines.flow.Flow

class QuestionRepository(private val dao: QuestionDao) {
    val allQuestions: Flow<List<Question>> = dao.getAllQuestions()
    suspend fun insert(question: Question) = dao.insert(question)
}
