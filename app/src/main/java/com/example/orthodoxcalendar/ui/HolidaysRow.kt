package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.orthodoxcalendar.R
import com.example.orthodoxcalendar.domain.models.DayLocal

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HolidaysRow(
    modifier: Modifier = Modifier,
    holidays: List<DayLocal.Holiday>,
    navController: NavHostController
//    onCardClicked: (DayLocal.Holiday) -> Unit
) {
    if (holidays.size == 1 && holidays[0].title.isEmpty()) {
        Text(
            text = stringResource(R.string.no_holidays),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            style = MaterialTheme.typography.body2
        )
    } else {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(holidays) { holiday ->
                HolidayCard(
                    holiday = holiday,
                    onCardClicked = {
                        navController.navigate(
                            "${MainDestinations.DETAILS_SCREEN}/${it.title}"
                        )
                    }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HolidayCard(
    modifier: Modifier = Modifier,
    holiday: DayLocal.Holiday,
    onCardClicked: (DayLocal.Holiday) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        onClick = { onCardClicked(holiday) }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            when (holiday.ideograph) {
                1 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_1),
                    contentDescription = null
                )
                2 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_2),
                    contentDescription = null
                )
                3 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_3),
                    contentDescription = null
                )
                4 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_4),
                    contentDescription = null
                )
                5 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_5),
                    contentDescription = null
                )
                else -> {}
            }
            Text(
                text = holiday.title,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}
