package com.orangecode.mentesana.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.components.LargeTextComponent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler

@Composable
fun ForgotPasswordScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Encuentra tu cuenta de Menta Sana")
        }
    }

    SystemBackButtonHandler {
        MenteSanaAppRouter.navigateTo(Screen.LoginScreen)
    }

}

@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}