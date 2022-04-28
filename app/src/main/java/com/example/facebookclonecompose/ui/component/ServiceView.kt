package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclonecompose.ui.theme.Gray200
import com.example.facebookclonecompose.ui.theme.White100

data class ServiceData(
    val name: String,
    val icon: ImageVector
)

@Composable
fun ServiceView(modifier: Modifier = Modifier) {
    val services = listOf(
        ServiceData(
            name = "Reel",
            icon = Icons.Rounded.Phone
        ),
        ServiceData(
            name = "Room",
            icon = Icons.Rounded.AccountBox
        ),
        ServiceData(
            name = "Status",
            icon = Icons.Rounded.Star
        ),
        ServiceData(
            name = "Group",
            icon = Icons.Rounded.Person
        ),
    )
    Box(
        modifier = modifier
            .background(White100)
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            )

    ) {
        LazyRow {
            items(services) { service ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    ServiceItem(service)
                }
            }
        }
    }
}

@Composable
fun ServiceItem(service: ServiceData) {
    Card(
        modifier = Modifier.clickable { },
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, Gray200),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                service.icon,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Text(service.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayServiceView() {
    ServiceView(modifier = Modifier)
}