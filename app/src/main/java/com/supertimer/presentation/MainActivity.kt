package com.supertimer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.supertimer.presentation.theme.SuperTimerTheme
import com.supertimer.presentation.timer.Chrono
import com.supertimer.presentation.timer.TimerViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = getViewModel<TimerViewModel>()
            val times by viewModel.times.collectAsState()
            viewModel.start()
            SuperTimerTheme {
                Chrono(seconds = times)
            }
        }
    }
}
