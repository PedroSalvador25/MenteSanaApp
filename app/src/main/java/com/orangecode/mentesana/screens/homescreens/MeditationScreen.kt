package com.orangecode.mentesana.screens.homescreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.ButtonComponent
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.components.NormalTextComponent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.DarkCyan
import com.orangecode.mentesana.ui.theme.GrayCyan

@Composable
fun MeditationScreen(){
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
            Column(
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HeadingTextComponent(value = "Meditacion")
                MenuMeditation()
                FunFact()
            }
        }
        SystemBackButtonHandler {
            MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
        }
    }

}

@Composable
fun FunFact(){
    Column(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = Brush.verticalGradient(listOf(CyanPrimary, DarkCyan)))
            .padding(vertical = 25.dp)
            .fillMaxWidth()
    ) {
        Text("¿Sabías que…?", modifier = Modifier.padding(start = 10.dp,bottom = 10.dp), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Se ha comprobado como la práctica de la meditación continua ayuda a reducir los niveles de estrés y los efectos de la depresión.",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.White, fontStyle = FontStyle.Italic)
    }
}


@Composable
fun MenuMeditation(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = Brush.verticalGradient(listOf(Color.White, CyanPrimary, CyanSecondary, DarkCyan)))
            .padding(vertical = 50.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.meditation), contentDescription = "MeditationImage")
        CurrentMeditation()
        val painter1 = painterResource(id = R.drawable.guide)
        val painter2 = painterResource(id = R.drawable.mantramed)
        val painter3 = painterResource(id = R.drawable.quigong)
        Text(text = "Selecciona un tipo de Meditacion", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        TypesMeditation(feelings = listOf(painter1, painter2, painter3), listOf("Guiada", "Mantra", "QiGong"))
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.padding(10.dp)){
            ButtonComponent(value = "Comenzar", onButtonClicked = { /*TODO*/ }, isEnabled = true)
        }
    }
}
@Composable
fun CurrentMeditation(
    color: Color = GrayCyan
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(text = "Pensamiento Diario",
                style = MaterialTheme.typography.bodyMedium)
            Text(text = "Meditacion 3 - 10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(CyanSecondary)
                .padding(10.dp)
                .clickable {  }
        ){
            Icon(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun TypesMeditation(
    feelings: List<Painter>,
    texto: List<String>,
    index: MutableState<Int> = remember { mutableStateOf(0) }
) {
    var selectedFeeling by remember { mutableStateOf(0) }
    LazyRow {
        items(feelings.size) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        selectedFeeling = it
                        index.value = it
                    }
                    .clip(RoundedCornerShape(25.dp))
                    .background(
                        if (selectedFeeling == it) {
                            CyanPrimary
                        } else {
                            GrayCyan
                        }
                    )
                    .padding(25.dp)
            ) {
                Column {
                    Image(
                        painter = feelings[it],
                        contentDescription = "Feeling",
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text = texto[it],
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MeditationScreenPreview(){
    MeditationScreen()
}