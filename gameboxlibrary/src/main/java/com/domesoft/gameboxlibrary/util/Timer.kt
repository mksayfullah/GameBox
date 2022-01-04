package com.domesoft.gameboxlibrary.util

import android.os.CountDownTimer
import com.domesoft.gameboxlibrary.interfaces.SetOnTimerListener
import java.util.*

class Timer() {

    private lateinit var timer: CountDownTimer
    private var hour: Long = 0
    private var minute: Long = 0
    private var second: Long = 0
    private var startTimeInMillis: Long = 0
    private var timeLeftInMillis: Long = 0
    private var endTime: Long = 0
    private var isTimeRunning: Boolean = false

    //private lateinit var formattedTime: String
    private lateinit var onTimerListener: SetOnTimerListener
    private var isListenerSet: Boolean = false


    fun setTime(hour: Long? = 0, minute: Long? = 0,second: Long? = 0){
        if (second != null) {
            this.second = second
        }
        if (minute != null) {
            this.minute = minute
        }
        if (hour != null) {
            this.hour = hour
        }
        encodeTime()
    }



    private fun encodeTime(){
        if (hour> 0){
            startTimeInMillis += (hour * 3600 * 1000)
        }

        if (minute> 0){
            startTimeInMillis += (minute * 60 * 1000)
        }

        if (second> 0){
            startTimeInMillis += (second * 1000)
        }
        timeLeftInMillis = startTimeInMillis

    }

    private fun decodeTime(): String{

        val hours: Int = ((timeLeftInMillis/1000) / 3600).toInt()
        val minutes: Int = (((timeLeftInMillis/1000) % 3600)/60).toInt()
        val seconds: Int = ((timeLeftInMillis/1000) % 60).toInt()
        val formattedText: String = if (hours > 0){
            String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, seconds)
        } else{
            String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds)
        }
       return formattedText
    }


    fun startTimer(){
        startTimer(timeLeftInMillis)
    }

    private fun startTimer(time: Long){

        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(instantTime: Long) {
                timeLeftInMillis = instantTime
                if (isListenerSet && isTimeRunning){
                    onTimerListener.onCountDown(decodeTime(), timeLeftInMillis)
                }

            }

            override fun onFinish() {
                onTimerListener.onFinish()
                isTimeRunning = false
            }
        }.start()

        isTimeRunning = true
    }

    fun getTime(onTimerListener: SetOnTimerListener){
        this.onTimerListener = onTimerListener
        isListenerSet = true
    }

    fun pauseTimer(){
        isTimeRunning = false
        timer.cancel()
    }

    fun resumeTimer(){
        startTimer()
    }

    fun resetTimer(){
        timeLeftInMillis = startTimeInMillis
        timer.cancel()
        onTimerListener.onCountDown(decodeTime(), timeLeftInMillis)
    }


}