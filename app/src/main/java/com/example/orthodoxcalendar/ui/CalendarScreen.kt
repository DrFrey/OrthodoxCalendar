package com.example.orthodoxcalendar.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import kotlinx.coroutines.launch

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
