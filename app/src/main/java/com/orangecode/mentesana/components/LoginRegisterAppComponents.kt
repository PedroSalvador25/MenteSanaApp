package com.orangecode.mentesana.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.GrayCyan
import com.orangecode.mentesana.ui.theme.WhiteCyan
import android.content.Context
import android.widget.Toast

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), textAlign = TextAlign.Center
    )
}

@Composable
fun LargeTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 20.dp),
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = com.orangecode.mentesana.R.color.black),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true,
    errorMessage: String = ""
) {
    val textValue = remember { mutableStateOf("") }
    val hasInteracted = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = labelValue) },
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = GrayCyan,
                disabledTextColor = CyanSecondary,
                focusedBorderColor = CyanPrimary,
                focusedLabelColor = CyanPrimary,
                cursorColor = WhiteCyan,
                errorBorderColor = if (hasInteracted.value && !errorStatus) Color.Red else GrayCyan
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            maxLines = 1,
            value = textValue.value,
            onValueChange = {
                textValue.value = it
                onTextSelected(it)
                hasInteracted.value = true
            },
            leadingIcon = {
                Icon(
                    painter = painterResource,
                    contentDescription = "user icon",
                    modifier = Modifier.size(25.dp),
                    tint = CyanPrimary
                )
            },
            isError = hasInteracted.value && !errorStatus
        )
        if (hasInteracted.value && !errorStatus) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false,
    errorMessage: String = ""
) {
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val hasInteracted = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = labelValue) },
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = GrayCyan,
                disabledTextColor = CyanSecondary,
                focusedBorderColor = CyanPrimary,
                focusedLabelColor = CyanPrimary,
                cursorColor = WhiteCyan,
                errorBorderColor = if (hasInteracted.value && !errorStatus) Color.Red else GrayCyan
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            maxLines = 1,
            value = password.value,
            onValueChange = {
                password.value = it
                onTextSelected(it)
                hasInteracted.value = true
            },
            leadingIcon = {
                Icon(
                    painter = painterResource,
                    contentDescription = "password icon",
                    modifier = Modifier.size(25.dp),
                    tint = CyanPrimary
                )
            },
            trailingIcon = {
                val iconImage = if (passwordVisible.value) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }

                val description = if (passwordVisible.value) {
                    "Hide Password"
                } else {
                    "Show Password"
                }

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = iconImage, contentDescription = description)
                }
            },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = hasInteracted.value && !errorStatus
        )
        if (hasInteracted.value && !errorStatus) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        onClick = { onButtonClicked.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(CyanSecondary, CyanPrimary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ButtonComponentSmall(value: String, onButtonClicked: () -> Unit) {
    Button(
        onClick = { onButtonClicked.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 40.dp, vertical = 0.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(CyanSecondary, GrayCyan)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            colors = CheckboxDefaults.colors(
                checkedColor = CyanPrimary
            ),
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            })

        ClickableTextComponent(value = value, onTextSelected)
    }
}


@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "Al continuar aceptas nuestra "
    val privacyPolicyText = "Política de Privacidad"
    val andText = " así como "
    val termsAndConditionsText = "Términos y Condiciones"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = CyanPrimary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = CyanPrimary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span}}")

                if (span.item == termsAndConditionsText || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }

            }
    })
}

@Composable
fun ClickableLoginComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (tryingToLogin) "¿Ya tienes cuenta?" else "¿No tienes cuenta?"
    val loginText = if (tryingToLogin) " Inicia Sesion" else " Registrate"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = CyanPrimary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }

                }
        })
}


@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayCyan,
            thickness = 1.dp
        )

        Text(text = " o ", fontSize = 18.sp, color = Color.Black)

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayCyan,
            thickness = 1.dp
        )
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}



