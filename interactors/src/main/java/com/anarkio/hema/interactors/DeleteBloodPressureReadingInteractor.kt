package com.anarkio.hema.interactors

import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.repositories.BloodPressureReadingRepository
import javax.inject.Inject

class DeleteBloodPressureReadingInteractor @Inject constructor(
    private val bloodPressureReadingRepository: BloodPressureReadingRepository
) {

    suspend operator fun invoke(reading: BloodPressureReading) {
        bloodPressureReadingRepository.deleteBloodPressureReading(reading)
    }
}