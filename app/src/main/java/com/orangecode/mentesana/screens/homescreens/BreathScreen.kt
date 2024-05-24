package com.orangecode.mentesana.screens.homescreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.DarkCyan
import com.orangecode.mentesana.ui.theme.GrayCyan

@Composable
fun BreathScreen(){
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingTextComponent(value = "Respiracion")
                    MenuBreath()
                    FunFactBreath()
                }
            }
        }
        SystemBackButtonHandler {
            MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
        }
    }
}

@Composable
fun MenuBreath(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
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
        Spacer(modifier = Modifier.height(25.dp))
        Image(painter = painterResource(id = R.drawable.breath), contentDescription = "MeditationImage")
        Spacer(modifier = Modifier.height(25.dp))
        val painter1 = painterResource(id = R.drawable.guide)
        val painter2 = painterResource(id = R.drawable.respiracionalterna)
        Text(text = "Selecciona un tipo de Respiracion", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        TypesBreath(feelings = listOf(painter1, painter2), listOf("Guiada", "Alterna"))
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.padding(10.dp)){
            ButtonComponent(value = "Comenzar", onButtonClicked = { /*TODO*/ }, isEnabled = true)
        }
    }
}

@Composable
fun TypesBreath(
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
                    Icon(
                        painter = feelings[it],
                        contentDescription = "Feeling",
                        tint = Color.White,
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

@Composable
fun FunFactBreath(){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = Brush.verticalGradient(listOf(CyanPrimary, DarkCyan)))
            .padding(vertical = 25.dp)
            .fillMaxWidth()
    ) {
        Text("¿Sabías que…?", modifier = Modifier.padding(start = 10.dp,bottom = 10.dp), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Curiosamente, los científicos están descubriendo que una frecuencia particular de respiración, alrededor de seis exhalaciones por minuto, puede ser especialmente reconstituyente, desencadenando una \"respuesta de relajación\" en el cerebro y el cuerpo..",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.White, fontStyle = FontStyle.Italic)
    }
}

@Preview
@Composable
fun BreathScreenPreview(){
    BreathScreen()
}