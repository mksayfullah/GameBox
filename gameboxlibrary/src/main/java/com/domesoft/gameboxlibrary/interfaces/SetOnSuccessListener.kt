package com.domesoft.gameboxlibrary.interfaces

import com.domesoft.gameboxlibrary.quizer.Quiz

interface SetOnSuccessListener {
    fun onSuccess(currentQuestion: Quiz)
}