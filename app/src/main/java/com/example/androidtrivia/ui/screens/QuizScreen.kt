package com.example.androidtrivia.ui.screens

import android.app.AlertDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidtrivia.R
import com.example.androidtrivia.ui.navigation.Screen
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun QuizScreen(navController: NavHostController, viewModel: TriviaViewModel, modifier: Modifier) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    val questions by viewModel.questions.collectAsState()
    var currentQuestion by rememberSaveable { mutableStateOf(0) }
    val question = questions[currentQuestion]

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Button(onClick = { navController.navigate(Screen.Home) }, modifier = Modifier) {
                    Text("Geri")
                }
            }
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {if (currentQuestion < questions.size - 1) {
                    currentQuestion++
                } else {
                    //nav
                }}
            ) {
                Text(stringResource(R.string.nextQuestion))
            }
        }
    }
}

fun onNextQuestion(currentQuestion: Int):Int {
  return currentQuestion+1;
}
