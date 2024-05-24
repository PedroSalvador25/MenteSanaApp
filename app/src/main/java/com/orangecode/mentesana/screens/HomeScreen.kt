package com.orangecode.mentesana.screens

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.ui.theme.CyanPrimary
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.ListFeelings
import com.orangecode.mentesana.components.OptionSection
import com.orangecode.mentesana.data.home.*
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.GrayCyan
import kotlinx.coroutines.delay


@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val imageProfile = painterResource(id = R.drawable.defaultprofileimage)
    val TAG = Screen.HomeScreen::class.java.simpleName
    val n: MutableState<Int> = remember { mutableStateOf(0) }
    val visible: MutableState<Boolean> = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        ConstraintLayout {
            val (topImg, profile) = createRefs()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(
                        brush = Brush.verticalGradient(listOf(CyanPrimary, GrayCyan)),
                        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                    )
            )
            Row(
                modifier = Modifier
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hola",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Bienvenido",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(
                        text = "¿Cómo estás hoy?",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 55.dp)
                    )
                }
                Image(painter = imageProfile,
                    contentDescription = "profileImage",
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clickable { }
                        .clip(CircleShape)
                        .border(shape = CircleShape, width = 3.dp, color = Color.White)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 34.dp, end = 34.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

                //val stringFeelings = listOf("Feliz", "Triste", "Enojado", "Nervioso")
                val painter1 = painterResource(id = R.drawable.facehappy)
                val painter2 = painterResource(id = R.drawable.facesadness)
                val painter3 = painterResource(id = R.drawable.faceangry)
                val painter4 = painterResource(id = R.drawable.facenervous)


                ListFeelings(feelings = listOf(painter1, painter2, painter3, painter4), n, visible)
                Log.d(TAG, "HomeScreen: ${n}")
            }
        }
        val transitionSpec: ContentTransform = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(300)
        )with slideOutHorizontally(
            targetOffsetX = { -it },
            animationSpec = tween(300)
        )

        AnimatedContent(visible.value, transitionSpec = { transitionSpec }){
            if (it) {
                OptionSection(n)
            }
            if (!it) {
                OptionSection(n)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}