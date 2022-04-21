package com.supertimer.presentation.timer

sealed class TimerInteraction {
    data class Start(val seconds: Int = 60): TimerInteraction()
    object Pause : TimerInteraction()
    object Stop: TimerInteraction()
}
