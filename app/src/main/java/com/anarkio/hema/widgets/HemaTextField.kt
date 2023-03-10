package com.anarkio.hema.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anarkio.hema.data.utils.HemaConstants.EMPTY_STRING

@Composable
fun HemaTextField(
    label: String,
    keyboardOptions: KeyboardOptions? = null,
    onChanged: (String) -> Unit,
    value: String = EMPTY_STRING
) {
    Card(
        Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        elevation = 10.dp,
    ) {
        Column(
            Modifier.background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier.height(8.dp)
            )
            HemaLabel(
                fontStyle = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold),
                text = label
            )
            Box(
                Modifier.height(8.dp)
            )
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.1f)
                ),
                keyboardOptions = keyboardOptions ?: KeyboardOptions(),
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 16.dp),
                onValueChange = onChanged,
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = value,
            )
            Box(
                Modifier.height(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview_HemaTextField() {
    HemaTextField(label = "Systolic", onChanged = {})
}