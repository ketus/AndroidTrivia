package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidtrivia.ui.navigation.Screen
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun AddQuestionScreen(navController: NavHostController, viewModel: TriviaViewModel) {
    Text("Add / Edit Questions")
}