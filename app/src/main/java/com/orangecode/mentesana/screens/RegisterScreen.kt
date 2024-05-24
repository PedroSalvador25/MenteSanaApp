package com.orangecode.mentesana.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.orangecode.mentesana.components.ButtonComponent
import com.orangecode.mentesana.components.CheckboxComponent
import com.orangecode.mentesana.components.MyTextField
import com.orangecode.mentesana.components.PasswordTextField
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.ClickableLoginComponent
import com.orangecode.mentesana.components.DividerTextComponent
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.components.NormalTextComponent
import com.orangecode.mentesana.data.registration.RegisterViewModel
import com.orangecode.mentesana.data.registration.RegisterUIEvent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.CyanPrimary

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()){

    val context = LocalContext.current
    Image(painter = painterResource(id = R.drawable.fondo1), contentDescription = "Fondo")
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "Login Imagen",
                modifier = Modifier.size(150.dp)
            )

            HeadingTextComponent(value = "Bienvenido")

            NormalTextComponent(value = "Registrate para continuar")

            MyTextField(
                labelValue = "Usuario",
                painterResource(id = R.drawable.usericon),
                onTextSelected = {
                    registerViewModel.onEvent(RegisterUIEvent.UserNameChanged(it), context)
                },
                errorStatus = registerViewModel.registerUIState.value.userNameError,
                errorMessage = "El nombre de usuario debe tener al menos 6 caracteres"
            )

            Spacer(modifier = Modifier.height(6.dp))

            MyTextField(
                labelValue = "Email",
                painterResource = painterResource(id = R.drawable.emailicon),
                onTextSelected = {
                    registerViewModel.onEvent(RegisterUIEvent.EmailChanged(it), context)
                },
                errorStatus = registerViewModel.registerUIState.value.emailError,
                errorMessage = "Ingrese un Email valido"
            )

            Spacer(modifier = Modifier.height(6.dp))

            PasswordTextField(
                labelValue = "Contraseña",
                painterResource(id = R.drawable.passwicon),
                onTextSelected = {
                    registerViewModel.onEvent(RegisterUIEvent.PasswordChanged(it), context)
                },
                errorStatus = registerViewModel.registerUIState.value.passwordError,
                errorMessage = "La contraseña debe tener al menos 6 caracteres"
            )

            CheckboxComponent("", onTextSelected = {
                MenteSanaAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
            },
                onCheckedChange = {registerViewModel.onEvent(RegisterUIEvent.PrivacyPolicyCheckBoxClicked(it), context)}
            )

            ButtonComponent(value = "Registrarse",
                onButtonClicked = {
                    registerViewModel.onEvent(RegisterUIEvent.RegisterButtonClicked, context)
                },
                isEnabled = registerViewModel.allValidationsPassed.value
            )

            Spacer(modifier = Modifier.height(4.dp))
            DividerTextComponent()

            ClickableLoginComponent(tryingToLogin = true, onTextSelected = {
                MenteSanaAppRouter.navigateTo(Screen.LoginScreen)
            })

            SystemBackButtonHandler {
                MenteSanaAppRouter.navigateTo(Screen.LoginScreen)
            }

        }

        if(registerViewModel.signUpInProgress.value){
            CircularProgressIndicator(color = CyanPrimary)
        }

    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}

