package com.supertimer.presentation.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {

    private var job: Job? = null

    private val _state = MutableStateFlow(TimerState(0))
    val state: StateFlow<TimerState> get() = _state

    fun interact(interaction: TimerInteraction) {
        when (interaction) {
            is TimerInteraction.Start -> start(interaction.seconds)
            is TimerInteraction.Pause -> pause()
            is TimerInteraction.Stop -> stop()
        }
    }

    private fun start(times: Int) {

        if (_state.value.seconds == 0)
            _state.update { it.copy(seconds = times) }

        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            while (isActive) {
                if (_state.value.seconds <= 0) {
                    job?.cancel()
                    return@launch
                }
                delay(timeMillis = 1000)
                _state.update { it.copy(it.seconds - 1) }
            }
        }
    }

    private fun pause() {
        job?.cancel()
    }

    private fun stop() {
        job?.cancel()
        _state.update { it.copy(0) }
    }

}
