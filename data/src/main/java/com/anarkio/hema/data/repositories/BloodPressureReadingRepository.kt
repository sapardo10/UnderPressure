package com.anarkio.hema.data.repositories

import com.anarkio.hema.data.datasources.IBloodPressureReadingLocalDataSource
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class BloodPressureReadingRepository @Inject constructor(
    private val localDataSource: IBloodPressureReadingLocalDataSource
) {

    suspend fun deleteBloodPressureReading(bloodPressureReading: BloodPressureReading) {
        localDataSource.delete(bloodPressureReading)
    }

    suspend fun getAllBloodPressureReadings(): ResultWrapper<Flow<List<BloodPressureReading>>> {
        val readings = localDataSource.getAll()
        return ResultWrapper.Success(readings)
    }

    suspend fun saveBloodPressureReading(reading: BloodPressureReading): ResultWrapper<BloodPressureReading> {
        localDataSource.save(reading)
        return ResultWrapper.Success(reading)
    }
}