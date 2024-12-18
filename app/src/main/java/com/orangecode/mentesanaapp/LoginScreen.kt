package com.orangecode.mentesanaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreen(){
    Image(painter = painterResource(id = R.drawable.fondo), contentDescription = "Fondo")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = "Login Imagen",
            modifier = Modifier.size(200.dp)
        )

        Text(text = "Bienvenido", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Inicia Sesion para Continuar")

        MyTextField(
            labelValue = "Usuario",
            painterResource(id = R.drawable.usericon)
        )

        Spacer(modifier = Modifier.height(16.dp))

        MyTextField(
            labelValue = "Password",
            painterResource = painterResource(id = R.drawable.emailicon)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.size(height = 50.dp, width = 250.dp)) {
            Text(text = "Inicio", fontSize = 20.sp)

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 90.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Olvidaste la password?")
            Text(text = "Registrate", modifier = Modifier.clickable {  })
        }

    }


}

