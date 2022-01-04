package com.domesoft.gameboxlibrary.games.quickquiz

import android.content.Context
import com.domesoft.gameboxlibrary.interfaces.SetOnTimerListener
import com.domesoft.gameboxlibrary.quizer.Quizer
import com.domesoft.gameboxlibrary.util.Timer

class QuickQuiz(private val context: Context) : Quizer(context) {

    private lateinit var onTimerListener: SetOnTimerListener
    private var instantTime = false
    private lateinit var timer: Timer




    fun setTime(second: Long): QuickQuiz{
        timer = Timer()
        timer.setTime(second = second)
        return this
    }
    fun setTime(minute: Long,second: Long): QuickQuiz{
        timer = Timer()
        timer.setTime(minute = minute, second = second)
        return this
    }
    fun setTime(hour: Long, minute: Long,second: Long): QuickQuiz{
        timer = Timer()
        timer.setTime(hour= hour, minute = minute, second = second)
        return this
    }

    fun getInstantTime(onTimerListener: SetOnTimerListener): QuickQuiz {
        this.onTimerListener = onTimerListener
        instantTime = true
        getTime()
        return this
    }

    private fun getTime(){
        timer.getTime(object : SetOnTimerListener{
            override fun onCountDown(time: String, timesInMillis: Long) {
                onTimerListener.onCountDown(time, timesInMillis)
            }

            override fun onFinish() {
                onTimerListener.onFinish()
            }

        })
    }

    fun pauseQuiz(): QuickQuiz{
        timer.pauseTimer()
        return this
    }

    fun resumeQuiz(): QuickQuiz{
        timer.resumeTimer()
        return this
    }

    fun resetTimer(): QuickQuiz {
        timer.resetTimer()
        return this
    }

    override fun build() {
        super.build()
        timer.startTimer()
    }
}