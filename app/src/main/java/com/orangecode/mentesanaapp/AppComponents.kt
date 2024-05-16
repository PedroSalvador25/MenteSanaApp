package com.orangecode.mentesanaapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.orangecode.mentesanaapp.ui.theme.CyanPrimary
import com.orangecode.mentesanaapp.ui.theme.CyanSecondary
import com.orangecode.mentesanaapp.ui.theme.WhiteCyan
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 0.dp)
            .border(color = CyanSecondary, width = 0.dp, shape = RoundedCornerShape(25.dp)),
        label = {Text(text = labelValue)},
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = CyanPrimary,
            focusedLabelColor = CyanPrimary,
            cursorColor = WhiteCyan,
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource,
                contentDescription = "user icon",
                modifier = Modifier.size(25.dp),
                tint = CyanPrimary)
        }
    )
}