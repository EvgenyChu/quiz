package com.template.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FinishScreen(
    navController: NavController,
    counterAnswer: Int?,
    step: Int?
) {
    var openModeDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                if (counterAnswer != null && counterAnswer > 7) Icons.Filled.Done else Icons.Filled.Close,
                contentDescription = "Logo",
                tint = MaterialTheme.colors.onSecondary,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
            Text(
                text = "Your score:\nRight answers: $counterAnswer\nWrong answers: " +
                        "${if (step != null && counterAnswer != null) step - counterAnswer + 1 else 0}",
                style = MaterialTheme.typography.h2
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate("StartScreen") },
                    modifier = Modifier
                        .height(56.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Main menu",
                        style = MaterialTheme.typography.h2
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { openModeDialog = true },
                    modifier = Modifier
                        .height(56.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Play again",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    }

    if (openModeDialog) {
        ModeDialog(
            { openModeDialog = false },
            { counter -> navController.navigate("PlayScreen/$counter") }
        )
    }
}