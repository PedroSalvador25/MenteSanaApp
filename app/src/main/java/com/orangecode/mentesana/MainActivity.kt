package com.orangecode.mentesana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.orangecode.mentesana.app.MenteSanaApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenteSanaApp()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MenteSanaApp()
}