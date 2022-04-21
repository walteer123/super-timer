package com.supertimer.presentation.timer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun TimerScreen(
    viewModel: TimerViewModel = getViewModel()
) {
    val state = viewModel.state.collectAsState().value

    Column {
        Chrono(seconds = state.seconds)

        Row {
            Button(onClick = { viewModel.interact(TimerInteraction.Start(10)) }) {
                Text(text = "Start")
            }
            Button(onClick = { viewModel.interact(TimerInteraction.Pause) }) {
                Text(text = "Pause")
            }
            Button(onClick = { viewModel.interact(TimerInteraction.Stop) }) {
                Text(text = "Stop")
            }
        }
    }
}

@Preview
@Composable
fun PreviewTimerScreen() {
    TimerScreen()
}