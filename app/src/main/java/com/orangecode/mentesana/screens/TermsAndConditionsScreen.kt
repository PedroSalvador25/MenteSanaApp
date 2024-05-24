package com.orangecode.mentesana.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orangecode.mentesana.components.HeadingTextComponent
import com.orangecode.mentesana.components.LargeTextComponent
import com.orangecode.mentesana.components.NormalTextComponent
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Aviso de Privacidad")
            LargeTextComponent(value = "" +
                    "\n" +
                    "Mente Sana opera la aplicación móvil Mente Sana. Esta página informa a los usuarios de nuestra política en cuanto a la recopilación, uso y divulgación de información personal si alguien decide utilizar nuestra Aplicación.\n" +
                    "\n" +
                    "Si decides utilizar nuestra Aplicación, aceptas la recopilación y el uso de información en relación con esta política. La información personal que recopilamos se utiliza para proporcionar y mejorar la Aplicación. No usaremos ni compartiremos tu información con nadie, excepto como se describe en esta Política de Privacidad.\n" +
                    "\n" +
                    "Recopilación y Uso de Información\n" +
                    "\n" +
                    "Para una mejor experiencia, al utilizar nuestra Aplicación, podemos requerir que nos proporciones cierta información de identificación personal, incluidos, entre otros, tu nombre, dirección de correo electrónico, número de teléfono y ubicación. La información que recopilamos se utilizará para contactarte o identificarte.\n" +
                    "\n" +
                    "La Aplicación utiliza servicios de terceros que pueden recopilar información utilizada para identificarte. Consulta la política de privacidad de estos servicios de terceros para obtener más información sobre cómo pueden procesar esta información.\n" +
                    "\n" +
                    "Seguridad\n" +
                    "\n" +
                    "Valoramos tu confianza al proporcionarnos tu información personal, por lo que nos esforzamos por utilizar medios comercialmente aceptables para protegerla. Sin embargo, recuerda que ninguna forma de transmisión por Internet o método de almacenamiento electrónico es 100% seguro y confiable, y no podemos garantizar su absoluta seguridad.\n" +
                    "\n" +
                    "Enlaces a Otros Sitios\n" +
                    "\n" +
                    "Esta Aplicación puede contener enlaces a otros sitios. Si haces clic en un enlace de un tercero, serás dirigido a ese sitio. Ten en cuenta que estos sitios externos no son operados por nosotros. Por lo tanto, te recomendamos encarecidamente que revises la política de privacidad de estos sitios web. No tenemos control ni asumimos responsabilidad alguna por el contenido, las políticas de privacidad o las prácticas de los sitios web o servicios de terceros.\n" +
                    "\n" +
                    "Cambios a Esta Política de Privacidad\n" +
                    "\n" +
                    "Podemos actualizar nuestra Política de Privacidad de vez en cuando. Por lo tanto, te recomendamos que revises esta página periódicamente para detectar cambios. Te notificaremos cualquier cambio publicando la nueva Política de Privacidad en esta página. Estos cambios son efectivos inmediatamente después de que se publiquen en esta página.\n" +
                    "\n" +
                    "Contacto\n" +
                    "\n" +
                    "Si tienes alguna pregunta o sugerencia sobre nuestra Política de Privacidad, no dudes en contactarnos en orangecode@contact.com.")
            HeadingTextComponent(value = "Terminos y Condiciones")
            LargeTextComponent(value = "Bienvenido a Mente Sana. Antes de utilizar nuestros servicios, te pedimos que leas atentamente estos términos y condiciones.\n" +
                    "\n" +
                    "Aceptación de los Términos y Condiciones: Al acceder o utilizar nuestros servicios, aceptas estar legalmente vinculado por estos términos y condiciones, así como por nuestra política de privacidad.\n" +
                    "\n" +
                    "Uso Apropiado: Te comprometes a utilizar nuestros servicios únicamente con fines legales y de acuerdo con estos términos y condiciones. No deberás utilizar nuestros servicios de manera que pueda dañar, deshabilitar, sobrecargar o perjudicar a Mente Sana.\n" +
                    "\n" +
                    "Propiedad Intelectual: Todos los derechos de propiedad intelectual relacionados con nuestros servicios son propiedad exclusiva de Mente Sana. No se te concede ningún derecho o licencia sobre dichos derechos de propiedad intelectual.\n" +
                    "\n" +
                    "Contenido del Usuario: Al utilizar nuestros servicios, puedes proporcionar cierta información o contenido. Eres el único responsable de la precisión, legalidad y relevancia de dicho contenido. Nos reservamos el derecho de eliminar cualquier contenido que consideremos inapropiado o que viole estos términos y condiciones.\n" +
                    "\n" +
                    "Limitación de Responsabilidad: En la medida máxima permitida por la ley, Mente Sana no será responsable por ningún daño directo, indirecto, incidental, especial, consecuente o punitivo que surja del uso de nuestros servicios.\n" +
                    "\n" +
                    "Modificaciones: Nos reservamos el derecho de modificar o actualizar estos términos y condiciones en cualquier momento y sin previo aviso. Se te notificará cualquier cambio mediante la publicación de los términos y condiciones actualizados en nuestro sitio web.\n" +
                    "\n" +
                    "Al utilizar nuestros servicios, aceptas estos términos y condiciones. Si no estás de acuerdo con alguno de los términos establecidos aquí, te pedimos que no utilices nuestros servicios.\n" +
                    "\n" +
                    "Si tienes alguna pregunta o inquietud sobre estos términos y condiciones, por favor contáctanos.")


        }
    }

    SystemBackButtonHandler {
        MenteSanaAppRouter.navigateTo(Screen.RegisterScreen)
    }

}

@Preview
@Composable
fun TermsAndConditionsScreenPreview() {
    TermsAndConditionsScreen()
}