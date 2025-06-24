package com.example.androidtrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidtrivia.data.db.AppDatabase
import com.example.androidtrivia.ui.navigation.TriviaNavGraph
import com.example.androidtrivia.viewmodel.TriviaViewModel
import com.example.androidtrivia.viewmodel.TriviaViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val triviaViewModel = viewModel<TriviaViewModel>(
                factory = TriviaViewModelFactory(application)
            )
            TriviaNavGraph(navController = navController, viewModel = triviaViewModel)
        }
    }
}
