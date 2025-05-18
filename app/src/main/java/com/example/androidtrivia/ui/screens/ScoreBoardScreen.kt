package com.example.androidtrivia.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun ScoreboardScreen(navController: NavHostController, viewModel: TriviaViewModel) {
    Text("Scoreboard")
}
