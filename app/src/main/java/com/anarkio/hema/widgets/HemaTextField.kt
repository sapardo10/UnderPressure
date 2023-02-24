package com.anarkio.hema.widgets

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import com.anarkio.hema.data.utils.HemaConstants.EMPTY_STRING

@Composable
fun HemaTextField(
    onChanged: (String) -> Unit,
    value: String = EMPTY_STRING
) {
    TextField(value = value, onValueChange = onChanged)
}