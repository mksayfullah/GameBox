package com.domesoft.gameboxlibrary.quizer

data class GameReport(
    val question: Any? = null,
    val userSelection: Any? = null,
    val correctAnswer: Any? = null,
    val score: Long? = 0
)
