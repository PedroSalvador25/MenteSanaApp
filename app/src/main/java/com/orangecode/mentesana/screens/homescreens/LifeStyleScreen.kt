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
import androidx.compose.ui.text.style.TextAlign
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
fun LifeStyleScreen(){
    Image(painter = painterResource(id = R.drawable.fondo1), contentDescription = "Fondo")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
            Column{
                HeadingTextComponent(value = "Estilo De Vida")
                MenuLifeStyle()
                FunFactLifeStyle()
            }
        }
        SystemBackButtonHandler {
            MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
        }
    }

}

@Composable
fun FunFactLifeStyle(){
    Column(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = Brush.verticalGradient(listOf(CyanPrimary, DarkCyan)))
            .padding(vertical = 25.dp)
            .fillMaxWidth()
    ) {
        Text("¿Sabías que…?", modifier = Modifier.padding(start = 10.dp,bottom = 10.dp), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Tener buenos hábitos puede ayudar significativamente a manejar problemas como la depresión y la ansiedad..",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp), color = Color.White, fontStyle = FontStyle.Italic)
    }
}


@Composable
fun MenuLifeStyle(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = Brush.verticalGradient(listOf(Color.White, CyanPrimary, CyanSecondary, DarkCyan)))
            .padding(vertical = 50.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.lifestyle), contentDescription = "MeditationImage")
        val painter1 = painterResource(id = R.drawable.sleephour)
        val painter2 = painterResource(id = R.drawable.equfood)
        val painter3 = painterResource(id = R.drawable.managetime)
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Lleva un Mejor Control de Vida con Nosotros", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Puedes Configurar Estas Opciones", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        TypesLifeStyle(feelings = listOf(painter1, painter2, painter3), listOf("Horario\n  de\nSueño","  Balance\nDe\nComida" ,"Gestion\nde\nTiempo"))
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun TypesLifeStyle(
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
                    .padding(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = feelings[it],
                        contentDescription = "Feeling",
                        modifier = Modifier.size(40.dp),
                    )
                    Text(
                        text = texto[it],
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LifeStyleScreenPreview(){
    LifeStyleScreen()
}