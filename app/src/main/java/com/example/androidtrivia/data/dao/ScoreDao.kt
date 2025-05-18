package com.example.androidtrivia.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidtrivia.data.model.Score
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
    @Query("SELECT * FROM scores ORDER BY id DESC")
    fun getAllScores(): Flow<List<Score>>

    @Insert
    suspend fun insert(score: Score)
}
