package com.bestway.carpool.screens.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bestway.carpool.mock.mockAvailableCarPools
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
) {

    val coroutineScope = rememberCoroutineScope()

    var currentLocationValue by rememberSaveable { mutableStateOf("") }

    var destinationLocationValue by rememberSaveable { mutableStateOf("") }

    val listOfAvailableCarPools by rememberSaveable { mutableStateOf(mockAvailableCarPools) }

    var showAvailableCarPools by rememberSaveable { mutableStateOf(false) }

    var showCarPoolLoadingProgressBar by rememberSaveable { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    value = currentLocationValue,
                    label = {
                        Text(
                            text = "Enter you pickup",
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    onValueChange = { newValue ->
                        currentLocationValue = newValue
                    },
                    singleLine = true,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = destinationLocationValue,
                    label = {
                        Text(
                            text = "Enter your destination",
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    onValueChange = { newValue ->
                        destinationLocationValue = newValue
                    },
                    singleLine = true
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    onClick = {
                        coroutineScope.launch {
                            showCarPoolLoadingProgressBar = true
                            delay(1500)
                            showCarPoolLoadingProgressBar = false
                            showAvailableCarPools = true
                        }
                    }
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .alpha(if (showCarPoolLoadingProgressBar) 0f else 1f),
                            text = "Find CarPools"
                        )
                        CircularProgressIndicator(
                            modifier = Modifier
                                .progressSemantics()
                                .size(24.dp)
                                .alpha(if (showCarPoolLoadingProgressBar) 1f else 0f),
                            trackColor = MaterialTheme.colorScheme.primary,
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                    }
                }
            }
        }
        items(
            count = listOfAvailableCarPools.size,
            key = { index ->
                listOfAvailableCarPools[index].firstName + listOfAvailableCarPools[index].lastName
            },
            itemContent = {
                AnimatedVisibility(
                    visible = showAvailableCarPools,
                    enter = slideInVertically()
                ) {
                    CarPoolCard(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(
                                top = 8.dp,
                                bottom = if (it == listOfAvailableCarPools.size - 1) 16.dp else 8.dp
                            ),
                        data = listOfAvailableCarPools[it]
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun HomePrev() {
    Home()
}