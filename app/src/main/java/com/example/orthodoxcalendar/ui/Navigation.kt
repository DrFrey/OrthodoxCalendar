package com.example.orthodoxcalendar.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.*
import androidx.navigation.compose.composable

object MainDestinations {
    const val HOME = "Home"
    const val CALENDAR_SCREEN = "Calendar"
    const val DETAILS_SCREEN = "Details"

}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
internal fun NavGraphBuilder.navGraph(
    navController: NavHostController
) {
    navigation(
        route = MainDestinations.HOME,
        startDestination = MainDestinations.CALENDAR_SCREEN
    ) {
        calendarGraph(navController = navController)
        bottomBarGraph(navController = navController)
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.calendarGraph(
    navController: NavHostController
) {
    composable(MainDestinations.CALENDAR_SCREEN) {
        CalendarScreen(navController = navController, saintsVisible = true, textsVisible = false)
    }
    composable(
        route = "${MainDestinations.DETAILS_SCREEN}/{text}",
        arguments = listOf(navArgument("text") { type = NavType.StringType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        arguments.getString("text")?.let {
            DetailsScreen(it)
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.bottomBarGraph(
    navController: NavHostController
) {
    composable(BottomNavigationScreens.Saints.route) {
        Log.d("___", "BottomNavigationScreens.Saints clicked")
        CalendarScreen(navController = navController, saintsVisible = true, textsVisible = false)
    }
    composable(BottomNavigationScreens.Texts.route) {
        Log.d("___", "BottomNavigationScreens.Texts clicked")
        CalendarScreen(navController = navController, saintsVisible = false, textsVisible = true)
    }
}