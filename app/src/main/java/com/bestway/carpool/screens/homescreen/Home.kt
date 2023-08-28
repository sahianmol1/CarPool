package com.bestway.carpool.screens.homescreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bestway.carpool.mock.mockAvailableCarPools

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val listOfAvailableCarPools = mockAvailableCarPools
    LazyColumn{
        items(
            count = mockAvailableCarPools.size,
            key = { index ->
                mockAvailableCarPools[index].firstName + mockAvailableCarPools[index].lastName
            },
            itemContent = {
                CarPoolCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = if (it == 0) 16.dp else 8.dp, bottom = if( it == mockAvailableCarPools.size - 1) 16.dp else 8.dp),
                    data  = mockAvailableCarPools[it]
                )
            }
        )
    }
}

@Preview
@Composable
fun HomePrev() {
    Home()
}