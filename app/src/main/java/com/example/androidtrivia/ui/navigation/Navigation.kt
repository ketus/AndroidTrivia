package com.example.androidtrivia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidtrivia.ui.screens.*
import com.example.androidtrivia.viewmodel.TriviaViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddQuestion : Screen("add_question")
    object Quiz : Screen("quiz")
    object Scoreboard : Screen("scoreboard")
}

@Composable
fun TriviaNavGraph(navController: NavHostController, viewModel: TriviaViewModel) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.AddQuestion.route) { AddQuestionScreen(navController, viewModel) }
        composable(Screen.Quiz.route) { QuizScreen(navController, viewModel) }
        composable(Screen.Scoreboard.route) { ScoreboardScreen(navController, viewModel) }
    }
}

