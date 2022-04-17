package com.supertimer.di

import com.supertimer.presentation.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.dsl.module

val presentationModule = module {
    viewModel { TimerViewModel() }
}

fun KoinApplication.injectModules() = modules(
    presentationModule
)
