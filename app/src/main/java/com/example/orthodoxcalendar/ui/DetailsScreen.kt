package com.example.orthodoxcalendar.ui

import android.util.Log
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ireward.htmlcompose.HtmlText

@Composable
fun DetailsScreen(
    detailType: String,
    id: Int,
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val viewModel: DetailsViewModel = hiltViewModel()
    val isLoading = viewModel.isLoading
    val holidayData = viewModel.holidayData
    val saintData = viewModel.saintData

    when (detailType) {
        DetailTypes.HOLIDAY.name -> {
            LaunchedEffect(Unit) {
                viewModel.getHoliday(id)
            }
        }
        DetailTypes.SAINT.name -> {
            LaunchedEffect(Unit) {
                viewModel.getSaint(id)
            }
        }
    }

    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    AnimatedContainer(state = state) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = { Text(text = "Details") },
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(Icons.Filled.ArrowBack, "back")
                        }
                    }
                )
            }
        ) {
            Log.d(
                "___",
                "DetailsScreen recomposed; ${holidayData.hashCode()}; viemodel = ${viewModel.hashCode()}"
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .align(Alignment.Center)
                    )
                } else {
                    when (detailType) {
                        DetailTypes.HOLIDAY.name -> {
                            ShowDetails(
                                title = holidayData?.body?.title ?: "",
                                description = holidayData?.body?.description ?: ""
                            )
                        }
                        DetailTypes.SAINT.name -> {
                            ShowDetails(
                                title = saintData?.body?.title ?: "",
                                description = saintData?.body?.description ?: ""
                            )

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowDetails(
    title: String,
    description: String
) {
    Column {
        HtmlText(
            text = title,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h5
        )

        val scroll = rememberScrollState(0)

        HtmlText(
            text = description,
            modifier = Modifier
                .padding(4.dp)
                .verticalScroll(scroll),
            style = MaterialTheme.typography.body1,
        )
    }
}

enum class DetailTypes {
    HOLIDAY, SAINT
}