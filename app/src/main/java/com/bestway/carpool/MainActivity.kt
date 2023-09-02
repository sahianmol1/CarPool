package com.bestway.carpool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bestway.carpool.screens.homescreen.Home
import com.bestway.carpool.ui.theme.CarPoolTheme

//import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

//        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CarPoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}
