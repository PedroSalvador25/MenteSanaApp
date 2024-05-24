package com.orangecode.mentesana.data.login


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ComponentActivity
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.orangecode.mentesana.data.rules.Validator
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen

class LoginViewModel : ViewModel() {

    private val TAG = LoginViewModel::class.java.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent, context: Context){
        when(event){
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
                printState()
            }
            is LoginUIEvent.ForgotPasswordClicked -> {
                forgotPassword()
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login(context)
            }
        }
        validateDataWithRules()
    }

    private fun forgotPassword() {
        TODO("Not yet implemented")
    }

    private fun login(context: Context) {
        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    loginInProgress.value = false
                    Log.d(TAG, "Login Successful")
                    MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
                    Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Log.d(TAG, "Login Failed")
                Toast.makeText(context, "Inicio de sesión fallido, verifique el correo electronico o la contraseña", Toast.LENGTH_SHORT).show()
                loginInProgress.value = false
            }
    }

    fun logout(){

        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if(it.currentUser == null){
                Log.d(TAG, "User is signed out")
                MenteSanaAppRouter.navigateTo(Screen.LoginScreen)
            }else{
                Log.d(TAG, "User is signed in")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }

    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )


        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )

        allValidationsPassed.value = emailResult.status
                && passwordResult.status

    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, loginUIState.value.toString())
    }



}

