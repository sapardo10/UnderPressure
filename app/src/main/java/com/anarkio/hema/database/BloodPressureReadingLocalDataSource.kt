package com.anarkio.hema.database

import com.anarkio.hema.data.datasources.IBloodPressureReadingLocalDataSource
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.mappers.toEntity
import com.anarkio.hema.mappers.toModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class BloodPressureReadingLocalDataSource @Inject constructor(
    private val bloodPressureReadingDao: BloodPressureReadingDao
): IBloodPressureReadingLocalDataSource {

    override suspend fun delete(reading: BloodPressureReading) {
        bloodPressureReadingDao.delete(reading.toEntity())
    }

    override fun getAll(): Flow<List<BloodPressureReading>> {
        return bloodPressureReadingDao.getAll().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun save(bloodPressureReading: BloodPressureReading) {
        bloodPressureReadingDao.insert(bloodPressureReading.toEntity())
    }
}