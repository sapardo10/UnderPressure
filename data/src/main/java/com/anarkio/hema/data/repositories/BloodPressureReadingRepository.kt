package com.anarkio.hema.data.repositories

import com.anarkio.hema.data.datasources.IBloodPressureReadingLocalDataSource
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import javax.inject.Inject

class BloodPressureReadingRepository @Inject constructor(
    private val localDataSource: IBloodPressureReadingLocalDataSource
) {

    fun getAllBloodPressureReadings(): ResultWrapper<List<BloodPressureReading>> {
        val readings = localDataSource.getAll()
        return ResultWrapper.Success(readings)
    }

    fun saveBloodPressureReading(reading: BloodPressureReading): ResultWrapper<BloodPressureReading> {
        localDataSource.save(reading)
        return ResultWrapper.Success(reading)
    }
}