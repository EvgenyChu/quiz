package com.template.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.template.PlayViewModel

@Composable
fun PlayScreen(
    navController: NavController,
    counter: Int?,
    vm: PlayViewModel = viewModel()
) {
    val state by vm.state.collectAsState()

    var number by remember { mutableStateOf(0) }

    var isSelected by remember { mutableStateOf(false) }

    var openDialog by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = Unit) {
        vm.initState(counter = counter)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Game",
                    style = MaterialTheme.typography.h1
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = state.question,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Divider(color = MaterialTheme.colors.surface)
            state.answer.forEach {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .clickable {
                            if (!isSelected) {
                                vm.selected(it)
                                isSelected = true
                                openDialog = true
                            }
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h3
                    )
                }
                Divider(color = MaterialTheme.colors.surface)
            }
        }
    }
    if (openDialog) {
        AnswerDialog (
            {
                openDialog = false
                vm.updateState(number = number++)
                isSelected = false
            },
            if (state.isSelected) "This is the correct answer"
        else "This is the wrong answer\n correct answer: ${state.answer[state.correctAnswer]}"
        )
    }
}

@Composable
fun AnswerDialog(
    onDismiss: () -> Unit,
    text: String,
){
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                style = MaterialTheme.typography.h2,
                text = text,
                textAlign = TextAlign.Center
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { onDismiss()},
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Close",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    )
}