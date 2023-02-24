package com.anarkio.hema.data.models

data class BloodPressureReading(
    var uid: Int = 0,
    val dateTime: Long,
    val diastolicReading: Int,
    val heartRate: Int,
    val systolicReading: Int
)