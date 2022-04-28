package com.example.facebookclonecompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclonecompose.ui.theme.Blue500

@Composable
fun TabBarView(
    modifier: Modifier = Modifier,
    tabIndex: Int, onTabChanged: (index: Int) -> Unit
) {
    val tabData = listOf(
        Icons.Filled.Home,
        Icons.Filled.ShoppingCart,
        Icons.Filled.AccountBox,
        Icons.Filled.Settings,
        Icons.Filled.MoreVert,
    )
    Column(modifier = modifier) {
        TabRow(
            modifier = Modifier
                .background(Color.White)
                .height(55.dp),
            selectedTabIndex = tabIndex,
            indicator = {
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(it[tabIndex]),
                    color = Blue500
                )
            }
        ) {
            tabData.forEachIndexed { index, icon ->
                val isSelected = index == tabIndex
                Tab(
                    modifier = Modifier.background(Color.White),
                    selected = tabIndex == index,
                    onClick = {
                        onTabChanged(index)
                    }) {
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .padding(8.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .height(28.dp)
                                .width(28.dp),
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (isSelected) Blue500 else Color.Black
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(1.dp)
                .alpha(0.2f)
                .background(
                    Color.Gray
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayTabBarView() {
    TabBarView(tabIndex = 1, onTabChanged = {})
}