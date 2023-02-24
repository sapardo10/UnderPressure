package com.anarkio.hema.data.datasources

import com.anarkio.hema.data.models.BloodPressureReading

interface IBloodPressureReadingLocalDataSource {
    fun save(bloodPressureReading: BloodPressureReading)
    fun getAll(): List<BloodPressureReading>
}