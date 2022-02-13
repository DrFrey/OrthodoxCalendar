package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.orthodoxcalendar.R
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.ireward.htmlcompose.HtmlText

@ExperimentalFoundationApi
@Composable
fun CalendarScreen(viewModel: CalendarViewModel) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val screens = listOf(
        BottomNavigationScreens.Saints,
        BottomNavigationScreens.Holidays,
        BottomNavigationScreens.Texts
    )

    val dateField = viewModel.currentDateFormatted
    val isLoading = viewModel.isLoading
    val error = viewModel.error
    val saints = viewModel.saintItems
    val holidays = viewModel.holidayItems
    val icons = viewModel.iconItems
    val texts = viewModel.textItems
    val fasting = viewModel.fasting

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) { innerPadding ->
        if (error.isNotEmpty()) {
            LaunchedEffect(error) {
                scaffoldState.snackbarHostState.showSnackbar(error)
            }
        }

        Column {
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
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        FastingRow(modifier = Modifier, fasting = fasting)
                        Divider()
                        NavHost(
                            navController = navController,
                            startDestination = BottomNavigationScreens.Saints.route
                        ) {
                            composable(BottomNavigationScreens.Saints.route) {
                                SaintsScreen(
                                    saints = saints,
                                    navController = navController
                                )
                            }
                            composable(BottomNavigationScreens.Holidays.route) {
                                HolidaysScreen(
                                    holidays = holidays,
                                    navController = navController
                                )
                            }
                            composable(BottomNavigationScreens.Texts.route) {
                                TextsScreen(
                                    texts = texts,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DateRow(
    modifier: Modifier,
    dayTextField: String,
    monthTextField: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Filled.ArrowBack, "Back")
        }
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = dayTextField,
                style = MaterialTheme.typography.h4
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = monthTextField,
                style = MaterialTheme.typography.h5
            )
        }
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Filled.ArrowForward, "Forward")
        }
    }
}

@Composable
fun FastingRow(
    modifier: Modifier,
    fasting: List<DayLocal.Fasting?>
) {
    val current = fasting.first()
    current?.let {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (current.fasting.isNotEmpty()) {
                HtmlText(
                    text = current.fasting,
                    style = MaterialTheme.typography.body1
                )
            }
            HtmlText(
                text = stringResource(
                    R.string.week_description,
                    current.roundWeek,
                    current.weeks
                ).trim(),
                style = MaterialTheme.typography.body2
            )
            Row {
                if (current.type == 0) {
                    HtmlText(
                        text = stringResource(R.string.no_fasting),
                        style = MaterialTheme.typography.body2
                    )
                } else {
                    HtmlText(
                        text = stringResource(R.string.fasting_day),
                        style = MaterialTheme.typography.body2
                    )
                }
                HtmlText(
                    text = stringResource(R.string.voice, current.voice ?: ""),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }


}

@Preview
@Composable
fun DateRowPreview() {
    DateRow(Modifier.fillMaxWidth(), "18", "февраля")
}