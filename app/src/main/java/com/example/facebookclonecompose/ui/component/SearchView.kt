package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun SearchView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(start = 8.dp,end = 8.dp,top = 16.dp,bottom = 16.dp)
            .fillMaxWidth(1f)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            val (circleProfile, searchInput, photoGallery) = createRefs()
            CircleProfile(modifier = Modifier.constrainAs(circleProfile) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
            Box(
                modifier = Modifier
                    .constrainAs(searchInput) {
                        start.linkTo(circleProfile.end, margin = 16.dp)
                        top.linkTo(parent.top)
                        end.linkTo(photoGallery.start, margin = 8.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }
                    .height(45.dp)
                    .border(
                        BorderStroke(1.dp, Color.Gray),
                        RoundedCornerShape(24.dp)
                    )
                    .clickable {  }
                    .padding(
                        start = 16.dp,
                        end = 4.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    "What's on your mind?",
                    style = TextStyle(fontSize = 14.sp)
                )
            }
            Icon(
                Icons.Outlined.Info,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.constrainAs(photoGallery) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            )
        }
    }
}

@Composable
fun CircleProfile(
    modifier: Modifier
    = Modifier
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .width(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Gray)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun DisplaySearchView() {
    SearchView()
}