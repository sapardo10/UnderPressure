package com.anarkio.hema.interactors

import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import com.anarkio.hema.data.repositories.BloodPressureReadingRepository
import javax.inject.Inject

class GetAllBloodPressureReadingsInteractor @Inject constructor(
    private val bloodPressureReadingRepository: BloodPressureReadingRepository
) {
    operator fun invoke(): ResultWrapper<List<BloodPressureReading>> {
        return bloodPressureReadingRepository.getAllBloodPressureReadings()
    }
}