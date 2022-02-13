package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.ireward.htmlcompose.HtmlText

@ExperimentalFoundationApi
@Composable
fun TextsScreen(
    modifier: Modifier = Modifier,
    texts: List<DayLocal.Text>,
    navController: NavController
) {
    Column {

    }
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(all = 4.dp)
    ) {
        items(texts) { text ->
            TextCard(text = text)
        }
    }
}

@Composable
fun TextCard(modifier: Modifier = Modifier, text: DayLocal.Text) {
    Card(
        modifier = modifier
            .padding(all = 4.dp)
            .fillMaxWidth(),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        HtmlText(
            text = text.text,
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.body2
        )
    }
}
