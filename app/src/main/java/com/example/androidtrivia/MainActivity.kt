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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(this)

        setContent {
            val navController = rememberNavController()
            val triviaViewModel = viewModel<TriviaViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return TriviaViewModel(database) as T
                    }
                }
            )
            TriviaNavGraph(navController = navController, viewModel = triviaViewModel)
        }
    }
}
