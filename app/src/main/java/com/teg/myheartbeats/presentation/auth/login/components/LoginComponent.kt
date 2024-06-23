package com.teg.myheartbeats.presentation.auth.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginComponent(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginButtonClick: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Iniciar sesion",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            EmailComponent(
                email = email,
                onEmailChange = onEmailChange
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordComponent(
                password = password,
                onPasswordChange = onPasswordChange
            )
            Spacer(modifier = Modifier.height(14.dp))
            ForgotPasswordComponent(
                onClick = onForgotPasswordClick
            )
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                text = "Iniciar sesion",
                onClick = onLoginButtonClick
            )
        }
    }
}