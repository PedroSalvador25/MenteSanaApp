package com.orangecode.mentesana.data.registration

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import com.orangecode.mentesana.RegisterFlowApp
import com.orangecode.mentesana.data.rules.Validator
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen

class RegisterViewModel : ViewModel() {

    private val TAG = RegisterViewModel::class.java.simpleName

    var registerUIState = mutableStateOf(RegisterUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: RegisterUIEvent, context: Context){
        when(event){
            is RegisterUIEvent.UserNameChanged -> {
                registerUIState.value = registerUIState.value.copy(
                    userName = event.userName
                )
                printState()
            }
            is RegisterUIEvent.EmailChanged -> {
                registerUIState.value = registerUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is RegisterUIEvent.PasswordChanged -> {
                registerUIState.value = registerUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is RegisterUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registerUIState.value = registerUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }

            is RegisterUIEvent.RegisterButtonClicked -> {
                signUp(context)
            }
        }
        validateDataWithRules()
    }

    private fun signUp(context: Context) {
        Log.d(TAG, "Inside_signUp")
        printState()
        createUserInFirebase(
            email = registerUIState.value.email,
            password= registerUIState.value.password,
            context
        )
    }

    private fun createUserInFirestore(userName:String, email:String, password:String) {
        val db = Firebase.firestore

        val user = hashMapOf(
            "userName" to userName,
            "email" to email,
            "password" to password
        )

        db.collection("users")
            .document(email).set(user)
            .addOnSuccessListener {
                Log.d(TAG, "DocumentSnapshot successfully added")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    private fun createUserInFirebase(email:String, password:String, context: Context){
        signUpInProgress.value = true

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, " isSuccesful = ${it.isSuccessful}")
                signUpInProgress.value = false
                if(it.isSuccessful){
                    Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    createUserInFirestore(
                        userName = registerUIState.value.userName,
                        email = registerUIState.value.email,
                        password = registerUIState.value.password
                    )
                    MenteSanaAppRouter.navigateTo(Screen.LoginScreen)
                }
            }
            .addOnFailureListener{
                Toast.makeText(context, "Registro fallido", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, " Exception = ${it.message}")
                Log.w(TAG, "Exception = ${it.localizedMessage}")
            }
    }

    private fun validateDataWithRules() {
        val uNameResult = Validator.validateUserName(
            uName = registerUIState.value.userName
        )

        val emailResult = Validator.validateEmail(
            email = registerUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = registerUIState.value.password
        )

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registerUIState.value.privacyPolicyAccepted
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "uNameResult = $uNameResult")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")
        Log.d(TAG, "privacyPolicyResult = $privacyPolicyResult")

        registerUIState.value = registerUIState.value.copy(
            userNameError = uNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        allValidationsPassed.value = uNameResult.status && emailResult.status
                && passwordResult.status && privacyPolicyResult.status

    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registerUIState.value.toString())
    }
}