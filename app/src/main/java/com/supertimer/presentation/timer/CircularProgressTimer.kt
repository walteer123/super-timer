package com.supertimer.presentation.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun CircularProgressTimer(
    progressColor: Color = Color.Red,
    currentTime: String = "30 s",
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
    angle : Float = 240f
) {
    Box(
        modifier
            .fillMaxSize()
            .padding(30.dp)
            .drawBehind {
                drawArc(
                    color = Color.White,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 30f)
                )
                drawArc(
                    brush = Brush.verticalGradient(listOf(Color.Yellow, Color.Red, Color.Magenta)),
                    startAngle = -90f,
                    sweepAngle = angle,
                    useCenter = false,
                    style = Stroke(width = 30f, cap = StrokeCap.Round)
                )
            }
    )
}

@Preview
@Composable
fun PreviewCircularProgressTimer(){
    CircularProgressTimer()
}
