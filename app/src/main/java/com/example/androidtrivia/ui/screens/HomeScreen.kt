package com.example.androidtrivia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidtrivia.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate(Screen.AddQuestion.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Add / Edit Questions")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.Quiz.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Start Quiz")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.Scoreboard.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("View Scoreboard")
        }
    }
}