package com.template.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.template.MainActivity

@Composable
fun StartScreen(navController: NavController) {

    var openCloseDialog by remember { mutableStateOf(false) }

    var openModeDialog by remember { mutableStateOf(false) }

    val activity = LocalContext.current as MainActivity

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
                    Icons.Filled.AccountBox,
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
                    text = "quiz",
                    style = MaterialTheme.typography.h1
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
                        onClick = { openCloseDialog = true},
                        modifier = Modifier
                            .height(56.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                    ) {
                        Text(
                            text = "Exit",
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
                            text = "Play",
                            style = MaterialTheme.typography.h2
                        )
                    }
                }
            }
        }
        if (openCloseDialog) {
            CloseDialog (
                { openCloseDialog = false },
                { activity.finish() }
            )
        }
    if (openModeDialog) {
        ModeDialog (
            { openModeDialog = false },
            { counter -> navController.navigate("PlayScreen/$counter") }
        )
    }
    }

@Composable
fun CloseDialog(
    onDismiss: () -> Unit,
    onClick: () -> Unit
){
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                style = MaterialTheme.typography.h2,
                text = "Do you really want to quit the game?",
                textAlign = TextAlign.Center
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { onClick()},
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Yes",
                        style = MaterialTheme.typography.h2
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { onDismiss()},
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "No",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    )
}

@Composable
fun ModeDialog(
    onDismiss: () -> Unit,
    onClick: (Int) -> Unit
){
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                style = MaterialTheme.typography.h2,
                text = "Game mode:",
                textAlign = TextAlign.Center
            )
        },
        buttons = {
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
            ) {
                Button(
                    onClick = { onClick(2)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Easy",
                        style = MaterialTheme.typography.h2
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onClick(1)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Medium",
                        style = MaterialTheme.typography.h2
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onClick(0)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Hard",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    )
}
