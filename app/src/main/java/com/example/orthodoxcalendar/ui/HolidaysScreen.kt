package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.example.orthodoxcalendar.R
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.ireward.htmlcompose.HtmlText

@ExperimentalFoundationApi
@Composable
fun HolidaysScreen(
    modifier: Modifier = Modifier,
    holidays: List<DayLocal.Holiday>,
    navController: NavController
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
                HolidayCard(holiday = holiday)
            }
        }
    }
}

@Composable
fun HolidayCard(modifier: Modifier = Modifier, holiday: DayLocal.Holiday) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Row {
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
            HtmlText(
                text = holiday.title,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.body2
            )
        }
    }
}
