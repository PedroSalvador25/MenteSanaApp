package com.orangecode.mentesana.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orangecode.mentesana.data.home.Option
import com.orangecode.mentesana.data.home.comunidad
import com.orangecode.mentesana.data.home.diario
import com.orangecode.mentesana.data.home.estiloVida
import com.orangecode.mentesana.data.home.lineaAyuda
import com.orangecode.mentesana.data.home.meditacion
import com.orangecode.mentesana.data.home.respiracion
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.starndardQuadFromTo
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.DarkCyan
import com.orangecode.mentesana.ui.theme.GrayCyan

@Composable
fun ListFeelings(
    feelings: List<Painter>,
    index: MutableState<Int> = remember { mutableStateOf(0) },
    visible: MutableState<Boolean> = remember { mutableStateOf(true) }
) {
    var selectedFeeling by remember {mutableStateOf(0)}
    LazyRow {
        items(feelings.size) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        selectedFeeling = it
                        index.value = it
                        visible.value = !visible.value
                    }
                    .clip(RoundedCornerShape(25.dp))
                    .background(
                        if (selectedFeeling == it) {
                            CyanPrimary
                        } else {
                            GrayCyan
                        }
                    )
                    .padding(15.dp)
            ) {
                Image(
                    painter = feelings[it],
                    contentDescription = "Feeling",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
fun OptionSection(n: MutableState<Int> = remember { mutableStateOf(0) }){

    var optiones : List<Option> = listOf()
    var texto = ""
    when(n.value) {
        0 -> {
            optiones = listOf(diario, comunidad, meditacion, estiloVida, respiracion, lineaAyuda)
            texto = "¡Excelente nos alegramos de que estes feliz!"
        }
        1 -> {
            optiones = listOf(lineaAyuda, meditacion, respiracion, estiloVida, diario, comunidad)
            texto = "No te preocupes estamos aquí para ayudarte"
        }
        2 -> {
            optiones = listOf(respiracion, meditacion, lineaAyuda, estiloVida, diario, comunidad)
            texto = "Date un respiro con nuestra ayuda"
        }
        3 -> {
            optiones = listOf(respiracion, lineaAyuda, meditacion, estiloVida, diario, comunidad)
            texto = "Relajate con nuestra ayuda"
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = texto,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp, top = 15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(optiones.size) {
                OptionItem(optiones[it])
            }
        }
    }
}


@Composable
fun OptionItem(
    option: Option,
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(25.dp))
            .aspectRatio(1f)
            .background(GrayCyan)
    ){
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColorPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            starndardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            starndardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            starndardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            starndardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            starndardQuadFromTo(lightPoint1, lightPoint2)
            starndardQuadFromTo(lightPoint2, lightPoint3)
            starndardQuadFromTo(lightPoint3, lightPoint4)
            starndardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(modifier = Modifier
            .fillMaxSize()
        ) {
            drawPath(
                path = mediumColorPath,
                color = option.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = option.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Text(
                text = option.title,
                lineHeight = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 8.dp)
            )
            Text(
                text = option.description,
                lineHeight = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 35.dp)
            )
            Icon(
                painter = painterResource(id = option.iconId),
                contentDescription = option.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(75.dp)
            )
            Text(text = "Start",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { MenteSanaAppRouter.navigateTo(option.screen)  }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(DarkCyan)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}