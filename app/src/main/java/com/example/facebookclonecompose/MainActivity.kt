package com.example.facebookclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.facebookclonecompose.ui.component.*
import com.example.facebookclonecompose.ui.theme.FacebookCloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookCloneComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun MainView() {
    var tabIndex by rememberSaveable { mutableStateOf(0) }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        val (appToolbarView, tabView, searchView, serviceView, feedView) = createRefs()
        AppToolbar(
            modifier = Modifier.constrainAs(appToolbarView) {
                top.linkTo(parent.top)
            }
        )
        TabBarView(
            modifier = Modifier.constrainAs(tabView) {
                top.linkTo(appToolbarView.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            tabIndex = tabIndex, onTabChanged = {
                tabIndex = it
            })
        val items = listOf("","","")
        LazyColumn(modifier = Modifier
            .constrainAs(feedView) {
                top.linkTo(tabView.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }) {
            itemsIndexed(items) { index, item ->
                when (index) {
                    0 -> {
                        SearchView()
                    }
                    1 -> {
                        ServiceView()
                    }
                    else -> FeedView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayMainView() {
    MainView()
}
