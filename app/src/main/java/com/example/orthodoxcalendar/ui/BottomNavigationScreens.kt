package com.example.orthodoxcalendar.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.orthodoxcalendar.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Saints : BottomNavigationScreens("Saints", R.string.saints_and_holidays, Icons.Filled.Person)
    object Texts : BottomNavigationScreens("Texts", R.string.texts, Icons.Filled.Book)
}
