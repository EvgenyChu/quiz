package com.template

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlayViewModel() : ViewModel() {
    private val _state: MutableStateFlow<PlayState> = MutableStateFlow(PlayState())

    val state: StateFlow<PlayState>
        get() = _state

    val currentState: PlayState
        get() = state.value

    fun selected(id: Int) {
        if (currentState.question.answers.find { it.id == id }?.isCorrect == true ) {
            _state.value = currentState.copy(
                dialogText = "This is the correct answer",
                counterAnswer = currentState.counterAnswer.inc()
            )
        }
        else {
            val correctAnswer = currentState.question.answers.find { it.isCorrect }?.title ?: ""
            _state.value = currentState.copy(dialogText = "This is the wrong answer\n correct answer: $correctAnswer")
        }
    }

    fun updateStep(){
        _state.value = currentState.copy(step = currentState.step.inc())
    }
}

data class PlayState(
    val counterAnswer: Int = 0,
    val step: Int = 0,
    val dialogText: String = ""
){
    val question: Question
    get() = Questions.questions[step]
}