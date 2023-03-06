package com.anarkio.hema.screens

import com.anarkio.hema.data.models.BloodPressureReading
import java.util.Calendar

class PressureRecordingItemViewModel(
    val date: Calendar,
    val diastolicReading: Int,
    val heartRate: Int,
    val onDeleteItemTapped: () -> Unit,
    val systolicReading: Int,
)