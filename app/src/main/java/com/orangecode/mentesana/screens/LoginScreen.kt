package com.orangecode.mentesana.screens

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.orangecode.mentesana.components.ButtonComponent
import com.orangecode.mentesana.components.ButtonComponentSmall
import com.orangecode.mentesana.components.MyTextField
import com.orangecode.mentesana.components.PasswordTextField
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.ClickableLoginComponent
import com.orangecode.mentesana.components.DividerTextComponent
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.components.NormalTextComponent
import com.orangecode.mentesana.data.login.LoginUIEvent
import com.orangecode.mentesana.data.registration.RegisterViewModel
import com.orangecode.mentesana.data.login.LoginViewModel
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.ui.theme.CyanPrimary

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){

    val context = LocalContext.current
    Image(painter = painterResource(id = R.drawable.fondo1), contentDescription = "Fondo")
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "Login Imagen",
                modifier = Modifier.size(200.dp)
            )

            HeadingTextComponent(value = "Bienvenido")

            NormalTextComponent(value = "Inicia Sesion para continuar")

            MyTextField(
                labelValue = "Email",
                painterResource(id = R.drawable.emailicon),
                onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.EmailChanged(it), context)
                },
                errorStatus = loginViewModel.loginUIState.value.emailError
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                labelValue = "Contraseña",
                painterResource(id = R.drawable.passwicon),
                onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it), context)
                },
                errorStatus = loginViewModel.loginUIState.value.passwordError
            )

            Spacer(modifier = Modifier.height(12.dp))

            ButtonComponent(value = "Inicio", onButtonClicked = {
                loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked, context)
            },
                isEnabled = true)

            Spacer(modifier = Modifier.height(12.dp))

            ButtonComponentSmall(value = "¿Olvidaste tu contraseña?", onButtonClicked = {
                MenteSanaAppRouter.navigateTo(com.orangecode.mentesana.navigation.Screen.ForgotPasswordScreen)
            })

            Spacer(modifier = Modifier.height(8.dp))

            DividerTextComponent()

            ClickableLoginComponent(tryingToLogin = false, onTextSelected = {
                MenteSanaAppRouter.navigateTo(com.orangecode.mentesana.navigation.Screen.RegisterScreen)
            })


        }

        if(loginViewModel.loginInProgress.value){
            CircularProgressIndicator(color = CyanPrimary)
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen(){
    LoginScreen()
}