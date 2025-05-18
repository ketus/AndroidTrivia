package com.example.androidtrivia.data.dao

import androidx.room.*
import com.example.androidtrivia.data.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): Flow<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: Question)

    @Delete
    suspend fun delete(question: Question)
}
