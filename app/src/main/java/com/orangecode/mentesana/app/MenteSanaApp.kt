package com.orangecode.mentesana.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.screens.homescreens.DiarioScreen
import com.orangecode.mentesana.screens.ForgotPasswordScreen
import com.orangecode.mentesana.screens.HomeScreen
import com.orangecode.mentesana.screens.LoginScreen
import com.orangecode.mentesana.screens.RegisterScreen
import com.orangecode.mentesana.screens.TermsAndConditionsScreen
import com.orangecode.mentesana.screens.homescreens.*

//@Preview
@Composable
fun MenteSanaApp(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = MenteSanaAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.RegisterScreen -> {
                    RegisterScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()
                }
                is Screen.ForgotPasswordScreen ->{
                    ForgotPasswordScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
                is Screen.DiarioScreen ->{
                    DiarioScreen()
                }
                is Screen.BreathScreen ->{
                    BreathScreen()
                }
                is Screen.ComunityScreen ->{
                    ComunityScreen()
                }
                is Screen.HelpLineScreen ->{
                    HelpLineScreen()
                }
                is Screen.LifeStyleScreen ->{
                    LifeStyleScreen()
                }
                is Screen.MeditationScreen ->{
                    MeditationScreen()
                }
            }

        }

    }

}