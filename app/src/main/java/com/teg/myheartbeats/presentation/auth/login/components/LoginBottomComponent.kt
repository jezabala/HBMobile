package com.teg.myheartbeats.presentation.auth.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teg.myheartbeats.presentation.components.ButtonComponent

@Composable
fun LoginBottomComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    onButtonClick: () -> Unit
) {


    OutlinedButton(
        onClick = onButtonClick,
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }

}