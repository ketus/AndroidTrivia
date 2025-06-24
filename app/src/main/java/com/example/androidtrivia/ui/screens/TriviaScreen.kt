package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun TriviaScreen(viewModel: TriviaViewModel) {
    val questions by viewModel.questions.collectAsState()
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        questions.forEach { question ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = question.questionText)
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.selectable(
                            selected = selectedValue == question.optionA,
                            onClick = {
                                selectedValue = question.optionA
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedValue == question.optionA,
                            onClick = {
                                selectedValue = question.optionA
                            }
                        )
                        Text(question.optionA)
                    }
                    Row(
                        modifier = Modifier.selectable(
                            selected = selectedValue == question.optionB,
                            onClick = {
                                selectedValue = question.optionB
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedValue == question.optionB,
                            onClick = {
                                selectedValue = question.optionB
                            }
                        )
                        Text(question.optionB)
                    }
                    Row(
                        modifier = Modifier.selectable(
                            selected = selectedValue == question.optionC,
                            onClick = {
                                selectedValue = question.optionC
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedValue == question.optionC,
                            onClick = {
                                selectedValue = question.optionC
                            }
                        )
                        Text(question.optionC)
                    }
                }
            }
        }
    }
}
