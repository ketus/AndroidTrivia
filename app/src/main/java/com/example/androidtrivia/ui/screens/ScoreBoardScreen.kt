package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.androidtrivia.ui.navigation.Screen
import com.example.androidtrivia.viewmodel.TriviaViewModel

@Composable
fun ScoreboardScreen(navController: NavHostController, viewModel: TriviaViewModel) {
    Button(onClick = { navController.navigate(Screen.Home) }, modifier = Modifier.fillMaxWidth()) {
        Text("Geri")
    }
    Text("Scoreboard")
}
