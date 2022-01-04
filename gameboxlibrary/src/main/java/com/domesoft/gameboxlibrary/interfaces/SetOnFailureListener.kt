package com.domesoft.gameboxlibrary.interfaces

import com.domesoft.gameboxlibrary.quizer.Quiz

interface SetOnFailureListener {
    fun onFailure(currentQuestion: Quiz)
}