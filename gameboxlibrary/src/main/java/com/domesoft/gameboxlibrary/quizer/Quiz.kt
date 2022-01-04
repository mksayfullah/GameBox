package com.domesoft.gameboxlibrary.quizer

data class Quiz(
    val question: Any,
    val option1: Any,
    val option2: Any,
    val option3: Any? = null,
    val option4: Any? = null,
    val option5: Any? = null,
    val answer: Any
)
