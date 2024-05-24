package com.orangecode.mentesana.screens.homescreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.ButtonComponent
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.DarkCyan
import com.orangecode.mentesana.ui.theme.GrayCyan

@Composable
fun HelpLineScreen() {
    Image(painter = painterResource(id = R.drawable.fondo1), contentDescription = "Fondo")
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var isVisible by remember { mutableStateOf(false) }

        // Trigger the animation as soon as the screen is displayed
        LaunchedEffect(Unit) {
            isVisible = true
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                HeadingTextComponent(value = "Linea de Ayuda")
                MenuHelpLine()
            }
            SystemBackButtonHandler {
                MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
            }
        }
    }
}

@Composable
fun MenuHelpLine(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.White,
                        CyanPrimary,
                        CyanSecondary,
                        DarkCyan
                    )
                )
            )
            .padding(vertical = 50.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.helpline), contentDescription = "MeditationImage")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Si te sientes estresado/a, triste o con alguna alteración emocional, no debes esperar a que el problema avance, puedes recibir apoyo emocional u orientación en la Línea de la Vida", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush = Brush.verticalGradient(listOf(CyanPrimary, GrayCyan)))
                .padding(vertical = 25.dp)
                .fillMaxWidth()
        ) {
            Text("Orientación en la Línea de la Vida al 800 911 2000",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.Black, fontStyle = FontStyle.Italic)
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush = Brush.verticalGradient(listOf(CyanPrimary, GrayCyan)))
                .padding(vertical = 25.dp)
                .fillMaxWidth()
        ) {
            Text("Instituto Nacional de Salud Mental (NIMH) puedes comunicarte al número 866-615-6464",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.Black, fontStyle = FontStyle.Italic)
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush = Brush.verticalGradient(listOf(CyanPrimary, GrayCyan)))
                .padding(vertical = 25.dp)
                .fillMaxWidth()
        ) {
            Text("Alianza Nacional Sobre Enfermedades Mentales (NAMI):\n" +
                    "Puedes llamar al 800-950-6264.",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.Black, fontStyle = FontStyle.Italic)
        }
        Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)){
            ButtonComponent(
                value = "Chat con Profesional",
                onButtonClicked = {},
                isEnabled = true
            )
        }
    }
}


@Preview
@Composable
fun HelpLineScreenPreview(){
    HelpLineScreen()
}