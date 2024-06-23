package com.teg.myheartbeats.presentation.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.teg.myheartbeats.presentation.auth.login.LoginScreen

@Composable
fun HeartBeatsComposable() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {  }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Surface {
                LoginScreen(
                    navigateToHome = {  },
                    navigateToForgotPassword = {  },
                    navigateToRegister = {  }
                )
            }
        }
    }
}