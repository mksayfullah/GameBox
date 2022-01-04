package com.domesoft.gameboxlibrary.interfaces

import com.domesoft.gameboxlibrary.quizer.GameReport

interface SetOnFinishedListener {
    fun onFinished()
    fun finalScore(finalScore: Long)
    fun gameReport(gameReport: List<GameReport>)
}