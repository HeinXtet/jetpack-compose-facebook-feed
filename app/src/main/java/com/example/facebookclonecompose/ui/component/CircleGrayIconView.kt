package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.facebookclonecompose.ui.theme.White200

@Composable
fun CircleGrayIcon(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(White200)
            .clickable {  },
        contentAlignment = Alignment.Center,
        ) {
        content()
    }
}