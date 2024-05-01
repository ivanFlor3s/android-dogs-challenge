package com.example.dogschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.dogschallenge.navigation.AppNavigation
import com.example.dogschallenge.services.RetrofitServiceFactory
import com.example.dogschallenge.ui.theme.DogsChallengeTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        val service = RetrofitServiceFactory.create()
        lifecycleScope.launch {
            val breeds = service.listBreeds()
            println(breeds)
        }

        super.onCreate(savedInstanceState)
        setContent {
            DogsChallengeTheme {
                AppNavigation()
            }
        }
    }
}


