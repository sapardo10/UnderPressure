package com.anarkio.hema.widgets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun HemaLabel(
    fontStyle: TextStyle = MaterialTheme.typography.body1,
    text: String
) {
    Text(
        text = text,
        style = fontStyle
    )
}