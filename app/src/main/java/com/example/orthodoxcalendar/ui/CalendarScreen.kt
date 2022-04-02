package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CalendarScreen(
    navController: NavHostController,
    saintsVisible: Boolean,
    textsVisible: Boolean
) {
    val viewModel: CalendarViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()

    val dateField = viewModel.currentDateFormatted
    val isLoading = viewModel.isLoading
    val error = viewModel.error
    val saints = viewModel.saintItems
    val holidays = viewModel.holidayItems
    val icons = viewModel.iconItems
    val texts = viewModel.textItems
    val fasting = viewModel.fasting

    Column(
        modifier = Modifier
    ) {
        DateRow(
            modifier = Modifier
                .fillMaxWidth(),
            dayTextField = dateField.split(' ')[0],
            monthTextField = dateField.split(' ')[1]
        )
        Divider()
        Box(modifier = Modifier.fillMaxSize()) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.Center)
                )
            } else {
                Column(
                    modifier = Modifier
                ) {
                    FastingRow(fasting = fasting)
                    Divider()
                    HolidaysRow(
                        holidays = holidays,
                        navController = navController
                    )
                    Divider()
                    SaintsScreen(saints = saints, isVisible = saintsVisible, navController = navController)
                    TextsScreen(texts = texts, isVisible = textsVisible, navController = navController)
                }
            }
        }
    }
}
