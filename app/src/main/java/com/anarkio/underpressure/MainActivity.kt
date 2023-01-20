package com.anarkio.underpressure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anarkio.underpressure.ui.theme.UnderPressureTheme
import com.anarkio.underpressure.widgets.UnderPressureLabel
import com.anarkio.underpressure.widgets.UnderPressureTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnderPressureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row {
                        Column {
                            UnderPressureLabel(text = getString(R.string.systolic_blood_pressure))
                            UnderPressureTextField(onChanged = { _ -> } )
                        }
                        Column {
                            UnderPressureLabel(text = getString(R.string.diastolic_blood_pressure))
                            UnderPressureTextField(onChanged = { _ -> } )
                        }
                        Column {
                            UnderPressureLabel(text = getString(R.string.heatbeat))
                            UnderPressureTextField(onChanged = { _ -> } )
                        }
                    }
                }
            }
        }
    }
}