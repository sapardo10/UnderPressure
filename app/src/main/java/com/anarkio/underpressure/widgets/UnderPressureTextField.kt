package com.anarkio.underpressure.widgets

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import com.anarkio.underpressure.utils.UnderPressureConstants.EMPTY_STRING

@Composable
fun UnderPressureTextField(
    onChanged: (String) -> Unit,
    value: String = EMPTY_STRING
) {
    TextField(value = value, onValueChange = onChanged)
}