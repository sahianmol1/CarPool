package com.bestway.carpool.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bestway.carpool.screens.homescreen.bottomsheet.AvailableCarPoolBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
) {

    var currentLocationValue by rememberSaveable {
        mutableStateOf("")
    }

    var destinationLocationValue by rememberSaveable {
        mutableStateOf("")
    }

    BottomSheetScaffold(
        sheetContent = {
            AvailableCarPoolBottomSheet()
        }
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.weight(1f))

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
                    .padding(top = 8.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Find CarPools")
            }

            Spacer(modifier = Modifier.weight(1.5f))
        }
    }
}

@Preview
@Composable
fun HomePrev() {
    Home()
}