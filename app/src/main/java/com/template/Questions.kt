package com.template

object Questions {
    val questions: List<Question> =
        listOf(
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 1", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true)
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 2", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 3", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 4", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 5", answers = listOf(
                    Answer(id = 1, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 6", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true)
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 7", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 8", answers = listOf(
                    Answer(id = 1, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 9", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true),
                    Answer(id = 4, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ")
                )
            ),
            Question(
                text = "ЗАМЕНИТЬ_ВОПРОС_N 10", answers = listOf(
                    Answer(id = 1, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 2, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 3, title = "НЕПРАВИЛЬНЫЙ_ОТВЕТ"),
                    Answer(id = 4, title = "ПРАВИЛЬНЫЙ_ОТВЕТ", true)
                )
            ),
        )
    }

data class Answer(
    val id: Int,
    val title: String,
    val isCorrect: Boolean = false
)

data class Question(
    val text: String,
    val answers: List<Answer>
)