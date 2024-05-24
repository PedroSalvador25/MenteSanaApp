package com.orangecode.mentesana.data.home

import com.orangecode.mentesana.R
import com.orangecode.mentesana.navigation.MenteSanaAppRouter
import com.orangecode.mentesana.navigation.Screen
import com.orangecode.mentesana.ui.theme.CyanPrimary
import com.orangecode.mentesana.ui.theme.CyanSecondary
import com.orangecode.mentesana.ui.theme.GrayCyan

val diario = Option(
    title = "Diario",
    R.drawable.diary,
    description = "Escribe acerca de tu dia",
    Screen.DiarioScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)

val comunidad = Option(
    title = "Comunidad",
    R.drawable.comunity,
    description = "Comparte tu dia y mira las publicaciones de los demas",
    Screen.ComunityScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)

val meditacion = Option(
    title = "Meditacion",
    R.drawable.meditation,
    description = "Mira las distintas formas para meditar",
    Screen.MeditationScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)

val estiloVida = Option(
    title = "Estilo de vida",
    R.drawable.lifestyle,
    description = "Lleva un control de tus habitos",
    Screen.LifeStyleScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)

val respiracion = Option(
    title = "Respiracion",
    R.drawable.breath,
    description = "Mira las diferentes tecnicas de respiracion",
    Screen.BreathScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)

val lineaAyuda = Option(
    title = "Linea de Ayuda",
    R.drawable.helpline,
    description = "Te brindamos contactos de ayuda y profesionales",
    Screen.HelpLineScreen,
    CyanPrimary,
    CyanSecondary,
    GrayCyan
)