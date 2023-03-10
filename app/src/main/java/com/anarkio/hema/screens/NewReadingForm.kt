package com.anarkio.hema.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.anarkio.hema.R
import com.anarkio.hema.widgets.HemaLabel
import com.anarkio.hema.widgets.HemaTextField

@Composable
fun NewReadingForm(
    viewModel: NewReadingFormViewModel
) {
    Column(
        Modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                HemaTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = stringResource(R.string.systolic),
                    onChanged = { viewModel.updateSystolicBloodPressure(it) },
                    value = viewModel.systolicBloodPressure
                )
                HemaTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = stringResource(R.string.diastolic),
                    onChanged = { viewModel.updateDiastolicBloodPressure(it) },
                    value = viewModel.diastolicBloodPressure
                )
            }

            Column(
                modifier = Modifier.weight(1f),
            ) {
                HemaTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = stringResource(R.string.heartbeat),
                    onChanged = { viewModel.updateHeartRate(it) },
                    value = viewModel.heartRate
                )
            }
        }

        Button(
            onClick = {
                viewModel.onSaveButtonTapped()
            }
        ) {
            Text("Save new reading")
        }
    }
}

@Preview
@Composable
fun Preview_NewReadingForm() {
    NewReadingForm(
        viewModel = NewReadingFormViewModel(
            onSaveNewReading = {}
        )
    )
}