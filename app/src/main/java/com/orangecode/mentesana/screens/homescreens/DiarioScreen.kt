package com.orangecode.mentesana.screens.homescreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orangecode.mentesana.components.HeadingTextComponent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orangecode.mentesana.R
import com.orangecode.mentesana.components.NormalTextComponent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.DarkCyan
import com.orangecode.mentesana.ui.theme.GrayCyan
import com.orangecode.mentesana.ui.theme.WhiteCyan
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun DiarioScreen(){
    Image(painter = painterResource(id = R.drawable.fondo1), contentDescription = "Fondo")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
            Diary()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Diary() {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeadingTextComponent(value = "Diario")
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.diary),
                contentDescription = "diary icon",
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 16.dp, bottom = 16.dp)
            )
            Column {
                Text(text = "Cuentanos como va tu dia!", modifier = Modifier.padding(top = 30.dp))
                val currentDate = LocalDate.now()
                val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
                Text(text = "Fecha:")
                Text(text = formattedDate)
            }

        }
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = GrayCyan,
                disabledTextColor = CyanSecondary,
                focusedBorderColor = CyanPrimary,
                focusedLabelColor = DarkCyan,
                cursorColor = WhiteCyan
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = GrayCyan,
                disabledTextColor = CyanSecondary,
                focusedBorderColor = CyanPrimary,
                focusedLabelColor = DarkCyan,
                cursorColor = WhiteCyan
            ),
            value = content,
            onValueChange = { content = it },
            label = { Text("Contenido") },
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle the 'Done' event, e.g., hide the keyboard */ }
            ),
            singleLine = false,
            maxLines = Int.MAX_VALUE
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle save logic here */ },
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = GrayCyan, contentColor = Color.White)
        ) {
            Text(text = "Guardar")
        }
    }
    SystemBackButtonHandler {
        MenteSanaAppRouter.navigateTo(Screen.HomeScreen)
    }
}


@Preview
@Composable
fun DiarioScreenPreview(){
    DiarioScreen()
}