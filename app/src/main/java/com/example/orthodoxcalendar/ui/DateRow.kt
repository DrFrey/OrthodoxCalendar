package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
fun DateRowPreview() {
    DateRow(Modifier.fillMaxWidth(), "18", "февраля")
}