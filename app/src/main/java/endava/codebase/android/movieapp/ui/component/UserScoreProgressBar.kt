package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.R

@Composable
fun UserScoreProgressBar(
    grade: Float,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    )
    {
        val tempGrade: String = (grade*100).toString()
        Text(
            text = tempGrade,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
        )
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = Color.LightGray,
                startAngle = 180f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(x = 10.dp.toPx(), y = 10.dp.toPx()),
                style = Stroke(width = 10.dp.toPx()),
            )
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = grade * 360,
                useCenter = false,
                topLeft = Offset(x = 10.dp.toPx(), y = 10.dp.toPx()),
                style = Stroke(width = 10.dp.toPx()),
            )
        }
    }

}

@Preview
@Composable
private fun UserScoreProgressBarPreview() {
    UserScoreProgressBar(
        grade = 0.75f,
        Modifier.size(100.dp)
    )
}
