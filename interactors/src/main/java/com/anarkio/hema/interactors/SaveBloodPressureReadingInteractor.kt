package com.anarkio.hema.interactors

import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import com.anarkio.hema.data.repositories.BloodPressureReadingRepository
import javax.inject.Inject

class SaveBloodPressureReadingInteractor @Inject constructor(
    private val bloodPressureReadingRepository: BloodPressureReadingRepository
) {
    suspend operator fun invoke(reading: BloodPressureReading): ResultWrapper<BloodPressureReading> {
        return bloodPressureReadingRepository.saveBloodPressureReading(reading)
    }
}