package com.supertimer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.supertimer.presentation.theme.SuperTimerTheme
import com.supertimer.presentation.timer.TimerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperTimerTheme {
                TimerScreen()
            }
        }
    }
}
