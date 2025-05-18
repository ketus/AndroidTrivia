package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun TriviaScreen(viewModel: TriviaViewModel) {
    val questions by viewModel.questions.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        questions.forEach { question ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = question.questionText)
                    Spacer(Modifier.height(8.dp))
                    Text("A: ${question.optionA}")
                    Text("B: ${question.optionB}")
                    Text("C: ${question.optionC}")
                }
            }
        }
    }
}
