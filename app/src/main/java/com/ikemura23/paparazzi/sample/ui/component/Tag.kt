package com.ikemura23.paparazzi.sample.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikemura23.paparazzi.sample.ui.theme.AndroidPaparazziSampleTheme

@Composable
fun Tag(
    name: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.inversePrimary,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    Text(
        text = "#$name".lowercase(),
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.small,
            )
            .padding(horizontal = 4.dp, vertical = 2.dp),
        color = contentColor,
        fontSize = 12.sp,
    )
}

@Preview
@Composable
private fun TagPreview() {
    AndroidPaparazziSampleTheme {
        Tag("preview")
    }
}
