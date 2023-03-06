package com.anarkio.hema.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anarkio.hema.R
import com.anarkio.hema.widgets.HemaLabel
import com.anarkio.hema.widgets.HemaTextField

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val homeScreenState by viewModel.uiState.collectAsState()

    HomeScreenContent(
        homeScreenState = homeScreenState,
        newReadingFormViewModel = viewModel.newReadingFormViewModel
    )
}

@Composable
fun HomeScreenContent(
    homeScreenState: HomeScreenState,
    newReadingFormViewModel: NewReadingFormViewModel
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NewReadingForm(viewModel = newReadingFormViewModel)
        when(homeScreenState) {
            HomeScreenState.NoReadings -> Text("No readings")
            HomeScreenState.Error -> Text("Error fetching readings")
            is HomeScreenState.ListLoaded -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(homeScreenState.readings) {
                        PressureRecordingItem(viewModel = it)
                    }
                }
            }
            HomeScreenState.Loading -> CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun Preview_HomeScreen() {
    HomeScreenContent(
        homeScreenState = HomeScreenState.NoReadings,
        newReadingFormViewModel = NewReadingFormViewModel()
    )
}