package com.orangecode.mentesana

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

fun Path.starndardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2,
        abs(from.y + to.y) / 2
    )
}