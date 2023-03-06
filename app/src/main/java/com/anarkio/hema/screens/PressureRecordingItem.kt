package com.anarkio.hema.screens

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anarkio.hema.R
import java.util.Calendar

@Composable
fun PressureRecordingItem(viewModel: PressureRecordingItemViewModel) {
    Card(
        backgroundColor = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        viewModel.date.timeInMillis.toString(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(
                        viewModel.diastolicReading.toString(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(
                        viewModel.heartRate.toString(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(
                        viewModel.systolicReading.toString(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                IconButton(
                    onClick = {
                        viewModel.onDeleteItemTapped()
                    }
                ) {
                    Icon(
                        Icons.Rounded.Delete,
                        contentDescription = "Delete current reading",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun Preview_PressureRecordingItem() {
    PressureRecordingItem(PressureRecordingItemViewModel(
        Calendar.getInstance(),
        80,
        60,
        {},
        120,
    ))
}