package com.anarkio.hema.data.datasources

import com.anarkio.hema.data.models.BloodPressureReading
import kotlinx.coroutines.flow.Flow

interface IBloodPressureReadingLocalDataSource {

    suspend fun delete(reading: BloodPressureReading)

    fun getAll(): Flow<List<BloodPressureReading>>

    suspend fun save(bloodPressureReading: BloodPressureReading)
}