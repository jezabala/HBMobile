package com.teg.myheartbeats.presentation.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.teg.myheartbeats.presentation.components.OutlinedTextFieldComponent

@Composable
fun EmailComponent(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    OutlinedTextFieldComponent(
        value = email,
        onValueChange = onEmailChange,
        modifier = modifier
            .fillMaxWidth(),
        label = {
            Text(
                text = "Correo electronico",
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold
            )
        },
        placeholder = {
            Text(
                text = "Tu correo electronico",
                fontSize = 14.sp,
                color = Color.DarkGray,
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Color.DarkGray,
            unfocusedLabelColor = Color.DarkGray,
            focusedPlaceholderColor = Color.DarkGray,
            unfocusedPlaceholderColor = Color.DarkGray,
            focusedBorderColor = Color.DarkGray,
            unfocusedBorderColor = Color.DarkGray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        isError = !isError
    )
}
