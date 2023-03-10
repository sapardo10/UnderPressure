package com.anarkio.hema.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.EMPTY_STRING_ARRAY
import com.anarkio.hema.data.models.BloodPressureReading
import com.anarkio.hema.data.models.ResultWrapper
import com.anarkio.hema.data.utils.HemaConstants.EMPTY_STRING
import com.anarkio.hema.interactors.DeleteBloodPressureReadingInteractor
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
    private val deleteBloodPressureReadingInteractor: DeleteBloodPressureReadingInteractor,
    private val getAllBloodPressureReadingsInteractor: GetAllBloodPressureReadingsInteractor,
    private val saveBloodPressureReadingInteractor: SaveBloodPressureReadingInteractor,
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()
    val newReadingFormViewModel by lazy {
        NewReadingFormViewModel(onSaveNewReading = this::onSaveButtonClicked)
    }

    init {
        getBloodPressureReadingsViewModel()
    }

    private fun onDeleteItem(pressureReading: BloodPressureReading) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBloodPressureReadingInteractor.invoke(pressureReading)
        }
    }

    private fun onSaveButtonClicked(reading: BloodPressureReading) {
        viewModelScope.launch(Dispatchers.IO) {
            saveBloodPressureReadingInteractor.invoke(reading)
            newReadingFormViewModel.cleanForm()
            getBloodPressureReadingsViewModel()
        }
    }

    private fun getBloodPressureReadingsViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getAllBloodPressureReadingsInteractor.invoke()
            if (result is ResultWrapper.Success) {
                val flow = result.value
                flow.collect { list ->
                    if (list.isEmpty()) {
                        _uiState.value = HomeScreenState.NoReadings
                    } else {
                        _uiState.value = HomeScreenState.ListLoaded(list.map {
                            val calendar: Calendar = Calendar.getInstance()
                            calendar.timeInMillis = it.dateTime
                            PressureRecordingItemViewModel(
                                date = calendar,
                                diastolicReading = it.diastolicReading,
                                heartRate = it.heartRate,
                                onDeleteItemTapped = {
                                    this@HomeScreenViewModel.onDeleteItem(it)
                                },
                                systolicReading = it.systolicReading
                            )
                        })
                    }
                }
            } else {
                _uiState.value = HomeScreenState.Error
            }

        }
    }
}

sealed class HomeScreenState {
    object Error: HomeScreenState()
    object NoReadings: HomeScreenState()
    data class ListLoaded(val readings: List<PressureRecordingItemViewModel>): HomeScreenState()
    object Loading: HomeScreenState()
}