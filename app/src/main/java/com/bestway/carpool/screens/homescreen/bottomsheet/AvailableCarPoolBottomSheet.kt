package com.bestway.carpool.screens.homescreen.bottomsheet

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bestway.carpool.mock.mockAvailableCarPools
import com.bestway.carpool.screens.homescreen.CarPoolCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvailableCarPoolBottomSheet(
    modifier: Modifier = Modifier
) {
    val listOfAvailableCarPools by rememberSaveable { mutableStateOf(mockAvailableCarPools) }
    LazyColumn {
        items(
            count = listOfAvailableCarPools.size,
            key = { index ->
                listOfAvailableCarPools[index].firstName + listOfAvailableCarPools[index].lastName
            },
            itemContent = {
                CarPoolCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(
                            top = if (it == 0) 16.dp else 8.dp,
                            bottom = if (it == listOfAvailableCarPools.size - 1) 16.dp else 8.dp
                        ),
                    data = listOfAvailableCarPools[it]
                )
            }
        )
    }

}