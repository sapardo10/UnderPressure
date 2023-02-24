package com.anarkio.hema.mappers

import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.database.BloodPressureReadingEntity

fun BloodPressureReading.toEntity(): BloodPressureReadingEntity {
    return BloodPressureReadingEntity(
        dateTime = dateTime,
        diastolicReading = diastolicReading,
        heartRate = heartRate,
        systolicReading = systolicReading,
    )
}

fun BloodPressureReadingEntity.toModel(): BloodPressureReading {
    return BloodPressureReading(
        uid = uid,
        dateTime,
        diastolicReading,
        heartRate,
        systolicReading,
    )
}