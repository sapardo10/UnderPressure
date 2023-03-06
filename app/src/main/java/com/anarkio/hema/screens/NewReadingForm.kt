package com.anarkio.hema.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.anarkio.hema.R
import com.anarkio.hema.widgets.HemaLabel
import com.anarkio.hema.widgets.HemaTextField

@Composable
fun NewReadingForm(
    viewModel: NewReadingFormViewModel
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            HemaLabel(text = stringResource(R.string.systolic_blood_pressure))
            HemaTextField(
                onChanged = { viewModel.updateSystolicBloodPressure(it) },
                value = viewModel.systolicBloodPressure
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            HemaLabel(text = stringResource(R.string.diastolic_blood_pressure))
            HemaTextField(
                onChanged = { viewModel.updateDiastolicBloodPressure(it) },
                value = viewModel.diastolicBloodPressure
            )
        }
    }

    Column {
        HemaLabel(text = stringResource(R.string.heartbeat))
        HemaTextField(
            onChanged = { viewModel.updateHeartRate(it) },
            value = viewModel.heartRate
        )
    }

    Button(
        onClick = {
            viewModel.onSaveButtonTapped()
        }
    ) {
        Text("Save new reading")
    }
}