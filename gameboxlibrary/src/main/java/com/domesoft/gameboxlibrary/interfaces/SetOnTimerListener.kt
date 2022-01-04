package com.domesoft.gameboxlibrary.interfaces

interface SetOnTimerListener {
    fun onCountDown(time: String, timesInMillis: Long)
    fun onFinish()
}