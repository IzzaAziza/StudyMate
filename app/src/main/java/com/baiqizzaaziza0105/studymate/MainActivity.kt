package com.baiqizzaaziza0105.studymate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.baiqizzaaziza0105.studymate.screen.MainScreen
import com.baiqizzaaziza0105.studymate.ui.theme.StudyMateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyMateTheme {
                MainScreen()
            }
        }
    }
}

