package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.orthodoxcalendar.R
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.ireward.htmlcompose.HtmlText

@Composable
fun FastingRow(
    fasting: List<DayLocal.Fasting?>
) {
    val current = fasting.first()
    current?.let {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (current.fasting.isNotEmpty()) {
                HtmlText(
                    text = current.fasting,
                    style = MaterialTheme.typography.body1
                )
            }
            if (current.roundWeek.isNotEmpty()) {
                HtmlText(
                    text = current.roundWeek,
                    style = MaterialTheme.typography.body2
                )
            }
            if (current.weeks.isNotEmpty()) {
                HtmlText(
                    text = current.weeks,
                    style = MaterialTheme.typography.body2
                )
            }

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