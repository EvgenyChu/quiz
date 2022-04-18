package com.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.template.ui.theme.PlayScreen
import com.template.ui.theme.QuizTheme
import com.template.ui.theme.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            QuizTheme {
                NavHost(navController = navController, startDestination = "StartScreen") {
                    composable("StartScreen") { StartScreen(navController = navController) }
                    composable(
                        "PlayScreen/{counter}",
                        arguments = listOf(navArgument("counter") { type = NavType.IntType }
                        )
                    ) {
                        PlayScreen(
                            navController = navController,
                            counter = it.arguments?.getInt("counter")
                        )
                    }
                }
            }
        }
    }
}
