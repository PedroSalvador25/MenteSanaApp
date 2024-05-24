package com.orangecode.mentesana.data.home


sealed class HomeUIEvent {

    data class FeelingButtonBoxClicked(val feeling: Int): HomeUIEvent()
}