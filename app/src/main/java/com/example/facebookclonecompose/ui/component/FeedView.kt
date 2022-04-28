package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.facebookclonecompose.R
import com.example.facebookclonecompose.ui.theme.FacebookCloneComposeTheme
import com.example.facebookclonecompose.ui.theme.Gray200


@Composable
fun FeedView() {
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .background(
                Color.Gray
            )
    ) {
        FeedItem()
        FeedItem()
        FeedItem()
        FeedItem()
        FeedItem()
        FeedItem()

        FeedItem()
        FeedItem()
    }
}


@Composable
fun FeedItem() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(
                top = 8.dp,
                bottom = 8.dp,
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp)
        ) {
            ConstraintLayout {
                val (headerView, photoView, lineView, reactionView, bottomLineView) = createRefs()
                FeedHeader(modifier = Modifier.constrainAs(headerView) {
                    top.linkTo(parent.top)
                })
                Image(
                    modifier = Modifier
                        .constrainAs(photoView) {
                            top.linkTo(headerView.bottom)
                        }
                        .fillMaxWidth(1f)
                        .padding(top = 16.dp),
                    painter = painterResource(id = R.drawable.spider),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                SeparatorView(modifier = Modifier
                    .constrainAs(lineView) {
                        top.linkTo(photoView.bottom)
                    })

                Row(
                    modifier = Modifier
                        .constrainAs(reactionView) {
                            top.linkTo(lineView.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }, horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier = Modifier
                        .padding(
                            top = 16.dp, bottom = 16.dp
                        )
                        .clickable { }) {
                        Icon(
                            Icons.Outlined.ThumbUp,
                            contentDescription = null
                        )
                        Text("Reaction", modifier = Modifier.padding(start = 16.dp))
                    }
                    Row(modifier = Modifier
                        .padding(
                            top = 16.dp, bottom = 16.dp
                        )
                        .clickable { }) {
                        Icon(Icons.Outlined.Menu, contentDescription = null)
                        Text("Comment", modifier = Modifier.padding(start = 16.dp))
                    }
                    Row(modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        )
                        .clickable { }) {
                        Icon(Icons.Outlined.Share, contentDescription = null)
                        Text("Share", modifier = Modifier.padding(start = 16.dp))
                    }
                }
                SeparatorView(modifier = Modifier
                    .constrainAs(bottomLineView) {
                        top.linkTo(reactionView.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(
                            parent.end
                        )
                        width = Dimension.fillToConstraints
                    }
                    .constrainAs(lineView) {
                        top.linkTo(photoView.bottom)
                    })

            }
        }
    }
}

@Composable
fun SeparatorView(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .padding(top = 16.dp, bottom = 4.dp)
            .height(0.5.dp)
            .requiredHeight(0.5.dp)
            .background(Gray200)
            .alpha(0.2f)
            .fillMaxWidth(1f)
    )
}

@Composable
fun FeedHeader(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxWidth(1f)) {
        val (profile, profileInfo, hideIcon, moreIcon) = createRefs()
        CircleProfile(modifier = Modifier.constrainAs(profile) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })
        Column(modifier = Modifier.constrainAs(profileInfo) {
            start.linkTo(profile.end, margin = 16.dp)
            end.linkTo(moreIcon.start, margin = 16.dp)
            width = Dimension.fillToConstraints
        }) {
            Text(text = "John Doe")
            Text(
                text = "4m",
                style = MaterialTheme.typography.subtitle2.copy(
                    color = Color.Gray
                )
            )
        }
        Icon(
            Icons.Outlined.MoreVert, contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.constrainAs(moreIcon) {
                end.linkTo(hideIcon.start, margin = 16.dp)
                top.linkTo(parent.top)
            },
        )
        Icon(
            Icons.Outlined.Close, contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.constrainAs(hideIcon) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayFeedView() {
    FacebookCloneComposeTheme() {
        FeedView()
    }
}