package com.orangecode.mentesana.data.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel () {

    private val TAG = HomeViewModel::class.java.simpleName

    var homeUIState = mutableStateOf(HomeUIState())

    var optiones : List<Option> = listOf()

    fun onEvent(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.FeelingButtonBoxClicked -> {
                homeUIState.value = homeUIState.value.copy(
                    //userName = event.userName
                    feeling = event.feeling
                )
                printState()
            }
        }
    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, homeUIState.value.toString())
    }
}

