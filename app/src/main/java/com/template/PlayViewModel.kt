package com.template

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayViewModel() : ViewModel() {
    private val _state: MutableStateFlow<PlayState> = MutableStateFlow(PlayState())

    val state: StateFlow<PlayState>
        get() = _state

    val currentState: PlayState
        get() = state.value

    fun initState(counter: Int?) {

        viewModelScope.launch {
            _state.value = currentState.copy(
                question = Questions.questions[0],
                answer = Questions.answers[0],
                correctAnswer = Questions.correctAnswer[0],
                counter = counter ?: 0
            )
        }
    }

    fun selected(answer: String) {
        val selectedAnswer = currentState.selectedAnswer + answer
        _state.value = currentState.copy(selectedAnswer = selectedAnswer)
        if (currentState.answer.indexOf(answer) == currentState.correctAnswer - 1) {
            val counterAnswer = currentState.counterAnswer + 1
            _state.value = currentState.copy(isSelected = true, counterAnswer = counterAnswer)
        }
    }

    fun updateState(number: Int) {
        if (10 - number != currentState.counter) {
            _state.value = currentState.copy(
                question = Questions.questions[number],
                answer = Questions.answers[number],
                correctAnswer = Questions.correctAnswer[number],
                isSelected = false
            )
        } else _state.value = currentState
    }
}

data class PlayState(
    val question: String = "",
    val answer: List<String> = listOf(),
    val correctAnswer: Int = 0,
    val counter: Int = 0,
    val selectedAnswer: List<String> = listOf(),
    val isSelected: Boolean = false,
    val counterAnswer: Int = 0
)