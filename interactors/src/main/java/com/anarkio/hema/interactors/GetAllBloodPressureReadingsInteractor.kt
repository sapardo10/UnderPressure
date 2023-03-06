package com.anarkio.hema.interactors

import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import com.anarkio.hema.data.repositories.BloodPressureReadingRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAllBloodPressureReadingsInteractor @Inject constructor(
    private val bloodPressureReadingRepository: BloodPressureReadingRepository
) {
    suspend operator fun invoke(): ResultWrapper<Flow<List<BloodPressureReading>>> {
        return bloodPressureReadingRepository.getAllBloodPressureReadings()
    }
}