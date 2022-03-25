package com.supertimer.presentation.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class TimerViewModel: ViewModel() {

    private val _times = MutableStateFlow(0)
    val times: StateFlow<Int> get() = _times
    private var job : Job? = null

    fun start(times: Int = 60) {
        if (_times.value == 0) _times.value = times
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            while (isActive) {
                if (_times.value <= 0) {
                    job?.cancel()
                    return@launch
                }
                delay(timeMillis = 1000)
                _times.value -= 1
            }
        }
    }

    fun pause() {
        job?.cancel()
    }

    fun stop() {
        job?.cancel()
        _times.value = 0
    }

}
