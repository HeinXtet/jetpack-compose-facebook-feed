package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclonecompose.R


@Composable
fun AppToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(
                end = 8.dp
            )
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.height(50.dp),
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = null
        )
        Box(
            modifier = Modifier.weight(
                1f,
                fill = true
            )
        )
        CircleGrayIcon() {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        CircleGrayIcon() {
            Icon(
                Icons.Outlined.MailOutline,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayAppToolbar() {
    AppToolbar()
}