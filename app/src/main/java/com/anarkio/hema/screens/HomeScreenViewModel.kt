package com.anarkio.hema.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import com.anarkio.hema.interactors.GetAllBloodPressureReadingsInteractor
import com.anarkio.hema.interactors.SaveBloodPressureReadingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllBloodPressureReadingsInteractor: GetAllBloodPressureReadingsInteractor,
    private val saveBloodPressureReadingInteractor: SaveBloodPressureReadingInteractor,
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    var systolicBloodPressure = 0
    var diastolicBloodPressure = 0
    var heartRate = 0

    init {
        getBloodPressureReadingsViewModel()
    }

    private fun getBloodPressureReadingsViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getAllBloodPressureReadingsInteractor.invoke()
            if (result is ResultWrapper.Success) {
                val list = result.value
                if (list.isEmpty()) {
                    _uiState.value = HomeScreenState.NoReadings
                } else {
                    _uiState.value = HomeScreenState.ListLoaded(list)
                }
            } else {
                _uiState.value = HomeScreenState.Error
            }

        }
    }

    fun saveNewReading() {
        viewModelScope.launch(Dispatchers.IO) {
            saveBloodPressureReadingInteractor.invoke(
                BloodPressureReading(
                    dateTime = Calendar.getInstance().timeInMillis,
                    diastolicReading = diastolicBloodPressure,
                    heartRate = heartRate,
                    systolicReading = systolicBloodPressure
                )
            )
            getBloodPressureReadingsViewModel()
        }
    }
}

sealed class HomeScreenState {
    object Error: HomeScreenState()
    object NoReadings: HomeScreenState()
    data class ListLoaded(val readings: List<BloodPressureReading>): HomeScreenState()
    object Loading: HomeScreenState()
}