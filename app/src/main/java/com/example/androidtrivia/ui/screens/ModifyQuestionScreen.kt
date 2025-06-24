package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidtrivia.data.model.Question
import com.example.androidtrivia.ui.navigation.Screen
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun AddQuestionScreen(
    navController: NavHostController,
    viewModel: TriviaViewModel,
    modifier: Modifier = Modifier
) {
    // Form state
    var questionName by remember { mutableStateOf(TextFieldValue("")) }
    var optionA by remember { mutableStateOf(TextFieldValue("")) }
    var optionB by remember { mutableStateOf(TextFieldValue("")) }
    var optionC by remember { mutableStateOf(TextFieldValue("")) }
    var correctAnswer by remember { mutableStateOf(TextFieldValue("")) }

    // Collect questions from ViewModel
    val questions by viewModel.questions.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Navigation + Form
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text("Back")
        }
        Spacer(Modifier.height(16.dp))

        TextField(
            value = questionName,
            onValueChange = { questionName = it },
            label = { Text("Question") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = optionA,
            onValueChange = { optionA = it },
            label = { Text("Option A") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = optionB,
            onValueChange = { optionB = it },
            label = { Text("Option B") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = optionC,
            onValueChange = { optionC = it },
            label = { Text("Option C") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = correctAnswer,
            onValueChange = { correctAnswer = it },
            label = { Text("Correct Answer") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    // Add question with auto-generated ID (0)
                    viewModel.insertQuestion(
                        Question(
                            questionText = questionName.text,
                            optionA = optionA.text,
                            optionB = optionB.text,
                            optionC = optionC.text,
                            correctAnswer = correctAnswer.text
                        )
                    )
                }
            ) {
                Text("Add")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    questionName = TextFieldValue("")
                    optionA = TextFieldValue("")
                    optionB = TextFieldValue("")
                    optionC = TextFieldValue("")
                    correctAnswer = TextFieldValue("")
                }
            ) {
                Text("Clear")
            }
        }

        Spacer(Modifier.height(24.dp))

        // Display added questions
        Text("Existing Questions:", style = MaterialTheme.typography.titleMedium)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(questions) { question ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Q: ${question.questionText}", style = MaterialTheme.typography.bodyLarge)
                        Text("A: ${question.optionA}")
                        Text("B: ${question.optionB}")
                        Text("C: ${question.optionC}")
                        Text("Correct: ${question.correctAnswer}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
