package com.anarkio.hema.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blood_pressure_reading")
data class BloodPressureReadingEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "date_time") val dateTime: Long,
    @ColumnInfo(name = "diastolic_reading") val diastolicReading: Int,
    @ColumnInfo(name = "heart_rate") val heartRate: Int,
    @ColumnInfo(name = "systolic_reading") val systolicReading: Int
)