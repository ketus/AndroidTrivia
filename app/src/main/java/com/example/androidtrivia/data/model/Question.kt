package com.example.androidtrivia.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val correctAnswer: String
)
