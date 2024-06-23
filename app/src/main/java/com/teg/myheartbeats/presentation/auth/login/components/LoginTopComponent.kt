package com.teg.myheartbeats.presentation.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teg.myheartbeats.R

@Composable
fun LoginTopComponent(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo_heart_beats_app),
        contentDescription = null,
        modifier = modifier.size(200.dp)
    )
}
