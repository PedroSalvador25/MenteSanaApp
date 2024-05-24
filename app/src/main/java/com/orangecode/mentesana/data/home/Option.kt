package com.orangecode.mentesana.data.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.orangecode.mentesana.navigation.Screen

data class Option(
    val title: String,
    @DrawableRes val iconId: Int,
    val description: String,
    val screen: Screen,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,

    )
