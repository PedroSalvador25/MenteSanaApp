package com.orangecode.mentesana.navigation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

sealed class Screen{

    object LoginScreen : Screen()
    object RegisterScreen : Screen()
    object TermsAndConditionsScreen : Screen()
    object ForgotPasswordScreen : Screen()
    object HomeScreen : Screen()
    object BreathScreen : Screen()
    object ComunityScreen : Screen()
    object DiarioScreen : Screen()
    object HelpLineScreen : Screen()
    object LifeStyleScreen : Screen()
    object MeditationScreen : Screen()

}

object MenteSanaAppRouter {

    val currentScreen : MutableState<Screen> = mutableStateOf(userLog())

    private fun userLog(): Screen {
        val user = Firebase.auth.currentUser
        if (user != null) {
            Log.d("MenteSana", "User is signed in")
            return Screen.HomeScreen
        } else {
            Log.d("MenteSana", "User is not signed in")
            return Screen.LoginScreen
        }

    }

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }

}
