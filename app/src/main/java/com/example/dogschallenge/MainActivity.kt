package com.example.dogschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dogschallenge.navigation.AppNavigation
import com.example.dogschallenge.ui.theme.DogsChallengeTheme


class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsChallengeTheme {
                AppNavigation()
            }
        }
    }
}


