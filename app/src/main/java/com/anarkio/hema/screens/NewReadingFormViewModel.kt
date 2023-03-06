package com.anarkio.hema.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.anarkio.hema.data.models.BloodPressureReading
import java.util.Calendar

class NewReadingFormViewModel(
    val onSaveNewReading: (BloodPressureReading) -> Unit = {},
) {
    var diastolicBloodPressure by mutableStateOf("")
        private set

    var heartRate by mutableStateOf("")
        private set

    var systolicBloodPressure by mutableStateOf("")
        private set

    fun updateSystolicBloodPressure(input: String) {
        systolicBloodPressure = if (input.toIntOrNull() != null) {
            input
        } else {
            ""
        }
    }

    fun updateDiastolicBloodPressure(input: String) {
        diastolicBloodPressure = if (input.toIntOrNull() != null) {
            input
        } else {
            ""
        }
    }

    fun updateHeartRate(newHeartRate: String) {
        heartRate = if (newHeartRate.toIntOrNull() != null) {
            newHeartRate
        } else {
            ""
        }
    }

    fun onSaveButtonTapped() {
        getNewBloodPressureReading()?.let { onSaveNewReading(it) }
    }

    private fun getNewBloodPressureReading(): BloodPressureReading? {
        val diastolic = diastolicBloodPressure.toIntOrNull() ?: return null
        val nonNullHeartRate = heartRate.toIntOrNull() ?: return null
        val systolic = systolicBloodPressure.toIntOrNull() ?: return null

        return BloodPressureReading(
            dateTime = Calendar.getInstance().timeInMillis,
            diastolicReading = diastolic,
            heartRate = nonNullHeartRate,
            systolicReading = systolic
        )
    }
}