package com.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.template.ui.theme.FinishScreen
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
                    composable(
                        "FinishScreen/{counterAnswer}/final/{step}",
                        arguments = listOf(navArgument("counterAnswer") { type = NavType.IntType },
                        navArgument("step") { type = NavType.IntType },
                        )
                    ) {
                        FinishScreen(
                            navController = navController,
                            counterAnswer = it.arguments?.getInt("counterAnswer"),
                            step = it.arguments?.getInt("step")
                        )
                    }
                }
            }
        }
    }
}
