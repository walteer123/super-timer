package com.supertimer.presentation.timer

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier


@Composable
fun Chrono(
    seconds: Int,
    modifier: Modifier = Modifier
) {
    val progressAngle by animateFloatAsState(
        targetValue = 360f / 30f * seconds,
        animationSpec = tween(500)
    )

   Box(
       modifier = modifier
           .fillMaxWidth()
           .aspectRatio(1f)
   ) {
       CircularProgressTimer(
           angle = progressAngle
       )
   }

}