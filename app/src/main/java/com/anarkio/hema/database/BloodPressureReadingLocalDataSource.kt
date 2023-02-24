package com.anarkio.hema.database

import com.anarkio.hema.data.datasources.IBloodPressureReadingLocalDataSource
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.mappers.toEntity
import com.anarkio.hema.mappers.toModel
import javax.inject.Inject

class BloodPressureReadingLocalDataSource @Inject constructor(
    private val bloodPressureReadingDao: BloodPressureReadingDao
): IBloodPressureReadingLocalDataSource {
    override fun save(bloodPressureReading: BloodPressureReading) {
        bloodPressureReadingDao.insert(bloodPressureReading.toEntity())
    }

    override fun getAll(): List<BloodPressureReading> {
        return bloodPressureReadingDao.getAll().map { it.toModel() }
    }
}